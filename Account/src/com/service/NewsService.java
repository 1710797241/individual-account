package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.GenerateCodeUtil;
import com.github.pagehelper.PageHelper;
import com.models.dao.NewsDao;
import com.models.entity.Account;
import com.models.entity.News;
import com.models.entity.PageInfo;

@Service
public class NewsService {

	@Autowired
	private NewsDao newsDao;
	
	//添加新闻
	@Transactional
	public Integer insertNews(News news) {
		Integer count =  null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String currDay = sdf.format(new Date());
        String maxCode = newsDao.selectMaxCurrDayCode(currDay);
        String nextCode = GenerateCodeUtil.generateCode(maxCode);
		news.setNew_code("N"+nextCode);
		news.setNews_datetime(new Date());
		count = newsDao.insertNews(news);
	
		
		
		return count;
	}
	//查看新闻
	@Transactional
	public PageInfo selectByMap (Map<String,Object> map){
		int pageNum =(int) map.get("pageNum");
		int pageSize =(int) map.get("pageSize");
		PageHelper.startPage(pageNum, pageSize);
		List<News> newsList = newsDao.selectByMap(map);
		PageInfo<News> pageInfo = new PageInfo<News>(newsList);
		return pageInfo;



	}
	//删除新闻
		@Transactional
		public Integer delNes (String news_code){
		Integer count = newsDao.deleteNews(news_code);

			return count;

		}
		
		//修改展示新闻
				@Transactional
				public News modifyShowNes (String news_code){
				News news = newsDao.selectByCode(news_code);

					return news;

				}
				//修改新闻
				@Transactional
				public Integer modifyNews (News news){
				Integer count = newsDao.updateNews(news);

					return count;

				}
}
