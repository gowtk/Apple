package com.apple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apple.bean.iPhone;
import com.apple.service.iPhoneService;

@RestController
public class iPhoneController {

	@Autowired
	iPhoneService iphoneService;

	// Retrieve All iphone devices
	@RequestMapping(value = "/iphones", method = RequestMethod.GET)
	public ResponseEntity<List<iPhone>> listAlliPhone() {

		System.out.println("retrive all iPhone object.");
		List<iPhone> iphoneList = iphoneService.getAllDevices();
		if (iphoneList.isEmpty()) {
			return new ResponseEntity<List<iPhone>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<iPhone>>(iphoneList, HttpStatus.OK);
	}

	// Retrieve Single iphone by id in path param
	@RequestMapping(value = "/iphone/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<iPhone> getiPhone(@PathVariable("id") String id) {

		System.out.println("retrive a iPhone object for id " + id);
		iPhone iphone = iphoneService.getById(id);
		if (iphone == null) {
			System.out.println("iPhone with id " + id + " not found");
			return new ResponseEntity<iPhone>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<iPhone>(iphone, HttpStatus.OK);
	}

	// Retrieve Single iphone by model in query param
	@RequestMapping(value = "/iphone", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<iPhone>> getiPhoneByModel(@RequestParam(value = "model", required = true) String model) {

		System.out.println("retrive a iPhone object for model " + model);
		List<iPhone> iphoneList = iphoneService.getByModel(model);
		if (iphoneList.isEmpty()) {
			return new ResponseEntity<List<iPhone>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<iPhone>>(iphoneList, HttpStatus.OK);
	}

	// Create a iphone device

	@RequestMapping(value = "/iphone", method = RequestMethod.POST)
	public ResponseEntity<Void> createiPhone(@RequestBody iPhone iphone) {

		System.out.println("Creating iPhone object.");
		iphoneService.saveDevice(iphone);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Update a iphone device

	@RequestMapping(value = "/iphone/{id}", method = RequestMethod.PUT)
	public ResponseEntity<iPhone> updateiPhone(@PathVariable("id") String id, @RequestBody iPhone iphone) {

		System.out.println("Updating iPhone object for id " + id);
		iPhone dbiPhone = iphoneService.getById(id);
		if (dbiPhone == null) {
			System.out.println("iPhone object " + id + "is not availabe for update");
			return new ResponseEntity<iPhone>(HttpStatus.NOT_FOUND);
		}
		iphoneService.updateDevice(id, iphone);
		return new ResponseEntity<iPhone>(iphone, HttpStatus.OK);
	}

	// Delete a iphone device

	@RequestMapping(value = "/iphone/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<iPhone> deleteiPhone(@PathVariable("id") String id) {

		System.out.println("Deleting iPhone object for id " + id);
		iPhone iphone = iphoneService.getById(id);
		if (iphone == null) {
			System.out.println("Unable to iPhone object with id " + id + " not found");
			return new ResponseEntity<iPhone>(HttpStatus.NOT_FOUND);
		}
		iphoneService.deleteDeviceById(id);
		return new ResponseEntity<iPhone>(HttpStatus.NO_CONTENT);
	}

	// Delete All iphone device

	@RequestMapping(value = "/iphones", method = RequestMethod.DELETE)
	public ResponseEntity<iPhone> deleteAlliPhone() {

		System.out.println("Deleting All iPhone objects");
		iphoneService.deleteAllDevices();
		return new ResponseEntity<iPhone>(HttpStatus.NO_CONTENT);
	}

	// Initialize is to save temp data to db
	@RequestMapping(value = "/iphone-init", method = RequestMethod.GET)
	public ResponseEntity<String> initializeiPhone() {

		System.out.println("save temp iPhone data to database");
		iphoneService.initialize();
		return new ResponseEntity<String>("temp data saved to db", HttpStatus.OK);
	}
}
