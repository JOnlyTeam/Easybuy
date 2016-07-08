package com.geek.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.geek.service.UserService;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private String userName;
	private String passWord;
	private String rePassWord;
	public String register(){
		//System.out.println(userName);
		//System.out.println(passWord);
		
		if(UserService.isCanRegistered(userName, passWord, rePassWord)){
			UserService.registerUser(userName, passWord);
			return "success";
		}		
		return "error";
	}
	
	
	public String login(){
		
		String kaptchaExpected = (String)ServletActionContext.getContext().getSession()
				.get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		
		String kaptchaReceived = (String)ServletActionContext.getRequest().getParameter("kaptcha");
		
		if(kaptchaExpected != null && kaptchaExpected.equals(kaptchaReceived))
			return "error";
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(UserService.isCanLogin(userName, passWord)){
			session.setAttribute("logedin", userName);
			return "success";
		}
		session.setAttribute("login_error", "用户名或密码错误");
		return "error";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRePassWord() {
		return rePassWord;
	}
	public void setRePassWord(String rePassWord) {
		this.rePassWord = rePassWord;
	}
}
