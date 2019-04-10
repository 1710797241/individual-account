package com.models.dao;

import com.models.entity.Account;
import com.models.entity.Withdraw;

public interface DepositDao {
    public Integer checkTradePass(Account account);

	public Integer updateAccountBalance(Account account);
	
	public Integer insertWithdraw(Withdraw withdraw);
	
    public String selectMaxCode(String currCode);

}
