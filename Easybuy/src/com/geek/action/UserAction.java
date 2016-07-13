package com.geek.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.geek.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private HttpSession session;
	
	private String userName;
	private String passWord;
	private String rePassWord;
	private String kaptcha;
	
	private UserService userService;
	
	public String register(){
		session = ServletActionContext.getRequest().getSession();
		String kaptchaExpected =  (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//System.out.println(userName+" "+passWord+" "+ rePassWord + " " + kaptchaExpected + " " + kaptcha);
		if(kaptcha != null && kaptcha.equals(kaptchaExpected)){
			String info = userService.registerUser(userName, passWord, rePassWord);
			if("register success!".equals(info)){
				System.out.println("success");
				return "success";
			}
			else{
				session.setAttribute("error", info);
				System.out.println("error");
				return "register";
			}			
		}
		session.setAttribute("error", "验证码错误!");
		System.out.println("error2");
		return "register";
	}
	
	
	public String login(){
		session = ServletActionContext.getRequest().getSession();
		String kaptchaExpected =  (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(kaptcha != null && kaptcha.equals(kaptchaExpected)){
			String info = userService.loginUser(userName, passWord);
			if("登录成功".equals(info))
				return "success";
			else{
				session.setAttribute("error", info);
				return "login";
			}			
		}
		session.setAttribute("error", "验证码错误!");
		return "login";
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


	public String getKaptcha() {
		return kaptcha;
	}


	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
