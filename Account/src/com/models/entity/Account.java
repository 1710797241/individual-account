package com.models.entity;

import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    private Integer id;
  
    private String account_code;
    @NotEmpty(message = "请输入正确的账号")

    private String account_name;
    @NotEmpty(message = "请输入正确的密码")

    private String account_password;

    private String trade_password;

    private BigDecimal account_balance= BigDecimal.valueOf(0);

    private Integer account_score=0;

    private Date last_login_time;

    private String user_identity;
    
    private String account_email;
    
    private String user_name;

    private String is_admin;
    
    private Date create_time;

    private String delete_status="no";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_code() {
        return account_code;
    }

    public void setAccount_code(String account_code) {
        this.account_code = account_code == null ? null : account_code.trim();
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name == null ? null : account_name.trim();
    }

    public String getAccount_password() {
        return account_password;
    }

    public void setAccount_password(String account_password) {
        this.account_password = account_password == null ? null : account_password.trim();
    }

    public String getTrade_password() {
        return trade_password;
    }

    public void setTrade_password(String trade_password) {
        this.trade_password = trade_password == null ? null : trade_password.trim();
    }

    public BigDecimal getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(BigDecimal account_balance) {
        this.account_balance = account_balance;
    }

    public Integer getAccount_score() {
        return account_score;
    }

    public void setAccount_score(Integer account_score) {
        this.account_score = account_score;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getUser_identity() {
        return user_identity;
    }

    public void setUser_identity(String user_identity) {
        this.user_identity = user_identity == null ? null : user_identity.trim();
    }
    
    

    public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin == null ? null : is_admin.trim();
    }

    
    public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getDelete_status() {
        return delete_status;
    }

    public void setDelete_status(String delete_status) {
        this.delete_status = delete_status == null ? null : delete_status.trim();
    }

	public String getAccount_email() {
		return account_email;
	}

	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}
    
}