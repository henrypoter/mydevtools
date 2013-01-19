package com.javaer.tools.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlFormatter {

	/**
	 * @param args
	 * @throws TransformerException 
	 * @throws TransformerFactoryConfigurationError 
	 * @throws TransformerConfigurationException 
	 */
	public static void main(String[] args) throws TransformerConfigurationException, TransformerFactoryConfigurationError, TransformerException {

		
		File xsltFile = new File("xml-indent.xslt");
		String urglyXml = getXMLString(args[0]);
		String prettyXml = XmlFormatter.xmlFormat(urglyXml, xsltFile);

		System.out.println("Urgly Xml:");
		System.out.println(urglyXml);
		System.out.println("Pretty Xml:");
		System.out.println(prettyXml);
	}
	
	public static String xmlFormat(String urglyXml,File xsltFile) throws TransformerException{
		//InputStream is = new ByteArrayInputStream(Charset.forName("UTF-8").encode(urglyXml).array());
		InputStream is = new ByteArrayInputStream( urglyXml.getBytes() );
		Source xmlSource = new StreamSource(is);
		Source xsltSource = new StreamSource(xsltFile);

		// the factory pattern supports different XSLT processors
		TransformerFactory transFact = TransformerFactory.newInstance();
		Transformer trans = transFact.newTransformer(xsltSource);
		StringBuffer buffer = new StringBuffer();
		OutputStream out = new ByteArrayOutputStream();
		// trans.transform(xmlSource, new StreamResult(System.out));
		trans.transform(xmlSource, new StreamResult(out));
		return out.toString();
		
	}

	/**
	 * xml�ļ�ͨ��xslt����ת��
	 * 
	 * @param xmlFile ��Ҫ����ת����xml�ļ�
	 * @param xmlFile ��Ҫ����ת����xml�ļ�
	 * @return out ת����Ľ��
	 */
	private static OutputStream transform(File xmlFile, File xsltFile)
			throws TransformerFactoryConfigurationError,
			TransformerConfigurationException, TransformerException {
		// JAXP reads data using the Source interface
		Source xmlSource = new StreamSource(xmlFile);
		Source xsltSource = new StreamSource(xsltFile);

		// the factory pattern supports different XSLT processors
		TransformerFactory transFact = TransformerFactory.newInstance();
		Transformer trans = transFact.newTransformer(xsltSource);
		StringBuffer buffer = new StringBuffer();
		OutputStream out = new ByteArrayOutputStream();
		// trans.transform(xmlSource, new StreamResult(System.out));
		trans.transform(xmlSource, new StreamResult(out));
		return out;
	}
	
	private static String getXMLString(String filePath) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				sb.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
