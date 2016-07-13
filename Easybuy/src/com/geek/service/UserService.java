package com.geek.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.geek.bean.EasybuyUser;
import com.geek.dao.EasybuyUserDAO;

public class UserService extends CommonService{
	
	private EasybuyUserDAO dao;
	
	/**
	 * 检查用户名是否存在
	 * @param name
	 * @return
	 */
	public boolean isExisted(String name){
		
		List list = dao.findByEuUserName(name);
		
		if(list == null || list.size() == 0)
			return false;
		return true;
	}
	
	/**
	 * 注册用户
	 * @param name
	 * @param password
	 */
	public String registerUser(String name,String password,String repassword){
		if(password.equals(repassword))
			if(!isExisted(name)){
				EasybuyUser user = new EasybuyUser();
				user.setEuUserName(name);
				user.setEuPassword(password);
				dao.save(user);
				return "register success!";
			}
			else{
				return "user is existed!";
			}
		return "the repassword don't matched the password!";
		
	}
	
	/**
	 * 登录用户
	 * @param name
	 * @param password
	 * @return
	 */
	public String loginUser(String username,String password){
		String sql = "from EasybuyUser where (eu_user_name='" + username+ "') and (eu_password='" + password+ "')";
		List list = dao.findBySql(sql);
		if(list == null || list.size() == 0)
			return "用户名或密码错误";
		else{
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", list.get(0));
			return "登录成功";
		}
	}
	
	
	/**
	 * 后台更新用户
	 * @return
	 */
	public void motifyUser(EasybuyUser user){
		dao.attachDirty(user);
	}
	
	/**
	 * 后台删除用户
	 * @return
	 */
	public void deleteUser(int userId){
		EasybuyUser user = dao.findById(userId);
		dao.delete(user);
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	public List getUserList(){
		return dao.findAll();
	}
	
	/**
	 * 返回特定用户
	 * @return
	 */
	public EasybuyUser getEasybuyUser(int id){
		return dao.findById(id);
	}
	public EasybuyUserDAO getDao() {
		return dao;
	}

	public void setDao(EasybuyUserDAO dao) {
		this.dao = dao;
	}
}
