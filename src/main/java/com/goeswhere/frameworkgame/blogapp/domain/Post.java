package com.goeswhere.frameworkgame.blogapp.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;


@Entity
public class Post {
	public Post() {
		// unhidden
	}

	public Post(String title, String tease) {
		this.title = title;
		this.tease = tease;
	}

	@Id
	@GeneratedValue
	public Long id;

	@Column(nullable = false)
	public String title;

	@Column(nullable = false)
	public String slug;

	@Column(nullable = false)
	@Lob
	public String body;

	@Column(nullable = false)
	@Lob
	public String tease;

	@Column(nullable = false)
	@OneToMany(fetch = FetchType.EAGER)
	public List<Comment> comments;

	@Column(nullable = false)
	@OneToMany(fetch = FetchType.EAGER)
	public Set<Category> categories;

	@Column(nullable = false)
	public long postDate;

	@Column(nullable = false)
	public boolean draft;

	@Column(nullable = false)
	public boolean hasComments;

	public String getTitle() {
		return title;
	}

	public String getTease() {
		return tease;
	}
}
