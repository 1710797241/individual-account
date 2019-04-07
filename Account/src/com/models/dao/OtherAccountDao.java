package com.models.dao;

import java.util.List;
import java.util.Map;

import com.models.entity.Account;

public interface OtherAccountDao {

	public List<Account> selectAll();
	public String selectMaxCurrDayCode();
	public List<Account> selectByMap(Map<String, Object> map);

    public Integer checkBeforeInsert(String account_name);
    public Integer insertAccount (Account account);

    public Account selectAccountByCode(String account_code);
    public Integer modifyAccountByCode(Account account);

    public Integer deleteAccount(String account_code);
}
