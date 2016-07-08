package com.geek.util;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

public class LoginAndRegister {
	
	public static boolean isLegalUser(){
		ServletContext sc = ServletActionContext.getServletContext();
		String username = (String) sc.getAttribute("username");
		String password = (String) sc.getAttribute("password");
		//EasybuyUserDAO dao = new EasybuyUser
		return true;
	}
}
