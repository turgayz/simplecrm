package com.turgayzengin.simplecrm.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.turgayzengin.simplecrm.dao.PermissionDAO;
import com.turgayzengin.simplecrm.model.Permission;


@Stateless
public class PermissionService {
	@Inject
	PermissionDAO permissionDAO;

	private Logger logger;
	
	@Inject
    public void setLogger(final Logger logger) {
        this.logger = logger;
    }

	public Permission findByName(String name) {
		logger.info("Trying to find Permission with name " + name);
		Permission permission = permissionDAO.findByName(name);
		logger.info("Found " + permission);
		return permission;
	}

	public void insert(Permission permission) {
		logger.info("Trying to insert permission: " + permission);
		permissionDAO.insert(permission);
		logger.info("insert successful. id: " + permission.getId());
	}

	public Permission find(long id) {
		logger.info("Trying to find Permission with id " + id);
		Permission permission = permissionDAO.find(Permission.class, id);
		logger.info("Found " + permission);
		return permission;
	}
}
