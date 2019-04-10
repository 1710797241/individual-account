package com.models.entity;

import java.util.Date;

public class Deposit {
    private Integer id;

    private String deposit_code;


    private String type;

    private String fund_flow;

    private String account_code;

    private Integer deposit_amount;

    private Date deposit_time;

    private String delete_status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeposit_code() {
        return deposit_code;
    }

    public void setDeposit_code(String deposit_code) {
        this.deposit_code = deposit_code == null ? null : deposit_code.trim();
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

    public Integer getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(Integer deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public Date getDeposit_time() {
        return deposit_time;
    }

    public void setDeposit_time(Date deposit_time) {
        this.deposit_time = deposit_time;
    }

    public String getDelete_status() {
        return delete_status;
    }

    public void setDelete_status(String delete_status) {
        this.delete_status = delete_status == null ? null : delete_status.trim();
    }
}