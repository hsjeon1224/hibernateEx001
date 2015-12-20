package com.usrsmile.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface BookDaoInterface <T, Id> extends Serializable 
{
	public void persist(T entity);
	public void update(T entity);
	public T fineById(Id id);
	public void delete(T entity);
	public List<T> findAll();
	public void deleteAll();
}
