package com.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.GenerateCodeUtil;
import com.dto.WithdrawDto;
import com.models.dao.AccountDao;
import com.models.dao.WithdrawDao;
import com.models.entity.Account;
import com.models.entity.Withdraw;


@Service
public class WithdrawService {

	@Autowired
	private WithdrawDao withdrawDao;
	@Autowired
	private AccountDao accountDao;
	
	//取款
	@Transactional
	public int withdraw(WithdrawDto withdrawDto) {
		Account acc = new Account();
		acc.setAccount_name(withdrawDto.getAccount_name());
		acc.setTrade_password(withdrawDto.getTradePass());
	
		Integer tradeTrue = withdrawDao.checkTradePass(acc);
		if(tradeTrue>0) {
			Integer count = null;
			//修改账户金额
			BigDecimal originBalance = accountDao.selectBalance(acc.getAccount_name());
			BigDecimal money = BigDecimal.valueOf(Integer.parseInt(withdrawDto.getMoney()));
			if(originBalance.compareTo(money)>0) {
				acc.setAccount_balance(originBalance.subtract(money));
				Integer updateCou = withdrawDao.updateAccountBalance(acc);
					
					//添加取款记录
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		    		String currDay = sdf.format(new Date());
	                String maxCode = withdrawDao.selectMaxCode(currDay);
	                String nextCode = GenerateCodeUtil.generateCode(maxCode);
	                
					Withdraw withdraw = new Withdraw();
					withdraw.setAccount_code(withdrawDto.getAccount_name());
					withdraw.setWithdraw_amount(Integer.parseInt(withdrawDto.getMoney()));
					withdraw.setWithdraw_code("W"+nextCode);
					withdraw.setWithdraw_time(new Date());
					count = withdrawDao.insertWithdraw(withdraw);
			}
			
			
			return count;
			
			
			
		}else {
			return 0;
		}
		
		
		
		
	}
}
