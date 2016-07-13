package com.geek.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.geek.service.AnnouncementService;
import com.geek.service.NewsService;
import com.geek.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private HttpSession session;
	
	private ProductService productService;
	private NewsService newsService;
	private AnnouncementService announcementService;
	
	public String loadIndex(){
		
		session = ServletActionContext.getRequest().getSession();
		List list = productService.getCotegory();
		session.setAttribute("category", list);
		list = productService.getHotSalesProducts();
		session.setAttribute("hotSales", list);
		list = productService.getSalePriceProducts();
		session.setAttribute("salePrices", list);	
		list = newsService.getNewsList();
		session.setAttribute("newsList", list);		
		list = announcementService.getAnnouncementList();
		session.setAttribute("annoList", list);
		return "success";
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
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
	
}
