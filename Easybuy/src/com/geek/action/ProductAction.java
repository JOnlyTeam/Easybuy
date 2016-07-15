package com.geek.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.geek.bean.EasybuyOrder;
import com.geek.bean.EasybuyProduct;
import com.geek.service.OrderService;
import com.geek.service.ProductService;

public class ProductAction {
	private int pageNum;
	private int perpageNumber;
	private int productId;
	private HttpSession session;
	private ProductService productService;
	private OrderService  orderService;
	
	private int addNumber;
	private int parentId;
	private String className;
	private int classId;
	private int orderId;
	
	public String productView(){
		//System.out.println(productId);
		EasybuyProduct pro = productService.getProductInfo(productId);
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("product", pro);
		List list = productService.getLastLookProduct();
		//System.out.println("zuijinliulan"+list.size());
		session.setAttribute("LastLook", list);
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
		list = productService.getLastLookProduct();
		//System.out.println("zuijinliulan"+list.size());
		session.setAttribute("LastLook", list);
		return "success";
	}
	
	/**
	 * 分类管理
	 * @return
	 */
	public String productClass(){
		List list = productService.getCotegory();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("proClass", list);
		return "success";
	}
	
	/**
	 * 填充分类
	 * @return
	 */
	public String fillProductClass(){
		List list = productService.getCotegory();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("fillClass", list);
		return "success";
	}
	
	/**
	 * 添加分类
	 * @return
	 */
	public String updateProductClass(){
		productService.addProductClass(parentId, className);
		return "success";
	}
	/**
	 * 更新分类
	 */
	public String updateClass(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String parentId = ServletActionContext.getRequest().getParameter("parentId");
		String className = ServletActionContext.getRequest().getParameter("className");
		int id = (Integer) session.getAttribute("currentClass");
		productService.updateClass(id, Integer.parseInt(parentId), className);
		return "success";
	}
	/**
	 * 删除商品分类
	 * @return
	 */
	public String deleteProductClass(){
		productService.deleteProductClass(classId);
		return "success";
	}
	
	/**
	 * 分类修改跳转
	 */
	public String editClass(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("currentClass", classId);
		return "success";
	}
	/**
	 * 将商品放入购物车
	 * @return
	 */
	public String shoppingCart(){
		productService.addProduct(productId,addNumber);
		return "success";
	}
	/**
	 * 更新购物车商品数量
	 */
	public String updateShoppingCart(){
		productService.setProduct(productId, addNumber);
		return "success";
	}
	/**
	 * 从购物车删除商品
	 * @return
	 */
	public String delProFromCart(){
		productService.delProFromCart(productId);
		return "success";
	}
	/**
	 * 商品结算
	 * @return
	 */
	public String productAccount(){
		orderService.productAccount();
		return "success";
	}
	
	/**
	 * 后台载入商品列表
	 * @return
	 */
	public String loadProductList(){
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
	
	/**
	 * 加载订单
	 * @return
	 */
	public String loadOrderList(){
		List list = orderService.getOrderList(pageNum, perpageNumber);
		//System.out.println(list.size());
		//(Easybuy)list.get(1)
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("orderForPage", list);
		HashMap<String,Integer> page = new HashMap<String, Integer>();
		int currentPage = pageNum;
		page.put("currentPage", pageNum);
		int totalPage = orderService.getOrderNumber()/perpageNumber;
		if(orderService.getOrderNumber()%perpageNumber!=0)
			totalPage++;
		page.put("totalPage",totalPage);
		session.setAttribute("page", page);
		return "success";
	}
	
	/**
	 * 通过订单号或订货人查询订单
	 * @return
	 */
	public String queryOrder(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String userName = ServletActionContext.getRequest().getParameter("userName");
		String orderId = ServletActionContext.getRequest().getParameter("orderId");
		if(orderId != null && !orderId.isEmpty()){
			EasybuyOrder order = orderService.queryByOrderId(Integer.parseInt(orderId));
			session.removeAttribute("nameOrder");
			session.setAttribute("idOrder", order);
		}
		else if(userName != null && !userName.isEmpty()){
			List list = orderService.queryByUserName(userName);
			session.removeAttribute("idOrder");
			session.setAttribute("nameOrder", list);
		}
		return "success";
	}
	
	/**、
	 * 删除订单
	 * @return
	 */
	public String deleteOrder(){
		orderService.deleteOrder(orderId);
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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getAddNumber() {
		return addNumber;
	}

	public void setAddNumber(int addNumber) {
		this.addNumber = addNumber;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
