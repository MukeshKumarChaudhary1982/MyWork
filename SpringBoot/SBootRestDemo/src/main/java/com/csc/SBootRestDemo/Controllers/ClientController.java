package com.csc.SBootRestDemo.Controllers;

import java.time.LocalDateTime;
import java.util.List;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;

import com.csc.SBootRestDemo.entity.Client;
import com.csc.SBootRestDemo.service.ClientService;
import com.zaxxer.hikari.HikariDataSource;

@RestController
public class ClientController {
	
	Logger LOGGER=LoggerFactory.getLogger(ClientController.class);
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${application.name}")
	private String appName;
	
	@GetMapping("/info")
	public String base() {
		LOGGER.info("Max pool Size: " + ((HikariDataSource)dataSource).getMaximumPoolSize());
		LOGGER.info("Min Idle: " + ((HikariDataSource)dataSource).getMinimumIdle());
		LOGGER.info("connection query: " + ((HikariDataSource)dataSource).getConnectionTestQuery());
		LOGGER.debug("Idle timeout: " + ((HikariDataSource)dataSource).getIdleTimeout());
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
