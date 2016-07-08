package com.geek.common;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class Common<POJO> extends HibernateDaoSupport{
	 public void insertObject(POJO pojo){	  
	   this.getHibernateTemplate().save(pojo);
	 }

	 public void updateObject(POJO pojo){
	   this.getHibernateTemplate().update(pojo);
	 }

	 public void deleteObject(Class theClass, long id){
	   Object obj = this.getHibernateTemplate().load(theClass, id);
	   this.getHibernateTemplate().delete(obj);
	 }

	 public POJO loadObject(Class theClass, long id){
	   Object obj = this.getHibernateTemplate().load(theClass, id);
	   return (POJO) obj;
	 }

	 public List queryObjects(final String hql){
		 class Hc implements HibernateCallback{
			 public Object doInHibernate(Session session)throws HibernateException, SQLException {
				 return session.createQuery(hql).list();
			 }
		 }
	   return this.getHibernateTemplate().executeFind(new Hc());
	 }

	 public List queryObjects(Class theClazz){
	  return this.queryObjects("from " + theClazz.getSimpleName());
	 }
	}