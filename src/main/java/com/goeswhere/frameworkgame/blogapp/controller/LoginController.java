package com.goeswhere.frameworkgame.blogapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/")
public class LoginController {
	@RequestMapping
	public String root() {
		return "login";
	}
}
