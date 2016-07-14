package com.geek.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.geek.bean.EasybuyProduct;
import com.geek.dao.EasybuyProductCategoryDAO;
import com.geek.dao.EasybuyProductDAO;

public class ProductService extends CommonService {
	private EasybuyProductDAO dao;
	private EasybuyProductCategoryDAO cdao;
	
	
	
	/**
	 * 加载商品分类
	 */
	public List getCotegory(){
		List list = cdao.findAll();
		if(list == null)
			list = new ArrayList();
		return list;
	}
	
	/**
	 * 加载今日特价
	 */
	public List getSalePriceProducts(){
		String hql = "from EasybuyProduct order by ep_bargain desc";
		List list = dao.findBySql(hql, 0, 8);
		//System.out.println("今日特价"+list.size());
		if(list == null)
			list = new ArrayList();
		return list;
	}
	
	
	/**
	 * 加载热门商品
	 */
	public List getHotSalesProducts(){
		String hql = "from EasybuyProduct order by ep_saled desc";
		List list = dao.findBySql(hql, 0, 12);
		//System.out.println("热门商品"+list.size());
		if(list == null)
			list = new ArrayList();
		return list;
	}
	
	/**
	 * 商品详情
	 * @return
	 */
	public EasybuyProduct getProductInfo(int id){
		return dao.findById(id);
	}
	
	/**
	 * 获取某页商品
	 * @return
	 */
	public List getProductListByPage(int page,int number){
		String hql = "from EasybuyProduct";
		List list = dao.findBySql(hql, (page-1)*number+1, number);
		if(list == null)
			list = new ArrayList();
		return list;
	}
	
	/**
	 * 商品总页数
	 * @return
	 */
	public int getProductPage(){
		List list = dao.findAll();
		return list.size();
	}
	
	/**
	 * 获取保存最近浏览Cookie的列表
	 * @return
	 */
	public List getCookie(){
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		List<Cookie> list = new ArrayList();
		for (Cookie cookie : cookies) {
			if(cookie.getName().startsWith("LastLook_"))
				list.add(cookie);
		}
		//System.out.println(list.size());
		return list;
	}
	
	/**
	 * 根据Cookie获取最近浏览的商品列表
	 * @return
	 */
	public List getLastLookProduct(){
		List cookies = getCookie();
		List<EasybuyProduct> result = new ArrayList();
		for (Object object : cookies) {
			Cookie cookie = (Cookie)object;
			int id = Integer.parseInt(cookie.getValue());
			result.add(getProductInfo(id));
		}
		return result;
	}
	
	public EasybuyProductDAO getDao() {
		return dao;
	}

	public void setDao(EasybuyProductDAO dao) {
		this.dao = dao;
	}

	public EasybuyProductCategoryDAO getCdao() {
		return cdao;
	}

	public void setCdao(EasybuyProductCategoryDAO cdao) {
		this.cdao = cdao;
	}
	
}
