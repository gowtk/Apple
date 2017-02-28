package com.apple.common;

import java.io.IOException;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public final class JsonParser {

	private ObjectMapper objectMapper;

	private JsonParser(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	private JsonParser() {
		this.objectMapper = createObjectMapper();
	}

	public static JsonParser getParser() {
		return new JsonParser();
	}

	public static JsonParser getParser(ObjectMapper mapper) {
		return new JsonParser(mapper);
	}

	private ObjectMapper createObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
		// mapper.getSerializationConfig().withView(ResourceView.PublicView.class);
		return mapper;
	}

	private ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public <T> String convertToJson(T obj) throws IOException {
		return getObjectMapper().writeValueAsString(obj);
	}

	public <T> T convertToBean(String json, Class<T> klass) throws IOException {
		return getObjectMapper().readValue(json, klass);
	}

}
