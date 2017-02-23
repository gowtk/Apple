package com.apple.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.apple.bean.iPhone;
import com.apple.common.DBObjectMapper;
import com.apple.common.MongoConfig;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

@Repository
public class iPhoneDAO extends AppleBaseDAO<iPhone> {

	private static final String collectionName = "iPhone";
	private static final DBObjectMapper MAPPER = DBObjectMapper.getMapper();

	public List<iPhone> findAllDevices() {

		List<iPhone> iPhoneList = new ArrayList<>();
		DBCollection collection = MongoConfig.getCollection(collectionName);
		DBCursor cursor = collection.find();
		try {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				iPhone iphone = MAPPER.mapToValueObject(dbObject, iPhone.class);
				iPhoneList.add(iphone);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Exception in findAllDevices" + ex);
		}
		System.out.println("iPhone find All Devices success");
		return iPhoneList;
	}

	public List<iPhone> filterByValues(String model) {

		List<iPhone> iPhoneList = new ArrayList<>();
		DBCollection collection = MongoConfig.getCollection(collectionName);
		DBObject regex = new BasicDBObject("$regex", "^.*" + model + ".*$");
		DBObject query = new BasicDBObject("model", regex);
		DBCursor cursor = collection.find(query);
		try {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				iPhone iphone = MAPPER.mapToValueObject(dbObject, iPhone.class);
				iPhoneList.add(iphone);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Exception in filterByValues" + ex);
		}
		System.out.println("iPhone filter By Values success");
		return iPhoneList;
	}

	public iPhone findById(String id) {

		DBCollection collection = MongoConfig.getCollection(collectionName);
		DBObject query = new BasicDBObject("_id", id);
		DBObject dbObject = collection.findOne(query);
		iPhone iphone = null;
		try {
			iphone = MAPPER.mapToValueObject(dbObject, iPhone.class);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Exception in findById" + ex);
		}
		System.out.println("iPhone find By Id success");
		return iphone;

	}

	public void deleteAll() {

		DBCollection collection = MongoConfig.getCollection(collectionName);
		DBObject query = new BasicDBObject();
		collection.remove(query);
		System.out.println("iPhone delete All success");
	}

	public void deleteById(String id) {

		DBCollection collection = MongoConfig.getCollection(collectionName);
		DBObject query = new BasicDBObject("_id", id);
		collection.remove(query);
		System.out.println("iPhone delete By Id success");
	}

	public void add(iPhone iphone) {

		try {
			DBObject dbObject = MAPPER.mapToDBObject(iphone);
			DBCollection collection = MongoConfig.getCollection(collectionName);
			WriteResult s = collection.save(dbObject);
			System.out.println("new iphone id " + s.getUpsertedId() + " added to db");
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Exception in findById" + ex);
		}
		System.out.println("iPhone add success");
	}

	public void update(String id, iPhone iphone) {

		try {
			DBObject dbObject = MAPPER.mapToDBObject(iphone);
			DBCollection collection = MongoConfig.getCollection(collectionName);
			DBObject query = new BasicDBObject("_id", id);
			collection.update(query, dbObject);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Exception in findById" + ex);
		}
		System.out.println("iPhone update success");

	}

	// initiate call is used to save temp data for testing
	public void initialize() {
		for (iPhone iphone : iphoneList) {
			add(iphone);
		}
	}

	static List<iPhone> iphoneList = getTemporaryList();

	private static List<iPhone> getTemporaryList() {

		iPhone iphoneSE = new iPhone();
		iphoneSE.setId("1");
		iphoneSE.setModel("SE");
		iphoneSE.setVersion("IOS9");
		iphoneSE.setChip("A9");
		iphoneSE.setDisplaySize(4.0);
		iphoneSE.setCameraMP(12);
		iphoneSE.setPrice(549);
		iphoneSE.setMfgYear("2016");
		iphoneSE.setSerialNumber("1024SEXXXXXXXXX");

		iPhone iphone6SOne = new iPhone();
		iphone6SOne.setId("2");
		iphone6SOne.setModel("6S");
		iphone6SOne.setVersion("IOS9");
		iphone6SOne.setChip("A9");
		iphone6SOne.setDisplaySize(4.7);
		iphone6SOne.setCameraMP(12);
		iphone6SOne.setPrice(500);
		iphone6SOne.setMfgYear("2015");
		iphone6SOne.setSerialNumber("10246SXXXXXXXXX");

		iPhone iphone6Stwo = new iPhone();
		iphone6Stwo.setId("3");
		iphone6Stwo.setModel("6S");
		iphone6Stwo.setVersion("IOS10");
		iphone6Stwo.setChip("A10");
		iphone6Stwo.setDisplaySize(4.7);
		iphone6Stwo.setCameraMP(12);
		iphone6Stwo.setPrice(549);
		iphone6Stwo.setMfgYear("2016");
		iphone6Stwo.setSerialNumber("10246SXXXXXXXXX");

		iPhone iphone6Splus = new iPhone();
		iphone6Splus.setId("4");
		iphone6Splus.setModel("6Splus");
		iphone6Splus.setVersion("IOS10");
		iphone6Splus.setChip("A10");
		iphone6Splus.setDisplaySize(5.5);
		iphone6Splus.setCameraMP(12);
		iphone6Splus.setPrice(649);
		iphone6Splus.setMfgYear("2015");
		iphone6Splus.setSerialNumber("10246PXXXXXXXXX");

		iPhone iphone7 = new iPhone();
		iphone7.setId("5");
		iphone7.setModel("7S");
		iphone7.setVersion("IOS10");
		iphone7.setChip("A10");
		iphone7.setDisplaySize(4.7);
		iphone7.setCameraMP(12);
		iphone7.setPrice(649);
		iphone7.setMfgYear("2016");
		iphone7.setSerialNumber("10247SXXXXXXXXX");

		iPhone iphone7plus = new iPhone();
		iphone7plus.setId("6");
		iphone7plus.setModel("7Splus");
		iphone7plus.setVersion("IOS10");
		iphone7plus.setChip("A10");
		iphone7plus.setDisplaySize(5.5);
		iphone7plus.setCameraMP(12);
		iphone7plus.setPrice(769);
		iphone7plus.setMfgYear("2017");
		iphone7plus.setSerialNumber("10247PXXXXXXXXX");

		List<iPhone> tempList = new ArrayList<>();
		tempList.add(iphoneSE);
		tempList.add(iphone6SOne);
		tempList.add(iphone6Stwo);
		tempList.add(iphone6Splus);
		tempList.add(iphone7);
		tempList.add(iphone7plus);
		return tempList;
	}

}
