package com.javaer.tools.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaer.tools.common.Formatter;


@Controller
public class FormatController {
	private static final Logger logger = Logger.getLogger(FormatController.class);
	

	@RequestMapping(value="/jsonformat",method = RequestMethod.GET )
	public String jsonFormat(ModelMap model) {
		model.addAttribute("pageTitle", "免费在线JSON格式化工具");
		return "jsonformat";
	}
	
	@RequestMapping(value="/xmlformat",method = RequestMethod.GET )
	public String xmlFormat(ModelMap model) {
		model.addAttribute("pageTitle", "免费在线XML格式化工具");
		return "xmlformat";
	}
	
	@RequestMapping(value="/htmlformat",method = RequestMethod.GET )
	public String htmlFormat(ModelMap model) {
		model.addAttribute("pageTitle", "免费在线HTML格式化工具");
		return "htmlformat";
	}
	
	@RequestMapping(value = "/jsonformat.do", method = RequestMethod.POST)
	public @ResponseBody String jsonFormatDo(Model model,
			@RequestParam(value = "sourceType", required = false, defaultValue = "json") String sourceType,
			@RequestParam(value = "input", required = false) String input,
			@RequestParam(value = "inputUrl", required = false) String inputUrl){
		String error ="";
		logger.debug("ajax格式化json参数[input]:"+input);
		logger.debug("ajax格式化json参数[sourceType]:"+sourceType);
		logger.debug("ajax格式化json参数[inputUrl]:"+inputUrl);
		
		if(("".equals(input)||null==input) && ("".equals(inputUrl)||null==inputUrl)){
			logger.debug("输入参数input和inputUrl不能都为空。请输入json字符串或者json文件对应的URL");
			error = "输入参数input和inputUrl不能都为空。请输入json字符串或者json文件对应的URL";
			return error;
		}else{
			//文本框中输入了json字符串
			if(!("".equals(input)||null==input)){
				String prettyJson = null;
				try {
					prettyJson = Formatter.jsonFormatter(input);
				} catch (Exception e) {
					logger.error("json格式化失败，可能是json格式不正确" + e.getMessage());
					error = "json格式化失败，可能是json格式不正确" + e.getMessage();
					return  error;
				}
				return prettyJson;
			}else{//输入了json对应的URI
				String prettyJson = null;
				String jsonStr = null;
				try {
					jsonStr = Formatter.getText(inputUrl);
				} catch (Exception e) {
					logger.error("读取json文件出错" +e.getMessage());
					error = "读取json文件出错" + e.getMessage();
					return  error;
				}
				
				try {
					prettyJson = Formatter.jsonFormatter(jsonStr);
				} catch (Exception e) {
					logger.error("json格式化失败，可能是json格式不正确" + e.getMessage());
					error = "json格式化失败，可能是json格式不正确" + e.getMessage();
					return  error;
				}
				return prettyJson;
			}
		}
	}
	/**
	 * 响应ajax异步请求，格式化xml
	 * @param model
	 * @param sourceType
	 * @param input
	 * @param inputUrl
	 * @return
	 */
	@RequestMapping(value = "/xmlformat.do", method = RequestMethod.POST)
	public @ResponseBody String xmlFormatDo(Model model,
			@RequestParam(value = "sourceType", required = false, defaultValue = "xml") String sourceType,
			@RequestParam(value = "input", required = false) String input,
			@RequestParam(value = "inputUrl", required = false) String inputUrl){
		String error ="";
		logger.debug("ajax格式化xml参数[input]:"+input);
		logger.debug("ajax格式化xml参数[sourceType]:"+sourceType);
		logger.debug("ajax格式化xml参数[inputUrl]:"+inputUrl);
		
		if(("".equals(input)||null==input) && ("".equals(inputUrl)||null==inputUrl)){
			logger.debug("输入参数input和inputUrl不能都为空。请输入xml字符串或者xml文件对应的URL");
			error = "输入参数input和inputUrl不能都为空。请输入xml字符串或者xml文件对应的URL";
			return error;
		}else{
			//文本框中输入了xml字符串
			if(!("".equals(input)||null==input)){
				String prettyXml = null;
				try {
					prettyXml = Formatter.xmlFormatter(input);
				} catch (Exception e) {
					logger.error("xml格式化失败，可能是xml格式不正确" + e.getMessage());
					error = "xml格式化失败，可能是xml格式不正确" + e.getMessage();
					return  error;
				}
				return prettyXml;
			}else{//输入了xml对应的URI
				String prettyXml = null;
				String xmlStr = null;
				try {
					xmlStr = Formatter.getText(inputUrl);
				} catch (Exception e) {
					logger.error("读取xml文件出错" +e.getMessage());
					error = "读取xml文件出错" + e.getMessage();
					return  error;
				}
				
				try {
					prettyXml = Formatter.xmlFormatter(xmlStr);
				} catch (Exception e) {
					logger.error("xml格式化失败，可能是xml格式不正确" + e.getMessage());
					error = "xml格式化失败，可能是xml格式不正确" + e.getMessage();
					return  error;
				}
				return prettyXml;
			}
		}
	}
	@RequestMapping(value = "/htmlformat.do", method = RequestMethod.POST)
	public @ResponseBody String htmlFormatDo(Model model,
			@RequestParam(value = "sourceType", required = false, defaultValue = "html") String sourceType,
			@RequestParam(value = "input", required = false) String input,
			@RequestParam(value = "inputUrl", required = false) String inputUrl){
		String error ="";
		logger.debug("ajax格式化html参数[input]:"+input);
		logger.debug("ajax格式化html参数[sourceType]:"+sourceType);
		logger.debug("ajax格式化html参数[inputUrl]:"+inputUrl);
		
		if(("".equals(input)||null==input) && ("".equals(inputUrl)||null==inputUrl)){
			logger.debug("输入参数input和inputUrl不能都为空。请输入html字符串或者html文件对应的URL");
			error = "输入参数input和inputUrl不能都为空。请输入html字符串或者html文件对应的URL";
			return error;
		}else{
			//文本框中输入了html字符串
			if(!("".equals(input)||null==input)){
				String prettyHtml = null;
				try {
					prettyHtml = Formatter.htmlFormatter(input);
				} catch (Exception e) {
					logger.error("html格式化失败，可能是html格式不正确" + e.getMessage());
					error = "html格式化失败，可能是html格式不正确" + e.getMessage();
					return  error;
				}
				return prettyHtml;
			}else{//输入了html对应的URI
				String prettyHtml = null;
				String htmlStr = null;
				try {
					htmlStr = Formatter.getText(inputUrl);
				} catch (Exception e) {
					logger.error("读取html文件出错" +e.getMessage());
					error = "读取html文件出错" + e.getMessage();
					return  error;
				}
				
				try {
					prettyHtml = Formatter.htmlFormatter(htmlStr);
				} catch (Exception e) {
					logger.error("html格式化失败，可能是html格式不正确" + e.getMessage());
					error = "html格式化失败，可能是html格式不正确" + e.getMessage();
					return  error;
				}
				return prettyHtml;
			}
		}
	}

}
