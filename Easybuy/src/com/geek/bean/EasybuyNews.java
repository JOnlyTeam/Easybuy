package com.geek.bean;

import java.sql.Timestamp;

/**
 * EasybuyNews entity. @author MyEclipse Persistence Tools
 */

public class EasybuyNews implements java.io.Serializable{

	// Fields

	private Integer enId;
	private String enTitle;
	private String enContent;
	private Timestamp enCreateTime;

	// Constructors

	/** default constructor */
	public EasybuyNews() {
	}

	/** full constructor */
	public EasybuyNews(String enTitle, String enContent, Timestamp enCreateTime) {
		this.enTitle = enTitle;
		this.enContent = enContent;
		this.enCreateTime = enCreateTime;
	}

	// Property accessors

	public Integer getEnId() {
		return this.enId;
	}

	public void setEnId(Integer enId) {
		this.enId = enId;
	}

	public String getEnTitle() {
		return this.enTitle;
	}

	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}

	public String getEnContent() {
		return this.enContent;
	}

	public void setEnContent(String enContent) {
		this.enContent = enContent;
	}

	public Timestamp getEnCreateTime() {
		return this.enCreateTime;
	}

	public void setEnCreateTime(Timestamp enCreateTime) {
		this.enCreateTime = enCreateTime;
	}

	

}