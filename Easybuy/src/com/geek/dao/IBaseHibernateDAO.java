package com.geek.dao;

import java.util.List;

import org.hibernate.Session;


/**
 * Data access interface for domain model
 * @author MyEclipse Persistence Tools
 */
public interface IBaseHibernateDAO {
	public Session getSession();
	public List findBySql(String sql);
	public List findBySql(String sql,int start,int size);
}