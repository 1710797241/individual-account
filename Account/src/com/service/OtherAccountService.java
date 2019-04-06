package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.models.dao.OtherAccountDao;
import com.models.entity.Account;
import com.models.entity.PageInfo;
import com.models.entity.User;

@Service
public class OtherAccountService {
	
	@Autowired
	private OtherAccountDao otherAccountDao;
	@Transactional
	public PageInfo selectAll(Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Account> accountList = otherAccountDao.selectAll();
		PageInfo<Account> pageInfo = new PageInfo<Account>(accountList);
		return pageInfo;
	}
	public PageInfo selectByMap (Map<String,Object> map){
		int pageNum =(int) map.get("pageNum");
		int pageSize =(int) map.get("pageSize");
		PageHelper.startPage(pageNum, pageSize);
		List<Account> accountList = otherAccountDao.selectByMap(map);
		System.out.println(accountList.size()+"-------------------------*******************");
		PageInfo<Account> pageInfo = new PageInfo<Account>(accountList);
		return pageInfo;



	}
}
