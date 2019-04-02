package com.dao;

import java.util.List;

import com.dto.UserDto;
import com.entity.User;

public interface UserDao {
	public List<User> selectAll();
	
	public Integer insertMany(UserDto userDto);
}
