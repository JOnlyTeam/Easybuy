package com.geek.bean;

import java.sql.Timestamp;

/**
 * EasybuyComment entity. @author MyEclipse Persistence Tools
 */

public class EasybuyComment implements java.io.Serializable {

	// Fields

	private Integer ecId;
	private String ecReply;
	private String ecContent;
	private Timestamp ecCreateTime;
	private Timestamp ecReplyTime;
	private String ecNickName;

	// Constructors

	/** default constructor */
	public EasybuyComment() {
	}

	/** full constructor */
	public EasybuyComment(String ecReply, String ecContent,
			Timestamp ecCreateTime, Timestamp ecReplyTime, String ecNickName) {
		this.ecReply = ecReply;
		this.ecContent = ecContent;
		this.ecCreateTime = ecCreateTime;
		this.ecReplyTime = ecReplyTime;
		this.ecNickName = ecNickName;
	}

	// Property accessors

	public Integer getEcId() {
		return this.ecId;
	}

	public void setEcId(Integer ecId) {
		this.ecId = ecId;
	}

	public String getEcReply() {
		return this.ecReply;
	}

	public void setEcReply(String ecReply) {
		this.ecReply = ecReply;
	}

	public String getEcContent() {
		return this.ecContent;
	}

	public void setEcContent(String ecContent) {
		this.ecContent = ecContent;
	}

	public Timestamp getEcCreateTime() {
		return this.ecCreateTime;
	}

	public void setEcCreateTime(Timestamp ecCreateTime) {
		this.ecCreateTime = ecCreateTime;
	}

	public Timestamp getEcReplyTime() {
		return this.ecReplyTime;
	}

	public void setEcReplyTime(Timestamp ecReplyTime) {
		this.ecReplyTime = ecReplyTime;
	}

	public String getEcNickName() {
		return this.ecNickName;
	}

	public void setEcNickName(String ecNickName) {
		this.ecNickName = ecNickName;
	}

}