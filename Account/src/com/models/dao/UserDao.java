package com.models.dao;

import java.util.List;

import com.dto.UserDto;
import com.models.entity.User;

public interface UserDao {
	public List<User> selectAll();
	
	public List<User> selectNameAndID ();
	
	public Integer insertMany(UserDto userDto);
}
