package com.apple.common;

import java.io.IOException;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class DBObjectMapper {

	private DBObjectMapper() {

	}

	public static DBObjectMapper getMapper() {
		return ObjectMapperHolder.MAPPER;
	}

	/**
	 * The Class Holder of DBObjectMapper
	 */
	private static class ObjectMapperHolder {

		private static final DBObjectMapper MAPPER = new DBObjectMapper();
	}

	/**
	 * convert db object to model object.
	 */
	public <T> T mapToValueObject(DBObject dbObject, Class<T> Klass) throws IOException {

		// Checks whether the db object is null.
		if (dbObject == null) {
			return null;
		}
		final String jsonString = JSON.serialize(dbObject);
		return JsonParser.getParser().convertToBean(jsonString, Klass);
	}

	/**
	 * convert model object to db object.
	 */
	public <T> DBObject mapToDBObject(T obj) throws IOException {

		final String jsonString = JsonParser.getParser().convertToJson(obj);
		final DBObject updatableObject = (DBObject) JSON.parse(jsonString);
		return updatableObject;
	}
}
