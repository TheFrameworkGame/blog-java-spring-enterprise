package com.goeswhere.frameworkgame.blogapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goeswhere.frameworkgame.blogapp.domain.Comment;

@Repository
public class CommentDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public void merge(Comment c) {
		em.merge(c);
	}
}
