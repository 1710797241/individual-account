package com.models.dao;

import com.models.entity.Account;

public interface AccountDao {


    //修改账户密码
    public int modifyPass(Account account);
    //修改交易密码
    public int modifyTradePass(Account account);

}
