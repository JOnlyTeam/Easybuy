package com.geek.action;

import com.geek.service.IndexService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		IndexService.loadNews();
		IndexService.loadAnnouncement();
		IndexService.loadClassify();
		IndexService.loadSalePrice();
		IndexService.loadHotProduct();
		return "success";
	}
	
}
