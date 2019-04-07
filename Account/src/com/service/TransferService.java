package com.service;

import com.common.GenerateCodeUtil;
import com.dto.TransferDto;
import com.github.pagehelper.PageHelper;
import com.models.dao.TransferDao;
import com.models.entity.Account;
import com.models.entity.PageInfo;
import com.models.entity.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TransferService {
    @Autowired
    private TransferDao transferDao;

//    转账
    public Integer transfer(TransferDto transferDto){
        Account account = new Account();
        account.setAccount_code(transferDto.getTransferOutAccount());
        account.setTrade_password(transferDto.getTradePass());
//        交易密码的校验
        Integer tradeCheck = transferDao.checkTradePass(account);
        if(tradeCheck>0){
            Transfer transfer = new Transfer();
            transfer.setAccount_code(transferDto.getTransferOutAccount());
            transfer.setThe_other_account_code(transferDto.getTransferInAccount());
            transfer.setTranfer_amount(BigDecimal.valueOf(Integer.parseInt(transferDto.getMoney())));

//        修改交易双方金额
            Integer inModify = transferDao.modifyOutAccount(transfer);
            Integer outModify =transferDao.modifyInAccount(transfer);
//        添加转账记录
                String maxCode = transferDao.selectMaxCode();
                String nextCode = GenerateCodeUtil.generateCode(maxCode);
                transfer.setTransfer_code("T"+nextCode);
                transfer.setTransfer_site("江苏南京");
                transfer.setTransfer_time(new Date());
                Integer trasferCount = transferDao.inserTransfer(transfer);
                return trasferCount;


        }else {
            return 0;
        }

    }

    //我的转账记录

    public PageInfo selectTransfer(Map<String,Object> map){
        int pageNum =(int) map.get("pageNum");
        int pageSize =(int) map.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List<Transfer> transferList = transferDao.selectTransfer(map);
        PageInfo<Transfer> pageInfo = new PageInfo<Transfer>(transferList);

        return pageInfo;
    }
}
