package com.goeswhere.frameworkgame.blogapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	public Long id;

	@Column(nullable = false)
	public String email;

	@Column(nullable = false)
	public String body;

	@Column(nullable = false)
	public long postDate;
}
