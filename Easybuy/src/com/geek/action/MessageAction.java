package com.geek.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.geek.bean.EasybuyAnnouncement;
import com.geek.bean.EasybuyNews;
import com.geek.service.AnnouncementService;
import com.geek.service.NewsService;

public class MessageAction {
	
	private int newsId;
	private int annoId;
	private HttpSession session;
	private NewsService newsService;
	private AnnouncementService announcementService;
	
	public String newsView(){
		//System.out.println(productId);
		EasybuyNews news = newsService.getNewsInfo(newsId);
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("newsMessage", news);
		loadAnnoList();
		loadNewsList();
		return "success";	
	}
	
	public String annoView(){
		EasybuyAnnouncement anno = announcementService.getAnnoInfo(annoId);
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("annoMessage", anno);
		loadAnnoList();
		loadNewsList();
		return "success";	
	}
	
	public void loadNewsList(){
		List list = newsService.getNewsList();
		session.setAttribute("newsList", list);		
		
	}
	public void loadAnnoList(){
		List list = announcementService.getAnnouncementList();
		//System.out.println("--"+list.size());
		session.setAttribute("annoList", list);
	}
	public NewsService getNewsService() {
		return newsService;
	}
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}
	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public int getAnnoId() {
		return annoId;
	}

	public void setAnnoId(int annoId) {
		this.annoId = annoId;
	}
}
