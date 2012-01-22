package com.goeswhere.frameworkgame.blogapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
	public Comment() {
		//unhiding
	}

	public Comment(String email, String body) {
		this.email = email;
		this.body = body;
		this.postDate = System.currentTimeMillis();
	}

	@Id
	@GeneratedValue
	public Long id;

	@Column(nullable = false)
	public String email;

	@Column(nullable = false)
	public String body;

	@Column(nullable = false)
	public long postDate;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getPostDate() {
		return postDate;
	}

	public void setPostDate(long postDate) {
		this.postDate = postDate;
	}
}
