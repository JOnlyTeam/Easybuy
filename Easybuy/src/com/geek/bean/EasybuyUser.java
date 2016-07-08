package com.geek.bean;

/**
 * EasybuyUser entity. @author MyEclipse Persistence Tools
 */

public class EasybuyUser implements java.io.Serializable {

	// Fields

	private Integer euUserId;
	private String euUserName;
	private String euPassword;
	private String euSex;
	private String euBirthday;
	private String euIdentityCode;
	private String euEmail;
	private String euMobile;
	private String euAddress;
	private String euStatus;

	// Constructors

	/** default constructor */
	public EasybuyUser() {
	}

	/** full constructor */
	public EasybuyUser(String euUserName, String euPassword, String euSex,
			String euBirthday, String euIdentityCode, String euEmail,
			String euMobile, String euAddress, String euStatus) {
		this.euUserName = euUserName;
		this.euPassword = euPassword;
		this.euSex = euSex;
		this.euBirthday = euBirthday;
		this.euIdentityCode = euIdentityCode;
		this.euEmail = euEmail;
		this.euMobile = euMobile;
		this.euAddress = euAddress;
		this.euStatus = euStatus;
	}

	// Property accessors

	public Integer getEuUserId() {
		return this.euUserId;
	}

	public void setEuUserId(Integer euUserId) {
		this.euUserId = euUserId;
	}

	public String getEuUserName() {
		return this.euUserName;
	}

	public void setEuUserName(String euUserName) {
		this.euUserName = euUserName;
	}

	public String getEuPassword() {
		return this.euPassword;
	}

	public void setEuPassword(String euPassword) {
		this.euPassword = euPassword;
	}

	public String getEuSex() {
		return this.euSex;
	}

	public void setEuSex(String euSex) {
		this.euSex = euSex;
	}

	public String getEuBirthday() {
		return this.euBirthday;
	}

	public void setEuBirthday(String euBirthday) {
		this.euBirthday = euBirthday;
	}

	public String getEuIdentityCode() {
		return this.euIdentityCode;
	}

	public void setEuIdentityCode(String euIdentityCode) {
		this.euIdentityCode = euIdentityCode;
	}

	public String getEuEmail() {
		return this.euEmail;
	}

	public void setEuEmail(String euEmail) {
		this.euEmail = euEmail;
	}

	public String getEuMobile() {
		return this.euMobile;
	}

	public void setEuMobile(String euMobile) {
		this.euMobile = euMobile;
	}

	public String getEuAddress() {
		return this.euAddress;
	}

	public void setEuAddress(String euAddress) {
		this.euAddress = euAddress;
	}

	public String getEuStatus() {
		return this.euStatus;
	}

	public void setEuStatus(String euStatus) {
		this.euStatus = euStatus;
	}

}