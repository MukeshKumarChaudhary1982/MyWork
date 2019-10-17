package com.csc.integral.omni.client.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csc.integral.omni.client.entity.Address;

public interface AddressRepository extends MongoRepository<Address, String> {

}
