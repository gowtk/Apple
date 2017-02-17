package com.apple.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.apple.bean.iPhone;

@Repository
public class iPhoneDAO extends AppleBaseDAO<iPhone> {

	static List<iPhone> iphoneList = getTemporaryList();

	public List<iPhone> findAllDevices() {
		return iphoneList;
	}

	public List<iPhone> filterByValues(String model) {

		List<iPhone> tempiPhoneList = new ArrayList<>();

		for (iPhone iphone : iphoneList) {
			if (model.equalsIgnoreCase(iphone.getModel())) {
				tempiPhoneList.add(iphone);
			}
		}
		return tempiPhoneList;
	}

	public iPhone findById(String id) {

		iPhone tempiPhone = null;

		for (iPhone iphone : iphoneList) {
			if (id.equals(iphone.getId())) {
				tempiPhone = iphone;
				break;
			}
		}
		return tempiPhone;

	}

	public void deleteAll() {
		iphoneList.clear();
	}

	public void deleteById(String id) {

		Iterator<iPhone> iphoneItr = iphoneList.iterator();
		while (iphoneItr.hasNext()) {
			iPhone iphone = iphoneItr.next();
			if (id.equals(iphone.getId())) {
				iphoneItr.remove();
				break;
			}
		}
	}

	public void add(iPhone iphone) {
		iphoneList.add(iphone);

	}

	public void update(String id, iPhone iphone) {

		deleteById(id);
		iphone.setId(id);
		iphoneList.add(iphone);

	}

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
