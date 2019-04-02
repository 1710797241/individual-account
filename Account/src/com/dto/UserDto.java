package com.dto;

import java.util.List;

import javax.validation.Valid;

import com.entity.User;

public class UserDto {
	
	@Valid
	List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}
