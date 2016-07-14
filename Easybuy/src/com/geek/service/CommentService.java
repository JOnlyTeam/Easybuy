package com.geek.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.geek.bean.EasybuyComment;
import com.geek.dao.EasybuyCommentDAO;

public class CommentService extends CommonService {
	private EasybuyCommentDAO dao;
	
	/**
	 * 获取留言消息列表
	 */
	public List getCommentList(){
		return dao.findAll();
	}
	
	/**
	 * 按分页获取留言列表，留言每页条数为五条
	 */
	public List getCommentByPage(int page,int number){
		String hql = "from EasybuyComment";
		List list = dao.findBySql(hql, (page-1)*number+1, number);
		return list;
	}
	/**
	 *新增留言
	 * @return
	 */
	public void createComment(EasybuyComment com){
		com.setEcCreateTime(new Timestamp(new Date().getTime()));
		dao.save(com);
	}
	public EasybuyCommentDAO getDao() {
		return dao;
	}

	public void setDao(EasybuyCommentDAO dao) {
		this.dao = dao;
	}
	
}
