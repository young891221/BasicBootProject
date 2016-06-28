package com.yj.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired private Environment env;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Map<String, Object> login() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("version", env.getProperty("project.version"));
		
		return map;
	}
}
