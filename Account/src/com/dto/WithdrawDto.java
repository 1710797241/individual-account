package com.dto;

public class WithdrawDto {
    private String  account_name;

    private String  tradePass;

    private String  money;

	

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
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
