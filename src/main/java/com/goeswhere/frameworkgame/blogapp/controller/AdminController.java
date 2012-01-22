package com.goeswhere.frameworkgame.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goeswhere.frameworkgame.blogapp.dao.PostDao;
import com.goeswhere.frameworkgame.blogapp.domain.Post;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	PostDao posts;

	@Transactional(readOnly = true)
	@RequestMapping
	public String index(Model m) {
		m.addAttribute("posts", posts.all());
		return "adminList";
	}

	@RequestMapping("new")
	public String createNew(Model m) {
		m.addAttribute("post", new Post());
		return "editPost";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute Post p) {
		if (null == p.id)
			p.postDate = System.currentTimeMillis();
		posts.merge(p);
		return "redirect:/admin/";
	}
}
