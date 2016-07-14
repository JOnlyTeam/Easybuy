package com.geek.service;

import java.util.List;

import com.geek.dao.EasybuyCommentDAO;

public class CommentService extends CommonService {
	private EasybuyCommentDAO dao;
	
	/**
	 * 获取留言消息列表
	 */
	public List getAnnouncementList(){
		String sql = "";
		return dao.findAll();
	}

	public EasybuyCommentDAO getDao() {
		return dao;
	}

	public void setDao(EasybuyCommentDAO dao) {
		this.dao = dao;
	}
	
}
