package com.example.webapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StartPageController {
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "The backend of started...";
	}
}
