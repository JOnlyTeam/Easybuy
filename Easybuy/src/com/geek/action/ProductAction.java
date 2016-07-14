package com.geek.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.geek.bean.EasybuyProduct;
import com.geek.service.ProductService;

public class ProductAction {
	private int pageNum;
	private int perpageNumber;
	private int productId;
	private HttpSession session;
	private ProductService productService;
	
	public String productView(){
		//System.out.println(productId);
		EasybuyProduct pro = productService.getProductInfo(productId);
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("product", pro);
		return "success";	
	}
	
	public String productByPage(){
		List list = productService.getProductListByPage(pageNum, perpageNumber);
		//System.out.println(list.size());
		//(Easybuy)list.get(1)
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("productForPage", list);
		HashMap<String,Integer> page = new HashMap<String, Integer>();
		int currentPage = pageNum;
		page.put("currentPage", pageNum);
		int totalPage = productService.getProductPage()/perpageNumber;
		if(productService.getProductPage()%perpageNumber!=0)
			totalPage++;
		page.put("totalPage",totalPage);
		session.setAttribute("page", page);
		return "success";
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPerpageNumber() {
		return perpageNumber;
	}

	public void setPerpageNumber(int perpageNumber) {
		this.perpageNumber = perpageNumber;
	}
}
