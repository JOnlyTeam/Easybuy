package com.geek.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.object.SqlQuery;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		return ((SessionFactory)ac.getBean("sessionFactory")).openSession();
	}

	@Override
	public List findBySql(String hql) {
		// TODO Auto-generated method stub
		Query queryObject = getSession().createQuery(hql);
		return queryObject.list();
	}

	@Override
	public List findBySql(String hql, int start, int size) {
		// TODO Auto-generated method stub
		Query queryObject = getSession().createQuery(hql);
		queryObject.setFirstResult(start);
		queryObject.setMaxResults(size);
		return queryObject.list();
	}
	
	
	
}