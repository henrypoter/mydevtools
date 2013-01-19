package com.javaer.tools.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.javaer.tools.config.MyAppContextListener;

public class Formatter {

	private static final Logger logger = Logger.getLogger(Formatter.class);

	/**
	 * JSON Formatter
	 * 
	 * @param uglyJSONString
	 * @return pretty JSON Object
	 */
	public static String jsonFormatter(String uglyJSONString) throws Exception {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(uglyJSONString);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}

	/**
	 * convert xml to json
	 * @param xml
	 * @param xsltFile
	 * @return
	 * @throws TransformerException
	 */
	public static String xml2json(String xml, String xsltFile)
			throws TransformerException {

		try {
			 InputStream is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
			 String xsltPath = MyAppContextListener.xml2JsonXsltFile.getAbsolutePath().toString();
			 System.out.println(" MyAppContextListener.xml2JsonXsltFile.getAbsolutePath().toString():"+xsltPath );
			 ByteArrayOutputStream os = (ByteArrayOutputStream) XSLTTransform.transform(is, xsltPath);
			 String result = new String(os.toByteArray(), "UTF-8");
			return result;
		} catch (Exception e) {
			logger.error("转换过程出错");
			throw new RuntimeException("转换过程出错");
		}
	}

	/**
	 * xml formatter
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static String xmlFormatter(String input) throws Exception {

		try {
			Source xmlInput = new StreamSource(new StringReader(input));
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			//transformerFactory.setAttribute("indent-number", 4);
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(xmlInput, xmlOutput);
			return xmlEscape(xmlOutput.getWriter().toString());
		} catch (Exception e) {
			throw new RuntimeException("xml格式化出错，可能是xml格式不对，错误信息："
					+ e.getMessage());
		}
	}
	
	public static String htmlFormatter(String input) throws Exception {
	    	Tidy tidy = new Tidy();
		    tidy.setXHTML(false);
		    tidy.setIndentContent(true);
		    tidy.setPrintBodyOnly(true);
		    tidy.setTidyMark(false);
		    tidy.setInputEncoding("UTF-8");
		    tidy.setOutputEncoding("UTF-8");

		    InputStream is = new ByteArrayInputStream(input.getBytes("UTF-8"));//"UTF-8"
		    // Convert HTML to DOM
		    Document htmlDOM = tidy.parseDOM(is, null);

		    // Pretty Print
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		    tidy.pprint(htmlDOM, out);
		    return xmlEscape(out.toString("UTF-8"));
	}
	
	
	public  static String xmlEscape(String prettyXml){
		String escapedXml = "";
		escapedXml = prettyXml.replaceAll("<", "&lt;");
		escapedXml = escapedXml.replaceAll(">", "&gt;");
		return escapedXml;
	}

	public static String getText(String url) throws Exception {
		logger.debug("读取URL："+url);
		URL website = new URL(url);
		URLConnection connection = website.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream(),"UTF-8"));

		StringBuilder response = new StringBuilder();
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);
             in.close();
        logger.debug("读取得到的内容：" +response.toString());
		return response.toString();
	}
}
