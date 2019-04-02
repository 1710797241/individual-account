package com.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class User implements Serializable{
	@NotEmpty(message="请输入正确的姓名")
	private String name;
	@NotEmpty(message="请输入正确的邮箱")
	private String email;
	@NotEmpty(message="请输入正确的电话")
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
