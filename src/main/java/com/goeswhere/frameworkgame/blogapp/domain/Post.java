package com.goeswhere.frameworkgame.blogapp.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTease() {
		return tease;
	}

	public void setTease(String tease) {
		this.tease = tease;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public long getPostDate() {
		return postDate;
	}

	public void setPostDate(long postDate) {
		this.postDate = postDate;
	}

	public boolean isDraft() {
		return draft;
	}

	public void setDraft(boolean draft) {
		this.draft = draft;
	}

	public boolean isHasComments() {
		return hasComments;
	}

	public void setHasComments(boolean hasComments) {
		this.hasComments = hasComments;
	}
}
