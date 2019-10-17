package com.csc.integral.omni.client.Controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csc.integral.omni.client.entity.Address;
import com.csc.integral.omni.client.entity.Client;
import com.csc.integral.omni.client.service.ClientService;

@RestController
public class ClientController {
	
	Logger LOGGER=LoggerFactory.getLogger(ClientController.class);
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@GetMapping("/i18")
	public String internatioanlization() {
		
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/clients")
	public List<Client> findAll(@RequestParam Map<String,String> allParams){
		
		allParams.forEach((k,v) -> LOGGER.debug("Key {} -- Value {}",k,v));
		return clientService.findAll();
	}
	
	/*@GetMapping("/clients")
	public List<Client> findAll(){
		
		return clientService.findAll();
	}*/

	@GetMapping("/clients/{clientId}")
	public Resource<Client> getClient(@PathVariable String clientId) {
		
		Client client=clientService.findById(clientId);
		
		Resource<Client> resource=new Resource<Client>(client);
		ControllerLinkBuilder linkTo=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll(null));
		resource.add(linkTo.withRel("All Clients"));
		
		return resource;
	}
	
	/*@GetMapping("/clients/firstname/{firstName}")
	public Resources<Resource<Client>> getClientByfirstName(@PathVariable String firstName) {
		
		List<Client> clientList=clientService.findByFirstName(firstName);
		
		List<Resource<Client>> clientResources = clientList.stream().map(ClientController::createClientResource).collect(Collectors.toList());
		
		ControllerLinkBuilder linkTo=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll());
		
		Resources<Resource<Client>> resource=new Resources<>(clientResources);
		
		resource.add(linkTo.withRel("All Clients"));
		
		return resource;
	}
	
	private static Resource<Client> createClientResource(Client c) {
	      Resource<Client> res=new Resource<Client>(c);
		 ControllerLinkBuilder employeeLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ClientController.class).findAll());
	      res.add(employeeLink.withRel("All Clients"));
	      return res;
	  }
	*/
	
	@GetMapping("/clients/firstname/{firstName}")
	public Resources<Client> getClientByfirstName(@PathVariable List<String> firstName) {
		
		List<Client> clientList=clientService.findByFirstName(firstName);
		
		Resources<Client> resource=new Resources<Client>(clientList);
		ControllerLinkBuilder linkTo=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll(null));
		resource.add(linkTo.withRel("All Clients"));
		
		return resource;
	}
	
	@GetMapping("/clients/lastname/{lastName}")
	public Resources<Client> getClientByLastName(@PathVariable List<String> lastName) {
		
		List<Client> clientList=clientService.findBylastName(lastName);
		
		Resources<Client> resource=new Resources<Client>(clientList);
		ControllerLinkBuilder linkTo=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll(null));
		resource.add(linkTo.withRel("All Clients"));
		
		return resource;
	}
	
	@PostMapping("/clients")
	public Client addClient(@Valid @RequestBody Client theClient) {
		
		//theClient.setId(0);
				
		clientService.save(theClient);
		
		return theClient;
	}
	
	@PutMapping("/clients")
	public Client updateClient(@RequestBody Client theClient) {
		
		clientService.findById(theClient.getId());
		
		clientService.save(theClient);
		
		return theClient;
	}
	@DeleteMapping("/clients/{clientId}")
	public String deleteClient(@PathVariable String clientId) {
		
		clientService.findById(clientId);
		
		clientService.deletebyId(clientId);
		
		return "Deleted Client "+clientId;
	}
	
	 
}
