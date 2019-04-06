package com.models.dao;

import java.util.List;
import java.util.Map;

import com.models.entity.Account;

public interface OtherAccountDao {

	public List<Account> selectAll();

    List<Account> selectByMap(Map<String, Object> map);
}
