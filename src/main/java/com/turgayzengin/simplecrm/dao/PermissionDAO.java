package com.turgayzengin.simplecrm.dao;

import com.turgayzengin.simplecrm.model.Permission;

public class PermissionDAO extends BaseDAO<Permission>{
	public Permission findByName(String name) {
		Permission permission = null;
		try {
			permission = (Permission) em.createNamedQuery("permission.findByName")
								.setParameter("name", name)
								.getSingleResult();
		} catch(Exception e) {
			return null;
		}
		return permission;
	}
}
