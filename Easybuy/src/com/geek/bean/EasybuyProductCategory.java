package com.geek.bean;

/**
 * EasybuyProductCategory entity. @author MyEclipse Persistence Tools
 */

public class EasybuyProductCategory implements java.io.Serializable {

	// Fields

	private Integer epcId;
	private String epcName;
	private Integer epcParentId;

	// Constructors

	/** default constructor */
	public EasybuyProductCategory() {
	}

	/** full constructor */
	public EasybuyProductCategory(String epcName, Integer epcParentId) {
		this.epcName = epcName;
		this.epcParentId = epcParentId;
	}

	// Property accessors

	public Integer getEpcId() {
		return this.epcId;
	}

	public void setEpcId(Integer epcId) {
		this.epcId = epcId;
	}

	public String getEpcName() {
		return this.epcName;
	}

	public void setEpcName(String epcName) {
		this.epcName = epcName;
	}

	public Integer getEpcParentId() {
		return this.epcParentId;
	}

	public void setEpcParentId(Integer epcParentId) {
		this.epcParentId = epcParentId;
	}

}