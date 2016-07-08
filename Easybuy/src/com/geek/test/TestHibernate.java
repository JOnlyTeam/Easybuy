package com.geek.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernate {
	private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test  
	public void testSessionFactory() throws Exception{  
	    SessionFactory sessionFactory=(SessionFactory) ac.getBean("sessionFactory");  
	    System.out.println(sessionFactory);  
	}  
}
