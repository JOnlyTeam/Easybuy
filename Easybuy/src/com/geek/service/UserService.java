package com.geek.service;

import java.util.List;

import org.hibernate.Session;

import com.geek.bean.EasybuyUser;
import com.geek.dao.EasybuyUserDAO;

public class UserService {
	
	/**
	 * 检查是否已经注册过，以及是否合法
	 * @return
	 */
	public static boolean isCanRegistered(String name,String password,String repassword){
		EasybuyUserDAO ebu = new EasybuyUserDAO();
		Session session = ebu.getSession();
		session.beginTransaction();
		List list = ebu.findByEuUserName(name);
		session.getTransaction().commit();
		session.close();
		if(list == null || list.size() == 0)
			if(password.equals(repassword))
				return true;
		return false;
	}
	
	/**
	 * 注册用户
	 * @param name
	 * @param password
	 */
	public static void registerUser(String name,String password){
		EasybuyUserDAO ebu = new EasybuyUserDAO();
		EasybuyUser user = new EasybuyUser();
		user.setEuUserName(name);
		user.setEuPassword(password);
		Session session = ebu.getSession();
		session.beginTransaction();
		ebu.save(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public static boolean isCanLogin(String name,String password){
		EasybuyUserDAO ebu = new EasybuyUserDAO();
		EasybuyUser user;
		Session session = ebu.getSession();
		List list = ebu.findByEuUserName(name);
		if(list != null && list.size() != 0){
			user = (EasybuyUser)list.get(0);
			if(user.getEuPassword().equals(password))
				return true;
		}
		return false;
	}
}
