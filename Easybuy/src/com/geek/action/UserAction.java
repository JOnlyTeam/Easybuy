package com.geek.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.geek.bean.EasybuyUser;
import com.geek.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private HttpSession session;
	
	private EasybuyUser user;
	
	private int userId;
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
	
	/**
	 * 后台新增用户
	 * @return
	 */
	public String createUser(){
		if(user.getEuSex().equals("1"))
			user.setEuSex("男");
		else
			user.setEuSex("女");
		session = ServletActionContext.getRequest().getSession();
		if(userService.isExisted(user.getEuUserName())){
			session.setAttribute("error", "用户已存在!");
			return "error";
		}
		else{
			userService.motifyUser(user);
			return "success";
		}
			
	}
	
	/**
	 * 后台更新用户
	 * @return
	 */
	public String motifyUser(){
		if(user.getEuSex().equals("1"))
			user.setEuSex("男");
		else
			user.setEuSex("女");
		userService.motifyUser(user);
		return "success";
	}
	
	/**
	 * 后台删除用户
	 * @return
	 */
	public String deleteUser(){
		//System.out.println(userId);
		userService.deleteUser(userId);
		return "success";
	}
	
	/**
	 * 载入用户列表
	 * @return
	 */
	public String userList(){
		List list = userService.getUserList();
		//System.out.println("用户列表"+list.size());
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("userList", list);
		return "success";
	}
	
	/**
	 * 跳转至用户信息修改页面
	 * @return
	 */
	public String makeUserFill(){
		EasybuyUser user = userService.getEasybuyUser(userId);
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("fillUser", user);
		return "success";
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


	public EasybuyUser getUser() {
		return user;
	}


	public void setUser(EasybuyUser user) {
		this.user = user;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
}
