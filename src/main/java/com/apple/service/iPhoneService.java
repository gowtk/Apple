package com.apple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.bean.iPhone;
import com.apple.dao.iPhoneDAO;

@Service
public class iPhoneService implements AppleService<iPhone> {

	@Autowired
	private iPhoneDAO iphoneDao;

	@Override
	public List<iPhone> getAllDevices() {
		List<iPhone> iphoneList = iphoneDao.findAllDevices();
		return iphoneList;
	}

	@Override
	public List<iPhone> getByModel(String model) {
		List<iPhone> iphoneList = iphoneDao.filterByValues(model);
		return iphoneList;
	}

	@Override
	public iPhone getById(String id) {
		iPhone iphone = iphoneDao.findById(id);
		return iphone;
	}

	@Override
	public void deleteAllDevices() {
		iphoneDao.deleteAll();

	}

	@Override
	public void deleteDeviceById(String id) {
		iphoneDao.deleteById(id);

	}

	@Override
	public void saveDevice(iPhone iphone) {
		iphoneDao.add(iphone);

	}

	@Override
	public void updateDevice(String id, iPhone iphone) {
		iphoneDao.update(id, iphone);

	}

}
