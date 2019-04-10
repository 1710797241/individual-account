package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.common.GenerateCodeUtil;
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
	public PageInfo selectByMap (Map<String,Object> map){
		int pageNum =(int) map.get("pageNum");
		int pageSize =(int) map.get("pageSize");
		PageHelper.startPage(pageNum, pageSize);
		List<Account> accountList = otherAccountDao.selectByMap(map);
		PageInfo<Account> pageInfo = new PageInfo<Account>(accountList);
		return pageInfo;



	}
	@Transactional
	public int insertAccount(Account account){
		Integer count = null;
		String codeHead = "A";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String currDay = sdf.format(new Date());
		String maxCode = otherAccountDao.selectMaxCurrDayCode(currDay);
		String nextCode = GenerateCodeUtil.generateCode(maxCode);
		account.setAccount_code(codeHead+nextCode);
		Integer exitCount = otherAccountDao.checkBeforeInsert(account.getAccount_name());
		if(exitCount>0){
			count=0;
		}else{
			account.setCreate_time(new Date());
			
			count = otherAccountDao.insertAccount(account);
		}


		return count;
	}

	@Transactional
    public Account showBeforeModify(String code){
            Account account = otherAccountDao.selectAccountByCode(code);
            return account;
    }

    @Transactional
    public Integer modifyAccount(Account account){

        Integer count = otherAccountDao.modifyAccountByCode(account);
        return count;
    }
    @Transactional
    public Integer delAccount(String code){

        Integer count = otherAccountDao.deleteAccount(code);

        return count;
    }
}
