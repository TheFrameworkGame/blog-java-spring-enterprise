package com.goeswhere.frameworkgame.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.goeswhere.frameworkgame.blogapp.dao.AccountDao;
import com.goeswhere.frameworkgame.blogapp.dao.PostDao;
import com.goeswhere.frameworkgame.blogapp.domain.Account;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	PostDao posts;

	@Autowired
	AccountDao accounts;

	@Autowired
	PasswordEncoder pass;

	@Transactional(readOnly = true)
	@RequestMapping
	public String index(Model m) {
		if (accounts.isEmpty())
			return "initialUser";

		m.addAttribute("posts", posts.frontPage());
		return "index";
	}

	@Transactional
	@RequestMapping(value = "firstUser", method = RequestMethod.POST)
	public String firstUser(
			@RequestParam("j_username") String username,
			@RequestParam("j_password") String password, Model m) {
		if (!accounts.isEmpty())
			throw new IllegalStateException("nope!");
		accounts.merge(new Account(username, pass.encode(password)));
		return "redirect:/";
	}
}
