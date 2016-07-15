package com.geek.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.geek.bean.EasybuyProduct;
import com.geek.bean.EasybuyProductCategory;
import com.geek.bean.EasybuyShopping;
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
	 * 商品总行数
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
	/**
	 * 添加新的商品分类
	 * @return
	 */
	public void addProductClass(int parentId,String className){
		EasybuyProductCategory cate = new EasybuyProductCategory();
		cate.setEpcParentId(parentId);
		cate.setEpcName(className);
		cdao.save(cate);
	}
	/**
	 * 更新商品分类
	 */
	public void updateClass(int id,int parentId,String className){
		EasybuyProductCategory cat = cdao.findById(id);
		cat.setEpcParentId(parentId);
		cat.setEpcName(className);
		cdao.attachDirty(cat);
	}
	/**
	 * 删除商品分类
	 * @return
	 */
	public void deleteProductClass(int id){
		EasybuyProductCategory cate = cdao.findById(id);
		cdao.delete(cate);
	}
	
	/**
	 * 购物车添加指定数量商品
	 * @return
	 */
	public void addProduct(int productId,int addNumber){
		HttpSession session = ServletActionContext.getRequest().getSession();
		HashMap<Integer,EasybuyShopping> cart= (HashMap<Integer, EasybuyShopping>) session.getAttribute("shoppingCart");
		if(cart == null)
			cart = new HashMap<Integer,EasybuyShopping>();
		EasybuyShopping ebs = cart.get(productId);
		if(ebs == null){
			ebs = new EasybuyShopping();
			ebs.setEpsBuyNum(addNumber);
			EasybuyProduct pro = dao.findById(productId);
			ebs.setEpsFileName(pro.getEpFileName());
			ebs.setEpsId(productId);
			ebs.setEpsPrice(pro.getEpPrice());
			ebs.setEpsStack(pro.getEpStock());
			ebs.setEpsName(pro.getEpName());
			ebs.setEpsTotalPrice(ebs.getEpsPrice()*ebs.getEpsBuyNum());
			cart.put(productId, ebs);
		}
		else{
			ebs.setEpsBuyNum(ebs.getEpsBuyNum()+addNumber);
			ebs.setEpsTotalPrice(ebs.getEpsPrice()*ebs.getEpsBuyNum());
		}
		session.removeAttribute("shoppingCart");
		session.setAttribute("shoppingCart", cart);
	}
	
	/**
	 * 购物车更新商品数量
	 */
	public void setProduct(int productId,int totalNumber){
		HttpSession session = ServletActionContext.getRequest().getSession();
		HashMap<Integer,EasybuyShopping> cart= (HashMap<Integer, EasybuyShopping>) session.getAttribute("shoppingCart");
		EasybuyShopping ebs = cart.get(productId);
		ebs.setEpsBuyNum(totalNumber);
		ebs.setEpsTotalPrice(ebs.getEpsPrice()*ebs.getEpsBuyNum());
		session.removeAttribute("shoppingCart");
		session.setAttribute("shoppingCart", cart);
	}
	
	/**
	 * 从购物车删除商品
	 * @return
	 */
	public void delProFromCart(int productId){
		HttpSession session = ServletActionContext.getRequest().getSession();
		HashMap<Integer,EasybuyShopping> cart= (HashMap<Integer, EasybuyShopping>) session.getAttribute("shoppingCart");
		EasybuyShopping ebs = cart.get(productId);
		if(ebs.getEpsBuyNum()==1){
			cart.remove(productId);
		}
		else{
			ebs.setEpsBuyNum(ebs.getEpsBuyNum()-1);
			ebs.setEpsTotalPrice(ebs.getEpsTotalPrice()-ebs.getEpsPrice());
		}
		session.removeAttribute("shoppingCart");
		session.setAttribute("shoppingCart", cart);
		
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
