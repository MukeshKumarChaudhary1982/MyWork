package com.mongojava.demo;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Updates.inc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
public class BasicCRUD {
	
	public void basicCrud() {
		
		MongoClient mongoClient=Application.getMongoConnection();
        MongoDatabase database = mongoClient.getDatabase("shop");
        MongoCollection<Document> collection = database.getCollection("produts");
        System.out.println("Count"+collection.countDocuments());
        
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));
        
        collection.insertOne(doc);
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 5; i++) {
            documents.add(new Document("i", i));
        }
        collection.insertMany(documents);
        System.out.println(collection.countDocuments());
        
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
     
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
        
        myDoc = collection.find(eq("i", 1)).first();
        System.out.println(myDoc.toJson());
        
        cursor =collection.find(and(gt("i", 2), lte("i", 4))).iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
        
        collection.updateOne(eq("i", 1), new Document("$set", new Document("i", 11)));
        
        UpdateResult updateResult = collection.updateMany(lt("i", 3), inc("i", 100));
        System.out.println(updateResult.getModifiedCount());
        
        collection.deleteOne(eq("i", 4));
        
        DeleteResult deleteResult = collection.deleteMany(gte("i", 3));
        System.out.println(deleteResult.getDeletedCount());
	}

}
