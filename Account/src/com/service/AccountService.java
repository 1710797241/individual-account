package com.service;

import com.models.dao.AccountDao;
import com.models.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;
//    修改账户密码
    public int modifyPass(Account account){
        int count = accountDao.modifyPass(account);
        return count;
    }

//    修改交易密码
    public int modifyTradePass(Account account){
        int count = accountDao.modifyTradePass(account);
        return count;
    }

}
