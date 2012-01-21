package com.goeswhere.frameworkgame.blogapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goeswhere.frameworkgame.blogapp.domain.Post;
import com.google.common.collect.Lists;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping
	public String index(Model m) {
		m.addAttribute("posts", Lists.newArrayList(new Post("Ponies!", "All about ponies")));
		return "index";
	}
}
