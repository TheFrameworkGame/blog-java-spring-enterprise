package com.goeswhere.frameworkgame.blogapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goeswhere.frameworkgame.blogapp.domain.Post;

@Repository
public class PostDao {

	@PersistenceContext
	EntityManager em;

	@Transactional(readOnly = true)
	public List<Post> all() {
		final CriteriaQuery<Post> cq = em.getCriteriaBuilder().createQuery(Post.class);
		cq.from(Post.class);
		return em.createQuery(cq).getResultList();
	}
}
