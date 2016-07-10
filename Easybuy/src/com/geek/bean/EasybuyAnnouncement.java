package com.geek.bean;

import java.sql.Timestamp;

/**
 * EasybuyAnnouncement entity. @author MyEclipse Persistence Tools
 */

public class EasybuyAnnouncement implements java.io.Serializable {

	// Fields

	private Integer eanId;
	private String eanTitle;
	private String eanContent;
	private Timestamp eanCreateTime;

	// Constructors

	/** default constructor */
	public EasybuyAnnouncement() {
	}

	/** full constructor */
	public EasybuyAnnouncement(String eanTitle, String eanContent,
			Timestamp eanCreateTime) {
		this.eanTitle = eanTitle;
		this.eanContent = eanContent;
		this.eanCreateTime = eanCreateTime;
	}

	// Property accessors

	public Integer getEanId() {
		return this.eanId;
	}

	public void setEanId(Integer eanId) {
		this.eanId = eanId;
	}

	public String getEanTitle() {
		return this.eanTitle;
	}

	public void setEanTitle(String eanTitle) {
		this.eanTitle = eanTitle;
	}

	public String getEanContent() {
		return this.eanContent;
	}

	public void setEanContent(String eanContent) {
		this.eanContent = eanContent;
	}

	public Timestamp getEanCreateTime() {
		return this.eanCreateTime;
	}

	public void setEanCreateTime(Timestamp eanCreateTime) {
		this.eanCreateTime = eanCreateTime;
	}

}