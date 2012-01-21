package com.goeswhere.frameworkgame.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goeswhere.frameworkgame.blogapp.dao.PostDao;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	PostDao posts;

	@Transactional(readOnly = true)
	@RequestMapping
	public String index(Model m) {
		m.addAttribute("posts", posts.all());
		return "index";
	}
}
