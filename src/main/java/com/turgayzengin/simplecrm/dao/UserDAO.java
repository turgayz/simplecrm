package com.turgayzengin.simplecrm.dao;

import com.turgayzengin.simplecrm.model.User;

public class UserDAO extends BaseDAO<User>{

	public User findByUserName(String userName) {
		User user = null;
		try {
			user = (User) em.createNamedQuery("user.findByUserName")
								.setParameter("userName", userName)
								.getSingleResult();
		} catch(Exception e) {
			return null;
		}
		return user;
	}

}
