package com.sapient.tdi.anno.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sapient.tdi.anno.JsGridView;
import com.sapient.tdi.anno.JsGridViewColumn;

@Entity
@Table(name="account")
@JsGridView(name="Account Data")
public class Account {
	
	@Id
	@GeneratedValue
	@JsGridViewColumn(name="Account Id")
	private Long id;
	
	@JsGridViewColumn(name="Account Name")
	@Column(name="account_name")
	private String accountName;
	
	@JsGridViewColumn(name="Account Owner")
	@Column(name="account_owner")
	private String accountOwner;
	
	@Column(name="open_date")
	private Date openDate;
	
	@Column(name="close_date")
	private Date closeDate;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("id - %d, First name - %s, Last name - %s", id, accountName, accountOwner);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getAccountOwner() {
		return accountOwner;
	}


	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}


	public Date getOpenDate() {
		return openDate;
	}


	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}


	public Date getCloseDate() {
		return closeDate;
	}


	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
	

}
