package com.mongojava.demo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Application {
	
	static MongoClient mongoClient;

	public static MongoClient getMongoConnection() {
		
		try {
			if(mongoClient==null) {
				mongoClient = MongoClients.create();
			}
			//MongoClient mongoClient = MongoClients.create("mongodb://hostOne:27017,hostTwo:27018");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
		
		return mongoClient;
	}
}
