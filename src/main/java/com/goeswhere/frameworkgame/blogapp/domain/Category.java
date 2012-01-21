package com.goeswhere.frameworkgame.blogapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue
	public Long id;

	@Column(nullable = false)
	public String name;
}
