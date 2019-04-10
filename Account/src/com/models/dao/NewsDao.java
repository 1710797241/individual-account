package com.models.dao;

import java.util.List;
import java.util.Map;

import com.models.entity.News;

public interface NewsDao {
	public Integer deleteNews(String news_code);
	public Integer insertNews(News news);
	public String selectMaxCurrDayCode(String currCode);
	
	public List<News> selectByMap(Map<String, Object> map);
	
	public News selectByCode(String newsCode);
	
	
	public Integer updateNews(News news);
}
