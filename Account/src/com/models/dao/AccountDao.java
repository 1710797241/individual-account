package com.models.dao;

import java.math.BigDecimal;

import com.models.entity.Account;

public interface AccountDao {

	public Account login(Account account);

	public BigDecimal selectBalance(String account_name);
    //修改账户密码
    public int modifyPass(Account account);
    //修改交易密码
    public int modifyTradePass(Account account);

}
