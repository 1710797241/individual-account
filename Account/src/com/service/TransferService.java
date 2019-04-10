package com.service;

import com.common.GenerateCodeUtil;
import com.dto.TransferDto;
import com.github.pagehelper.PageHelper;
import com.models.dao.AccountDao;
import com.models.dao.TransferDao;
import com.models.entity.Account;
import com.models.entity.PageInfo;
import com.models.entity.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TransferService {
    @Autowired
    private TransferDao transferDao;

    @Autowired
    private AccountDao accountDao;
//    转账
    @Transactional
    public Integer transfer(TransferDto transferDto){
        Account account = new Account();
        account.setAccount_name(transferDto.getTransferOutAccount());
        account.setTrade_password(transferDto.getTradePass());
//        交易密码的校验
        Integer tradeCheck = transferDao.checkTradePass(account);
        System.out.println(tradeCheck+"****************************************/");
        if(tradeCheck>0){
            Transfer transfer = new Transfer();
            transfer.setAccount_code(transferDto.getTransferOutAccount());
            transfer.setThe_other_account_code(transferDto.getTransferInAccount());
            transfer.setTranfer_amount(BigDecimal.valueOf(Integer.parseInt(transferDto.getMoney())));
            System.out.println(transfer.toString()+"-----------------------------------------------");
//        修改交易双方金额
            account.setAccount_name(transfer.getAccount_code());
            BigDecimal transferOutBan = accountDao.selectBalance(transfer.getAccount_code());
            BigDecimal transferInBan = accountDao.selectBalance(transfer.getThe_other_account_code());
            BigDecimal tranfer_amount = transfer.getTranfer_amount();
            if(transferOutBan.compareTo(tranfer_amount)>0&&transferInBan.compareTo(tranfer_amount)>0) {
            	 account.setAccount_balance(transfer.getTranfer_amount());
            	 BigDecimal yu= transferOutBan.subtract(tranfer_amount);
            	 account.setAccount_balance(yu);
                 Integer inModify = transferDao.modifyAccount(account);
            	 account.setAccount_name(transfer.getThe_other_account_code());  
            	 account.setAccount_balance(transfer.getTranfer_amount());
            	 yu= transferInBan.add(tranfer_amount);
            	 account.setAccount_balance(yu);
            	 Integer outModify =transferDao.modifyAccount(account);
//               添加转账记录
 	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
 	    		String currDay = sdf.format(new Date());
                 String maxCode = transferDao.selectMaxCode(currDay);
                 String nextCode = GenerateCodeUtil.generateCode(maxCode);
                 transfer.setTransfer_code("T"+nextCode);
                 transfer.setTransfer_time(new Date());
                 Integer trasferCount = transferDao.inserTransfer(transfer);
                 return trasferCount;
            }else {
                return 0;
            }
          
            	


        }else {
            return 0;
        }

    }

    //我的转账记录
    @Transactional
    public PageInfo selectTransfer(Map<String,Object> map){
        int pageNum =(int) map.get("pageNum");
        int pageSize =(int) map.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List<Transfer> transferList = transferDao.selectTransfer(map);
        PageInfo<Transfer> pageInfo = new PageInfo<Transfer>(transferList);

        return pageInfo;
    }
}
