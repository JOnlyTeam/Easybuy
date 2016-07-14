package com.geek.service;

import java.util.List;

import com.geek.bean.EasybuyNews;
import com.geek.dao.EasybuyNewsDAO;

public class NewsService extends CommonService {
	
	private EasybuyNewsDAO dao;
	
	/**
	 * 获取新闻消息列表
	 */
	public List getNewsList(){
		String hql = "from EasybuyNews order by en_create_time desc";
		List list = dao.findBySql(hql,0,7);
		//System.out.println(list.size());
		return list;
	}
	
	/**
	 * 获取新闻消息详情
	 * @return
	 */
	public EasybuyNews getNewsInfo(int id){
		return dao.findById(id);
	}

	public EasybuyNewsDAO getDao() {
		return dao;
	}

	public void setDao(EasybuyNewsDAO dao) {
		this.dao = dao;
	}
	
	
	
}
