package com.geek.bean;

/**
 * EasybuyProduct entity. @author MyEclipse Persistence Tools
 */

public class EasybuyProduct implements java.io.Serializable {

	// Fields

	private Integer epId;
	private String epName;
	private String epDescription;
	private Double epPrice;
	private String epStock;
	private Integer epcId;
	private Integer epcChildId;
	private String epFileName;
	private Integer epBargain;

	// Constructors

	/** default constructor */
	public EasybuyProduct() {
	}

	/** full constructor */
	public EasybuyProduct(String epName, String epDescription, Double epPrice,
			String epStock, Integer epcId, Integer epcChildId,
			String epFileName, Integer epBargain) {
		this.epName = epName;
		this.epDescription = epDescription;
		this.epPrice = epPrice;
		this.epStock = epStock;
		this.epcId = epcId;
		this.epcChildId = epcChildId;
		this.epFileName = epFileName;
		this.epBargain = epBargain;
	}

	// Property accessors

	public Integer getEpId() {
		return this.epId;
	}

	public void setEpId(Integer epId) {
		this.epId = epId;
	}

	public String getEpName() {
		return this.epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	public String getEpDescription() {
		return this.epDescription;
	}

	public void setEpDescription(String epDescription) {
		this.epDescription = epDescription;
	}

	public Double getEpPrice() {
		return this.epPrice;
	}

	public void setEpPrice(Double epPrice) {
		this.epPrice = epPrice;
	}

	public String getEpStock() {
		return this.epStock;
	}

	public void setEpStock(String epStock) {
		this.epStock = epStock;
	}

	public Integer getEpcId() {
		return this.epcId;
	}

	public void setEpcId(Integer epcId) {
		this.epcId = epcId;
	}

	public Integer getEpcChildId() {
		return this.epcChildId;
	}

	public void setEpcChildId(Integer epcChildId) {
		this.epcChildId = epcChildId;
	}

	public String getEpFileName() {
		return this.epFileName;
	}

	public void setEpFileName(String epFileName) {
		this.epFileName = epFileName;
	}

	public Integer getEpBargain() {
		return this.epBargain;
	}

	public void setEpBargain(Integer epBargain) {
		this.epBargain = epBargain;
	}

}