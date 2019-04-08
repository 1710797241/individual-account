package com.models.dao;

import com.models.entity.Account;
import com.models.entity.Transfer;

import java.util.List;
import java.util.Map;

public interface TransferDao {

    public Integer checkTradePass(Account account);

    public Integer modifyInAccount(Account account);

    public Integer modifyOutAccount(Account account);

    public Integer inserTransfer(Transfer transfer);

    public List<Transfer> selectTransfer(Map<String,Object> map);

    public String selectMaxCode();
}
