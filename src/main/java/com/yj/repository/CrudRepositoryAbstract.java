package com.yj.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudRepositoryAbstract<T, PK extends Serializable> {
	private Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	public void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T findOne(final PK id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public void saveOrUpdate(final T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(final T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(final PK entityId) {
		final T entity = findOne(entityId);
		delete(entity);
	}
}