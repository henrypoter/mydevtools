package com.javaer.tools.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


import org.apache.log4j.Logger;

/**
 * XML Transform Via XSLT
 * 
 * @author hezhiming
 * @version
 */
public class XSLTTransform {

	private static final Logger logger = Logger.getLogger(XSLTTransform.class);

	// 为转换器工厂设置其 XSLT 2.0 实现，依赖saxon9.jar
	static{
		System.setProperty("javax.xml.transform.TransformerFactory","net.sf.saxon.TransformerFactoryImpl");
	}
	
	/**
	 * Transform xml via xslt
	 * 
	 * @param xmlInputStream  xml输入流
	 * @param xslt 用于执行转换的xslt文件
	 * @return out 输出流
	 */
	public static OutputStream transform(InputStream xmlInputStream, String xslt)
			throws Exception {
	
		if (null == xmlInputStream) {
			logger.error("参数xmlInputStream不能为空");
			throw new RuntimeException("参数xmlInputStream不能为空");
		}
		if (null == xslt) {
			logger.error("参数xslt不能为空");
			throw new RuntimeException("参数xslt不能为空");
		}
		logger.debug("使用xslt文件：" + xslt);

		Source xmlSource = new StreamSource(xmlInputStream);
		File xsltFile = new File(xslt);
		Source xsltSource = new StreamSource(xsltFile);

		// the factory pattern supports different XSLT processors
		TransformerFactory transFact = TransformerFactory.newInstance();
		if(transFact instanceof net.sf.saxon.TransformerFactoryImpl){
			logger.debug("transFact instanceof net.sf.saxon.TransformerFactoryImpl");
		}
		Transformer trans;
		try {
			trans = transFact.newTransformer(xsltSource);
			OutputStream out = new ByteArrayOutputStream();
			trans.transform(xmlSource, new StreamResult(out));
			return out;
		} catch (TransformerConfigurationException e) {
			logger.error("xml通过xslt进行转换时出错",e);
			throw e;
		} catch (TransformerException e) {
			logger.error("xml通过xslt进行转换时出错",e);
			throw e;
		}
	}

	/**
	 * Transform xml via xslt
	 * 
	 * @param xmlFile 需要转换的xml文件
	 * @param xsltFile 用于转换的xslt文件
	 * @return
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
	public static OutputStream transformx(File xmlFile, File xsltFile) throws Exception {
		// JAXP reads data using the Source interface
		Source xmlSource = new StreamSource(xmlFile);
		Source xsltSource = new StreamSource(xsltFile);
		
		// the factory pattern supports different XSLT processors
		TransformerFactory transFact = TransformerFactory.newInstance();
		Transformer trans;
		try {
			trans = transFact.newTransformer(xsltSource);
			OutputStream out = new ByteArrayOutputStream();
			// trans.transform(xmlSource, new StreamResult(System.out));
			trans.transform(xmlSource, new StreamResult(out));

			return out;
		} catch (TransformerConfigurationException e) {
			logger.error("xml通过xslt进行转换时出错",e);
			throw e;
		} catch (TransformerException e) {
			logger.error("xml通过xslt进行转换时出错",e);
			throw e;
		}
	}
}
