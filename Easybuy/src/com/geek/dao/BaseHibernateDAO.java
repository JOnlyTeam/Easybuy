package com.geek.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		return ((SessionFactory)ac.getBean("sessionFactory")).openSession();
	}
	
}