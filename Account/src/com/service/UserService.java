package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.dao.UserDao;
import com.dto.UserDto;
import com.models.entity.User;
import com.github.pagehelper.PageHelper;
import com.models.entity.PageInfo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public PageInfo selectAll(Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList = userDao.selectAll();
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		System.out.println(pageInfo.toString());
		return pageInfo;
	}
	@Transactional
	public  List<User> selectNameAndID(){
		List<User> userList = userDao.selectNameAndID();
		return userList;
	}
	
	@Transactional
	public Map<String,Object> insertMany(UserDto userDto){
		Map<String,Object> map = new HashMap<String,Object>();
		Integer count = userDao.insertMany(userDto);
		map.put("total", count);
		return map;
	}
}
