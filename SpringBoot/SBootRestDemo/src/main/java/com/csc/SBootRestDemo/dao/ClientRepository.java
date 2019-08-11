package com.csc.SBootRestDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc.SBootRestDemo.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
