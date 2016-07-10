package com.geek.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.geek.dao.EasybuyAnnouncementDAO;
import com.geek.dao.EasybuyNewsDAO;
import com.geek.dao.EasybuyProductCategoryDAO;
import com.geek.dao.EasybuyProductDAO;

public class IndexService {
	
	
	/**
	 * 加载新闻消息
	 */
	public static void loadNews(){
		EasybuyNewsDAO ebn = new EasybuyNewsDAO();
		Session session  = ebn.getSession();
		session.beginTransaction();
		List list = ebn.findAll();
		HttpSession httpsession = ServletActionContext.getRequest().getSession();
		httpsession.setAttribute("newsList", list);
	}
	
	
	/**
	 * 加载公告消息
	 */
	public static void loadAnnouncement(){
		EasybuyAnnouncementDAO ebn = new EasybuyAnnouncementDAO();
		Session session  = ebn.getSession();
		session.beginTransaction();
		List list = ebn.findAll();
		HttpSession httpsession = ServletActionContext.getRequest().getSession();
		httpsession.setAttribute("annoList", list);
	}
	
	
	/**
	 * 加载商品分类
	 */
	public static void loadClassify(){
		EasybuyProductCategoryDAO ebpc = new EasybuyProductCategoryDAO();
		Session session = ebpc.getSession();
		session.beginTransaction();
		List list = ebpc.findAll();
		HttpSession httpsession = ServletActionContext.getRequest().getSession();
		httpsession.setAttribute("category", list);
	}
	
	
	/**
	 * 加载今日特价
	 */
	public static void loadSalePrice(){
		EasybuyProductDAO ebp = new EasybuyProductDAO();
		Session session = ebp.getSession();
		session.beginTransaction();
		List list = ebp.findAll();
		HttpSession httpsession = ServletActionContext.getRequest().getSession();
		httpsession.setAttribute("promotions", list);
		System.out.println(list.size());
	}
	
	
	/**
	 * 加载热门商品
	 */
	public static void loadHotProduct(){
		EasybuyProductDAO ebp = new EasybuyProductDAO();
		Session session = ebp.getSession();
		session.beginTransaction();
		List list = ebp.findAll();
		HttpSession httpsession = ServletActionContext.getRequest().getSession();
		httpsession.setAttribute("deeshahots", list);
	}
}
