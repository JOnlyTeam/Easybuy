package com.geek.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.geek.bean.EasybuyNews;
import com.geek.dao.EasybuyNewsDAO;

public class NewsService extends CommonService {
	
	private EasybuyNewsDAO dao;
	
	/**
	 * 获取新闻消息列表
	 */
	public List getNewsList(){
		List list = dao.findAll();
		//System.out.println(list.size());
		return list;
	}
	/**
	 * 获取指定新闻消息列表
	 */
	public List getNewsList(int start,int size){
		String hql = "from EasybuyNews order by en_create_time desc";
		List list = dao.findBySql(hql,start,size);
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
	
	/**
	 * 添加新闻消息
	 * @return
	 */
	public void setNewsInfo(EasybuyNews news){
		dao.attachDirty(news);
	}

	/**
	 * 删除新闻消息
	 * @return
	 */
	public void deleteNewsInfo(int id){
		EasybuyNews news =  dao.findById(id);
		dao.delete(news);
	}
	
	/**
	 * 更新新闻消息
	 * @return
	 */
	public void updateNewsInfo(EasybuyNews news){
		EasybuyNews result = dao.findById(news.getEnId());
		result.setEnCreateTime(new Timestamp(new Date().getTime()));
		result.setEnContent(news.getEnContent());
		result.setEnTitle(news.getEnTitle());
		//System.out.println(result.getEnId());
		//System.out.println(result.getEnTitle());
		//System.out.println(result.getEnContent());
		//System.out.println(result.getEnCreateTime());
		dao.attachDirty(result);
	}
	public EasybuyNewsDAO getDao() {
		return dao;
	}

	public void setDao(EasybuyNewsDAO dao) {
		this.dao = dao;
	}
	
	
	
}
