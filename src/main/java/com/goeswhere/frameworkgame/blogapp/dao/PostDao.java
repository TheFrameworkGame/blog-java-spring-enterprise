package com.goeswhere.frameworkgame.blogapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goeswhere.frameworkgame.blogapp.domain.Post;
import com.goeswhere.frameworkgame.blogapp.domain.Post_;

@Repository
public class PostDao {

	@PersistenceContext
	EntityManager em;

	@Transactional(readOnly = true)
	public List<Post> frontPage() {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Post> cq = cb.createQuery(Post.class);
		final Root<Post> post = cq.from(Post.class);
		cq.where(cb.equal(post.get(Post_.draft), false));
		return em.createQuery(cq).getResultList();
	}
}
