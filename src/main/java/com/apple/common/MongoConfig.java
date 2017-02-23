package com.apple.common;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoConfig {

	private static DB db = buildDB(); 

	private static DB buildDB() {
		MongoClient mongoClient = new MongoClient("localhost" , 27017);
		db = mongoClient.getDB("gowthamDB");
		return db;
	}
	
	public static DBCollection getCollection(String collectionName) {
		return db.getCollection(collectionName);
	}

	 public static void closeDB() {
	       db=null;
	    }
	
}
