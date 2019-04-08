package com.models.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Transfer {
    private Integer id;

    private String transfer_code;

    private String transfer_site;

    private String the_other_account_code;

    private String type="trasfer";

    private String fund_flow="pay";

    private String account_code;

    private BigDecimal tranfer_amount;

    private Date transfer_time;

    private String delete_status="no";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransfer_code() {
        return transfer_code;
    }

    public void setTransfer_code(String transfer_code) {
        this.transfer_code = transfer_code == null ? null : transfer_code.trim();
    }

    public String getTransfer_site() {
        return transfer_site;
    }

    public void setTransfer_site(String transfer_site) {
        this.transfer_site = transfer_site == null ? null : transfer_site.trim();
    }

    public String getThe_other_account_code() {
        return the_other_account_code;
    }

    public void setThe_other_account_code(String the_other_account_code) {
        this.the_other_account_code = the_other_account_code == null ? null : the_other_account_code.trim();
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

    public BigDecimal getTranfer_amount() {
        return tranfer_amount;
    }

    public void setTranfer_amount(BigDecimal tranfer_amount) {
        this.tranfer_amount = tranfer_amount;
    }

    public Date getTransfer_time() {
        return transfer_time;
    }

    public void setTransfer_time(Date transfer_time) {
        this.transfer_time = transfer_time;
    }

    public String getDelete_status() {
        return delete_status;
    }

    public void setDelete_status(String delete_status) {
        this.delete_status = delete_status == null ? null : delete_status.trim();
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transfer_code='" + transfer_code + '\'' +
                ", transfer_site='" + transfer_site + '\'' +
                ", the_other_account_code='" + the_other_account_code + '\'' +
                ", type='" + type + '\'' +
                ", fund_flow='" + fund_flow + '\'' +
                ", account_code='" + account_code + '\'' +
                ", tranfer_amount=" + tranfer_amount +
                ", transfer_time=" + transfer_time +
                ", delete_status='" + delete_status + '\'' +
                '}';
    }
}