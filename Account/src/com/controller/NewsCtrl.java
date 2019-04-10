package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.models.entity.Account;
import com.models.entity.News;
import com.models.entity.PageInfo;
import com.service.NewsService;

@Controller
public class NewsCtrl {
	@Autowired
	private NewsService newsService;
	@RequestMapping(value="/newsSearch.do")
	public String otherIndex(Model model,@RequestParam(value="pageNum",defaultValue="1") int pageNum,
							 @RequestParam(value="pageSize",defaultValue="8") int pageSize,
							 @RequestParam(value="newsCode",required=false)String newsCode,
							 @RequestParam(value="publisher_name",required=false)String publisher_name) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("pageNum",pageNum);
		map.put("pageSize",pageSize);
		map.put("newsCode",newsCode);
		map.put("publisher_name",publisher_name);
		PageInfo pageInfo = newsService.selectByMap(map);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("newsCode", newsCode);
		model.addAttribute("publisher_name", publisher_name);
		return "zixun";
	}

	@RequestMapping(value="/newsAdd.do")
	public String otherAccountAdd(HttpSession session, Model model, News news,RedirectAttributes attr) {
		Integer count = null;
		Account acc = (Account)session.getAttribute("currAcc");
		news.setNews_publisher(acc.getUser_identity());
		count = newsService.insertNews(news);
		if(count>0){
			attr.addFlashAttribute("addRet","添加成功");
		}else{
			attr.addFlashAttribute("addRet","添加失败");
		}
		return "redirect:newsSearch.do";
	}
	@RequestMapping(value="/newsDel.do")
	public String otherAccountDel(Model model, String news_code,RedirectAttributes attr) {
		Integer count = null;
		count = newsService.delNes(news_code);
		if(count>0){
			attr.addFlashAttribute("delRet","删除成功");
		}else{
			attr.addFlashAttribute("delRet","删除失败");
		}
		return "redirect:newsSearch.do";
	}
	@RequestMapping(value="/newsModifyShow.do")
	public String newsModifyShow(Model model, String news_code) {
		News news = newsService.modifyShowNes(news_code);
		model.addAttribute("news", news);
		return "ModifyNews";
	}
	
	@RequestMapping(value="/newsModify.do")
	public String newsModify(Model model, News news,RedirectAttributes attr) {
		Integer count = newsService.modifyNews(news);
		if(count>0){
			attr.addFlashAttribute("modRet","修改成功");
		}else{
			attr.addFlashAttribute("modRet","修改失败");
		}
		return "redirect:newsSearch.do";
	}
	
}
