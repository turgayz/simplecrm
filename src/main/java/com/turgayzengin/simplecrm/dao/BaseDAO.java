package com.turgayzengin.simplecrm.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class BaseDAO<T> implements IBaseDAO<T> {

	@Inject
	protected EntityManager em;

	@Inject
	protected Logger logger;

	public List<T> loadAll() {
		return null;
	}

	public void delete(T entity) {
		em.remove(entity);
	}

	public void insert(T entity) {
		logger.info("Inserting " + entity.getClass().getName());
		em.persist(entity);

	}

	public T update(T entity) {
		return em.merge(entity);
	}

	public T find(Class<T> type, Long id) {
		return (T) this.em.find(type, id);
	}

}