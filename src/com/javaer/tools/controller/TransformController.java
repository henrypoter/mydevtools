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
public class TransformController {
	private static final Logger logger = Logger.getLogger(TransformController.class);
	

	@RequestMapping(value="/xml2json",method = RequestMethod.GET )
	public String jsonFormat(ModelMap model) {
		model.addAttribute("pageTitle", "免费在线XML转JSON工具");
		return "xml2json";
	}
	
	@RequestMapping(value = "/xml2json.do", method = RequestMethod.POST)
	public @ResponseBody String xml2jsonDo(Model model,
			@RequestParam(value = "sourceType", required = false, defaultValue = "xml") String sourceType,
			@RequestParam(value = "input", required = false) String input,
			@RequestParam(value = "inputUrl", required = false) String inputUrl){
		String error ="";
		logger.debug("ajax xml2json参数[input]:"+input);
		logger.debug("ajax xml2json参数[sourceType]:"+sourceType);
		logger.debug("ajax xml2json参数[inputUrl]:"+inputUrl);
		
		if(("".equals(input)||null==input) && ("".equals(inputUrl)||null==inputUrl)){
			logger.debug("输入参数input和inputUrl不能都为空。请输入xml字符串或者xml文件对应的URL");
			error = "输入参数input和inputUrl不能都为空。请输入xml字符串或者xml文件对应的URL";
			return error;
		}else{
			//文本框中输入了xml字符串
			if(!("".equals(input)||null==input)){
				String prettyJson = null;
				try {
					prettyJson = Formatter.jsonFormatter(Formatter.xml2json(input, "C:/xml-to-json.xsl"));
				} catch (Exception e) {
					logger.error("xml2json转换失败，可能是xml格式不正确" + e.getMessage());
					error = "xml2json转换失败，可能是xml格式不正确" + e.getMessage();
					return  error;
				}
				return prettyJson;
			}else{//输入了xml对应的URI
				String prettyJson = null;
				String xmlStr = null;
				try {
					xmlStr = Formatter.getText(inputUrl);
				} catch (Exception e) {
					logger.error("读取xml文件出错" +e.getMessage());
					error = "读取xml文件出错" + e.getMessage();
					return  error;
				}
				
				try {
					prettyJson = Formatter.jsonFormatter(Formatter.xml2json(xmlStr, "C:/xml-to-json.xsl"));
				} catch (Exception e) {
					logger.error("xml2json转换失败，可能是xml格式不正确" + e.getMessage());
					error = "xml2json转换失败，可能是xml格式不正确" + e.getMessage();
					return  error;
				}
				return prettyJson;
			}
		}
	}
	
}
