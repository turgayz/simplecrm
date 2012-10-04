package com.turgayzengin.simplecrm.dao;


/**
 * Base interface for CRUD operations and common queries
 */
public interface IBaseDAO<T> {
	
	//public List<T> loadAll();
	
	public void insert(T domain);
		
	public T update(T domain);
		
	public void delete(T domain);
	
	//public T get(Serializable id);
	
	/**
	 * Get list by criteria
	 * @param detachedCriteria the domain query criteria, include condition and the orders.
	 * @return
	 * 
	 
	public List<T> getListByCriteria(DetachedCriteria detachedCriteria);
	
	public List<T> getListByCriteria(DetachedCriteria detachedCriteria, int offset, int size);
	*/	
}