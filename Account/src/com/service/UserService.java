package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.dto.UserDto;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.entity.PageInfo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public Map<String,Object> selectAll(Integer pageNum,Integer pageSize){
		Map<String,Object> map = new HashMap<String,Object>();
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList = userDao.selectAll();
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		map.put("data", pageInfo);
		return map;
	}
	@Transactional
	public Map<String,Object> insertMany(UserDto userDto){
		Map<String,Object> map = new HashMap<String,Object>();
		Integer count = userDao.insertMany(userDto);
		map.put("total", count);
		return map;
	}
}
