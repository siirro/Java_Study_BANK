package com.iu.start.bankaccount;

import java.sql.Date;

public class BankAccountDTO {

	private Integer accountNum;
	private String userName;
	private Long bookNum;
	private Date accountdate;
	
	public Integer getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Date getAccountdate() {
		return accountdate;
	}
	public void setAccountdate(Date accountdate) {
		this.accountdate = accountdate;
	}
	
	
}
