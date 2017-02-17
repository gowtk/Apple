package com.apple.service;

import java.util.List;

public interface AppleService<Klass> {

	List<Klass> getAllDevices();

	List<Klass> getByModel(String model);

	Klass getById(String id);

	void deleteAllDevices();

	void deleteDeviceById(String id);

	void saveDevice(Klass device);

	void updateDevice(String id, Klass device);
}
