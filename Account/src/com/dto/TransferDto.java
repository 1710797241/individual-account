package com.dto;

public class TransferDto {
    private String  transferInAccount;
    private String  transferOutAccount;

    private String  tradePass;

    private String  money;

    public String getTransferInAccount() {
        return transferInAccount;
    }

    public void setTransferInAccount(String transferInAccount) {
        this.transferInAccount = transferInAccount;
    }

    public String getTransferOutAccount() {
        return transferOutAccount;
    }

    public void setTransferOutAccount(String transferOutAccount) {
        this.transferOutAccount = transferOutAccount;
    }

    public String getTradePass() {
        return tradePass;
    }

    public void setTradePass(String tradePass) {
        this.tradePass = tradePass;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
