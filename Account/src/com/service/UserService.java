package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.dao.UserDao;
import com.models.entity.User;
import com.github.pagehelper.PageHelper;
import com.models.entity.PageInfo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public PageInfo selectAll(Map<String, Object> map){
		
		int pageNum =(int) map.get("pageNum");
		int pageSize =(int) map.get("pageSize");
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList = userDao.selectAll(map);
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
	public Integer insertMany(User user){
		Integer count = null;
		int checkForInsert = userDao.checkForInsert(user);
		if(checkForInsert>0) {
			count = 0;
		}else {
		count = userDao.insertMany(user);
		}
		return count;
	}
	@Transactional
	public User modifyShowUser(String user_identity){
		User user = userDao.selectByCodeForModify(user_identity);
		return user;
	}
	@Transactional
	public Integer modifyUser(User user){
		Integer count = null;
		count = userDao.modifyUser(user);
		return count;
	}
	@Transactional
	public Integer delUser(String user_identity){
		Integer count = null;
		Integer checkBeforeDel = userDao.checkBeforeDel(user_identity);
		if(checkBeforeDel>0) {
			count = 0;
		}else {
		count = userDao.delUser(user_identity);
		}
		return count;
	}
	
}
