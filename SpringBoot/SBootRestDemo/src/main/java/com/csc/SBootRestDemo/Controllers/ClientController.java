package com.csc.SBootRestDemo.Controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.aspectj.weaver.AjAttribute.MethodDeclarationLineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.csc.SBootRestDemo.entity.Client;
import com.csc.SBootRestDemo.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Value("${application.name}")
	private String appName;
	
	@GetMapping("/")
	public String base() {
		
		return appName + LocalDateTime.now();
	}
	@GetMapping("/i18")
	public String internatioanlization() {
		
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/clients")
	public List<Client> findAll(){
		
		return clientService.findAll();
	}

	@GetMapping("/clients/{clientId}")
	public Resource<Client> getClient(@PathVariable int clientId) {
		
		Client client=clientService.findById(clientId);
		
		Resource<Client> resource=new Resource<Client>(client);
		ControllerLinkBuilder linkTo=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll());
		resource.add(linkTo.withRel("All Clients"));
		
		return resource;
	}
	
	@PostMapping("/clients")
	public Client addClient(@Valid @RequestBody Client theClient) {
		
		theClient.setId(0);
		clientService.save(theClient);
		
		return theClient;
	}
	
	@PutMapping("/clients")
	public Client updateClient(@RequestBody Client theClient) {
		
		clientService.save(theClient);
		
		return theClient;
	}
	@DeleteMapping("/clients/{clientId}")
	public String deleteClient(@PathVariable int clientId) {
		
		clientService.findById(clientId);
		
		clientService.deletebyId(clientId);
		
		return "Deleted Client "+clientId;
	}
}
