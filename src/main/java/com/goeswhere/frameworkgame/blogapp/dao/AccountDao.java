package com.goeswhere.frameworkgame.blogapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goeswhere.frameworkgame.blogapp.domain.Account;
import com.goeswhere.frameworkgame.blogapp.domain.Account_;

@Repository
public class AccountDao {

	@PersistenceContext
	EntityManager em;

	@Transactional(readOnly = true)
	public boolean isEmpty() {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Account> cq = cb.createQuery(Account.class);
		cq.from(Account.class);
		try {
			em.createQuery(cq).getSingleResult();
			return false;
		} catch (NoResultException ignored) {
			return true;
		} catch (NonUniqueResultException ignored) {
			return false;
		}
	}

	public Account byName(String username) throws NoResultException {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Account> cq = cb.createQuery(Account.class);
		final Root<Account> account = cq.from(Account.class);
		cq.select(account);
		cq.where(cb.equal(account.get(Account_.name), username));
		return em.createQuery(cq).getSingleResult();
	}

	@Transactional
	public void merge(Account p) {
		em.merge(p);
	}


}
