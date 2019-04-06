package com.models.entity;

import java.util.Date;

public class News {
    private Integer id;

    private String new_code;

    private String news_title;

    private String news_publisher;

    private Date news_datetime;

    private String delete_status;

    private String news_context;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNew_code() {
        return new_code;
    }

    public void setNew_code(String new_code) {
        this.new_code = new_code == null ? null : new_code.trim();
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title == null ? null : news_title.trim();
    }

    public String getNews_publisher() {
        return news_publisher;
    }

    public void setNews_publisher(String news_publisher) {
        this.news_publisher = news_publisher == null ? null : news_publisher.trim();
    }

    public Date getNews_datetime() {
        return news_datetime;
    }

    public void setNews_datetime(Date news_datetime) {
        this.news_datetime = news_datetime;
    }

    public String getDelete_status() {
        return delete_status;
    }

    public void setDelete_status(String delete_status) {
        this.delete_status = delete_status == null ? null : delete_status.trim();
    }

    public String getNews_context() {
        return news_context;
    }

    public void setNews_context(String news_context) {
        this.news_context = news_context == null ? null : news_context.trim();
    }
}