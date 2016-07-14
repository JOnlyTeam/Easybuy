package com.geek.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.geek.bean.EasybuyAnnouncement;
import com.geek.bean.EasybuyNews;
import com.geek.dao.EasybuyAnnouncementDAO;

public class AnnouncementService extends CommonService {
	
	private EasybuyAnnouncementDAO dao;
	
	
	/**
	 * 获取公告消息列表
	 */
	public List getAnnouncementList(){
		String hql = "from EasybuyAnnouncement order by ean_create_time desc";
		List list = dao.findBySql(hql,0,7);
		//System.out.println("公告消息列表" + list.size());
		return list;
	}
	
	/**
	 * 获取公告消息详情
	 * @return
	 */
	public EasybuyAnnouncement getAnnoInfo(int id){
		return dao.findById(id);
	}
	
	public EasybuyAnnouncementDAO getDao() {
		return dao;
	}

	public void setDao(EasybuyAnnouncementDAO dao) {
		this.dao = dao;
	}

}
