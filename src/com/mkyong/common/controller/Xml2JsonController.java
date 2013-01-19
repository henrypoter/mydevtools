package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/xml2json")
public class Xml2JsonController {

	@RequestMapping(method = RequestMethod.GET)
	public String xml2json(ModelMap model,@RequestParam(value = "xmlContent", required = false, defaultValue = "5") int pagesize) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "xml2json";

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String xml2JsonDo(ModelMap model,@RequestParam(value = "xmlContent", required = false, defaultValue = "5") int pagesize) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "xml2JsonResult";

	}
}
