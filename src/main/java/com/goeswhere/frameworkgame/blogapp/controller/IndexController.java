package com.goeswhere.frameworkgame.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.goeswhere.frameworkgame.blogapp.dao.AccountDao;
import com.goeswhere.frameworkgame.blogapp.dao.CommentDao;
import com.goeswhere.frameworkgame.blogapp.dao.PostDao;
import com.goeswhere.frameworkgame.blogapp.domain.Account;
import com.goeswhere.frameworkgame.blogapp.domain.Comment;
import com.goeswhere.frameworkgame.blogapp.domain.Post;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	PostDao posts;

	@Autowired
	AccountDao accounts;

	@Autowired
	CommentDao comments;

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

	@Transactional(readOnly = true)
	@RequestMapping("/{slug}")
	public String post(@PathVariable("slug") String slug, Model m) {
		m.addAttribute("post", posts.bySlug(slug));
		return "post";
	}

	@Transactional
	@RequestMapping("/{slug}/newComment")
	public String newComment(
			@PathVariable("slug") String slug,
			@RequestParam("email") String email,
			@RequestParam("comment") String body, Model m) {
		final Post p = posts.bySlug(slug);
		final Comment comment = new Comment(email, body);
		p.comments.add(comment);
		posts.merge(p);
		return "redirect:/" + slug;
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
