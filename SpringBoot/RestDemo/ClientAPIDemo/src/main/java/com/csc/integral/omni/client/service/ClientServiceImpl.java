package com.csc.integral.omni.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csc.integral.omni.client.dao.AddressRepository;
import com.csc.integral.omni.client.dao.ClientRepository;
import com.csc.integral.omni.client.entity.Address;
import com.csc.integral.omni.client.entity.Client;
import com.csc.integral.omni.client.exception.ClientNotFoundException;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	@Transactional
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	@Transactional
	public Client findById(String theId) {
		// TODO Auto-generated method stub
		Optional<Client> result = clientRepository.findById(theId);
		
		Client theClient = null;
		if(result.isPresent()) {
			theClient=result.get();
		}else {
			throw new ClientNotFoundException("Cleint not found with ID "+theId);
		}
		
		return theClient;
	}

	@Override
	@Transactional
	public void save(Client theClient) {
		
		if(theClient.getAddress()!=null) {
			//List<Address> updatedAddresses=new ArrayList<>();
			List<Address> addresses=theClient.getAddress();
			Stream<Address> stream=addresses.stream();
			stream.forEach(addressRepository::save);	
		}

		clientRepository.save(theClient);
	}

	@Override
	@Transactional
	public void deletebyId(String theId) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(theId);
	}
	
	@Override
	@Transactional
	public List<Client> findByFirstName(List<String> firstName) {
		List<Client> clientList;
		if(firstName.size()==1) {
			clientList=clientRepository.findByFirstNameIgnoreCase(firstName.get(0));
		}
		else {
		clientList=clientRepository.findByFirstNameIn(firstName);
		}
		if(clientList.isEmpty()) {
			throw new ClientNotFoundException("Cleint not found with Fist Name "+firstName);
		}
		return clientList;
	}
	
	@Override
	@Transactional
	public List<Client> findBylastName(List<String> lastName) {
		List<Client> clientList;
		if(lastName.size()==1) {
			clientList=clientRepository.findByLastNameIgnoreCase(lastName.get(0));
		}
		else
		{
			clientList=clientRepository.findByLastNameIn(lastName);
		}
		
		
		if(clientList.isEmpty()) {
			throw new ClientNotFoundException("Cleint not found with Last Name "+lastName);
		}
		return clientList;
		
	}
}
