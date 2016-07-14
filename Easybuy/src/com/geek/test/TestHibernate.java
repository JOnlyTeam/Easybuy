package com.geek.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geek.bean.EasybuyUser;

public class TestHibernate {
	private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test  
	public void testSessionFactory() throws Exception{  
	    SessionFactory sessionFactory=(SessionFactory) ac.getBean("sessionFactory");  
	    EasybuyUser user = new EasybuyUser();
	    user.setEuUserName("789");
	    user.setEuBirthday("45564");
	    Session session = sessionFactory.openSession();
	    session.save(user);
	}  
}
