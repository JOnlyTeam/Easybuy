package com.geek.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.geek.bean.EasybuyAnnouncement;
import com.geek.bean.EasybuyComment;
import com.geek.bean.EasybuyNews;
import com.geek.service.AnnouncementService;
import com.geek.service.CommentService;
import com.geek.service.NewsService;

public class MessageAction {
	
	private int newsId;
	private int annoId;
	private HttpSession session;
	private NewsService newsService;
	private AnnouncementService announcementService;
	private CommentService commentService;
	private EasybuyNews news;
	private EasybuyComment comment;
	private int id;
	private int page;
	
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
	
	
	/**
	 * 载入所有新闻列表
	 * @return
	 */
	public String newsList(){
		List list = newsService.getNewsList();
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("manage_news", list);
		return "success";
	}
	
	/**
	 * 载入所有留言
	 */
	public String commentList(){
		List list = commentService.getCommentList();
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("commentList", list);
		return "success";
	}
	
	/**
	 * 按分页载入留言
	 * @return
	 */
	public String commentListByPage(){
		List list = commentService.getCommentByPage(page, 5);
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("commentPage", list);
		HashMap<String,Integer> info = new HashMap<String,Integer>();
		int total = commentService.getCommentList().size();
		if(total % 5 == 0)
			info.put("totalPage", total/5);
		else
			info.put("totalPage", total/5+1);
		info.put("currentPage", page);
		session.setAttribute("pageInfo", info);
		return "success";
	}
	
	/**
	 * 新增留言
	 */
	public String createComment(){
		commentService.createComment(comment);
		return "success";
	}
	
	/**
	 * 获取最新七条新闻消息
	 */
	public void loadNewsList(){
		List list = newsService.getNewsList(0,7);
		session.setAttribute("newsList", list);		
		
	}
	
	/**
	 * 载入最近公告详情
	 */
	public void loadAnnoList(){
		List list = announcementService.getAnnouncementList();
		//System.out.println("--"+list.size());
		session.setAttribute("annoList", list);
	}
	
	/**
	 * 后台新增新闻
	 * @return
	 */
	public String createNews(){
		news.setEnCreateTime(new Timestamp(new Date().getTime()));
		newsService.setNewsInfo(news);
		return "success";
		
	} 
	
	/**
	 * 后台删除新闻
	 */
	public String deleteNews(){
		newsService.deleteNewsInfo(id);
		return "success";
	}
	
	/**
	 * 后台填充新闻
	 * @return
	 */
	public String fillNews(){
		EasybuyNews news = newsService.getNewsInfo(id);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("fillNews", news);
		return "success";
	}
	/**
	 * 后台更新新闻
	 * @return
	 */
	public String updateNews(){
		newsService.updateNewsInfo(news);
		return "success";
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

	public EasybuyNews getNews() {
		return news;
	}

	public void setNews(EasybuyNews news) {
		this.news = news;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public EasybuyComment getComment() {
		return comment;
	}

	public void setComment(EasybuyComment comment) {
		this.comment = comment;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
