package com.sapient.tdi.anno.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sapient.tdi.anno.JsGridView;
import com.sapient.tdi.anno.JsGridViewColumn;

@Entity
@Table(name="employee")
@JsGridView(name="Employee Data")
public class Employee {
	
	@Id
	@GeneratedValue
	@JsGridViewColumn(name="Employee Id")
	private Long id;
	
	@JsGridViewColumn(name="First Name")
	@Column(name="first_name")
	private String firstName;
	
	@JsGridViewColumn(name="Last Name")
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="department")
	@JsGridViewColumn(name="Department")
	private String dept;
	
	
	private String title;
	
	
	private BigDecimal salary;
	
	private Date doj;
	
	private Date dot;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Date getDot() {
		return dot;
	}
	public void setDot(Date dot) {
		this.dot = dot;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("id - %d, First name - %s, Last name - %s", id, firstName, lastName);
	}
	
	

}
