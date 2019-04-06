package com.models.entity;

import java.util.Date;

public class Withdraw {
    private Integer id;

    private String withdraw_code;

    private String withdraw_site;

    private String type;

    private String fund_flow;

    private String account_code;

    private Integer withdraw_amount;

    private Date withdraw_time;

    private String delete_status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWithdraw_code() {
        return withdraw_code;
    }

    public void setWithdraw_code(String withdraw_code) {
        this.withdraw_code = withdraw_code == null ? null : withdraw_code.trim();
    }

    public String getWithdraw_site() {
        return withdraw_site;
    }

    public void setWithdraw_site(String withdraw_site) {
        this.withdraw_site = withdraw_site == null ? null : withdraw_site.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFund_flow() {
        return fund_flow;
    }

    public void setFund_flow(String fund_flow) {
        this.fund_flow = fund_flow == null ? null : fund_flow.trim();
    }

    public String getAccount_code() {
        return account_code;
    }

    public void setAccount_code(String account_code) {
        this.account_code = account_code == null ? null : account_code.trim();
    }

    public Integer getWithdraw_amount() {
        return withdraw_amount;
    }

    public void setWithdraw_amount(Integer withdraw_amount) {
        this.withdraw_amount = withdraw_amount;
    }

    public Date getWithdraw_time() {
        return withdraw_time;
    }

    public void setWithdraw_time(Date withdraw_time) {
        this.withdraw_time = withdraw_time;
    }

    public String getDelete_status() {
        return delete_status;
    }

    public void setDelete_status(String delete_status) {
        this.delete_status = delete_status == null ? null : delete_status.trim();
    }
}