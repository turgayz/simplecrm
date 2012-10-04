package com.turgayzengin.simplecrm.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.turgayzengin.simplecrm.dao.UserDAO;
import com.turgayzengin.simplecrm.model.User;


@Stateless
public class UserService {
	@Inject
	private Logger logger;
	
	public void setLogger(final Logger logger) {
		this.logger = logger;
	}

	@Inject
	private UserDAO userDAO;
	
	public void setUserDAO(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User findByUserName(String userName) {
		logger.info("Trying to find User with userName " + userName);
		User user = userDAO.findByUserName(userName);
		logger.info("Found " + user);
		return user;
	}

	public void insert(User user) {
		logger.info("Trying to insert user: " + user);
		userDAO.insert(user);
		logger.info("insert successful. id: " + user.getId());
	}

	public User find(long id) {
		logger.info("Trying to find User with id " + id);
		User User = userDAO.find(User.class, id);
		logger.info("Found " + User);
		return User;
	}
}
