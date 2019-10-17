package com.csc.integral.omni.client.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
	
	@Id
	private String id;
	
	private String type;
	
	private String address1;
	
	private String address2;
	
	private String address3;
	
	private String postcode;
	
	public Address() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Address(String type, String address1, String address2, String address3, String postcode) {
		super();
		this.type = type;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Address [type=" + type + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3
				+ ", postcode=" + postcode + "]";
	}
	
	

}
