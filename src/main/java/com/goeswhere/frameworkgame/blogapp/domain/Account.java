package com.goeswhere.frameworkgame.blogapp.domain;

import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Account {
	public Account() {
		// unhiding
	}

	public Account(String username, String encodedPass) {
		this.name = username;
		this.password = encodedPass;
	}

	@Id
	@GeneratedValue
	public Long id;

	@Column(nullable = false)
	public String name;

	@Column(nullable = false)
	public String password;

	public UserDetails toUser() {
		return new User(name, password, Collections.<GrantedAuthority>emptySet());
	}
}
