package com.goeswhere.frameworkgame.blogapp.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.goeswhere.frameworkgame.blogapp.dao.AccountDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	AccountDao accounts;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			return accounts.byName(username).toUser();
		} catch (NoResultException e) {
			throw new UsernameNotFoundException(username, e);
		}
	}
}
