package utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;

public class Utils {
//	private static final Gson gson = new Gson();
	static ObjectMapper objectMapper = new ObjectMapper();
//	
//	public static String convertMapOfObjectToJson(Map<String, Object> map) {
//		String json = gson.toJson(map);
//		return json;
//	}
	
	public static String getJsonStringFromObject(Object obj) throws JsonGenerationException,
	JsonMappingException, IOException {
		StringWriter writer = new StringWriter();
		objectMapper.writeValue(writer, obj);
		return writer.toString();
	}
	
	public static JsonNode convertObjectToJsonNode(Object object) {
		JsonNode jsonAdObject = objectMapper.valueToTree(object);
		return jsonAdObject;
	}
	
}
