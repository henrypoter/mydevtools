package com.javaer.tools.common;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	/*
	HttpDelete	HTTP DELETE method
	HttpEntityEnclosingRequestBase	Basic implementation of an entity enclosing HTTP request that can be modified
	HttpGet	HTTP GET method.
	HttpHead	HTTP HEAD method.
	HttpOptions	HTTP OPTIONS method.
	HttpPatch	HTTP PATCH method.
	HttpPost	HTTP POST method.
	HttpPut	HTTP PUT method.
	HttpRequestBase	Basic implementation of an HTTP request that can be modified.
	HttpTrace	HTTP TRACE method.
	 */

	public static final String METHOD_POST = "POST";
	public static final String METHOD_GET = "GET";
	public static final String METHOD_DELETE = "DELETE";
	public static final String METHOD_HEAD = "HEAD";
	public static final String METHOD_OPTIONS = "OPTIONS";
	public static final String METHOD_PATCH = "PATCH";
	public static final String METHOD_PUT = "PUT";
	public static final String METHOD_TRACE = "TRACE";
	public static final String METHOD_BASIC = "Basic";
	
	public static final String CHARSET_UTF8 = "UTF-8";
	public static final String CHARSET_GBK = "GBK";
	public static final String CHARSET_GB2312 = "gb2312";
	public static final String CHARSET_BIG5 = "Big5";
	public static final String CHARSET_EUC_JP = "EUC-JP";
	public static final String CHARSET_EUC_KR = "EUC-KR";
	public static final String CHARSET_ENGLISH = "ISO-8859-1";
	
	
	public static final String CONTENT_TYPE_XML = "text/xml";
	public static final String CONTENT_TYPE_JSON = "application/json";
	
	public static final String RESULT_TYPE_STRING = "String";
	public static final String RESULT_TYPE_OBJECT = "Object";
	
	
	public static final String XSLT_DEFAULT_PATH = "xml-to-json.xsl";
	
	

	public static List<String> METHOD_LIST = new ArrayList<String>();
	static {
		METHOD_LIST.add(METHOD_POST);
		METHOD_LIST.add(METHOD_GET);
		METHOD_LIST.add(METHOD_DELETE);
	}
	
	public static List<String> CHARSET_LIST = new ArrayList<String>();
	static {
		CHARSET_LIST.add(CHARSET_UTF8);
		CHARSET_LIST.add(CHARSET_GBK);
		CHARSET_LIST.add(CHARSET_GB2312);
		CHARSET_LIST.add(CHARSET_BIG5);
		CHARSET_LIST.add(CHARSET_ENGLISH);
		CHARSET_LIST.add(CHARSET_EUC_JP);
		CHARSET_LIST.add(CHARSET_EUC_KR);
	}
	
	public static List<String> CONTENT_TYPE_LIST = new ArrayList<String>();
	static {
		CONTENT_TYPE_LIST.add(CONTENT_TYPE_XML);
		CONTENT_TYPE_LIST.add(CONTENT_TYPE_JSON);
	}
	
	public static List<String> RESULT_TYPE_LIST = new ArrayList<String>();
	static {
		RESULT_TYPE_LIST.add(RESULT_TYPE_STRING);
		RESULT_TYPE_LIST.add(RESULT_TYPE_STRING);
	}
		
	
	

}
