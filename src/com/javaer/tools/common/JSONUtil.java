package com.javaer.tools.common;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * JSON Util Class
 * @author hezhiming
 * @version
 */
public class JSONUtil {
	
	private static final Logger logger = Logger.getLogger(JSONUtil.class);

	/**
	 * Convert Map to JSON String
	 * @param map
	 * @return
	 */
	public static String map2String(Map<String, Object> map) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		try {
	 
		 return mapper.writeValueAsString(map);
	 
		} catch (JsonMappingException e) {
			logger.error("Map转化为JSON字符串时出错");
			throw e;
		}
	}
	
	/**
	 * Convert Map to JSONObject
	 * @param map
	 * @return
	 */
	public static JSONObject map2JSON(Map<String, Object> map)throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonStr = mapper.writeValueAsString(map);
			logger.debug("JSON String:" + jsonStr);
			JSONObject jsonObj = new JSONObject(jsonStr);
			return jsonObj;
	 
		} catch (JsonMappingException e) {
			logger.error("Map转化为JSON字符串时出错");
			throw e;
		} catch (JSONException e) {
			logger.error("从字符串创建JSON对象时出错");
			throw e;
		}
	}
	


	/**
	 * Convert List to JSONObject
	 * @param list
	 * @return
	 */
	public static JSONArray list2JSON(List<Object> list) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		try {
			JSONArray jsonArr = new JSONArray(mapper.writeValueAsString(list));
			return jsonArr;
	 
		} catch (JsonMappingException e) {
			logger.error("Map转化为JSON字符串时出错");
			throw e;
		} catch (JSONException e) {
			logger.error("从字符串创建JSON对象时出错");
			throw e;
		}
	}
	
		
	
	/**
	 * Convert List to JSON String
	 * @param list
	 * @return
	 */
	public static String list2String(List<Object> list) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		try {
		  return mapper.writeValueAsString(list);
		} catch (JsonMappingException e) {
			logger.error("Map转化为JSON字符串时出错");
			throw e;
		} 
	}
}
