package com.controller;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.common.Result;
import com.models.entity.PageInfo;
import com.models.entity.User;
import com.service.UserService;

@Controller
public class UserController  {
	
	@Autowired
	private UserService userService;
	@RequestMapping(value="/userShow.do")
	public String selectForPage(Model model,@RequestParam(value="pageNum",defaultValue="1") int pageNum,
			@RequestParam(value="pageSize",defaultValue="8") int pageSize,
			@RequestParam(value="user_name",required=false)String user_name) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("pageNum",pageNum);
			map.put("pageSize",pageSize);
			map.put("user_name",user_name);
			PageInfo pageInfo = userService.selectAll(map);
			model.addAttribute("user_name", user_name);
			model.addAttribute("pageInfo", pageInfo);
			return "user";
		
	}
		@RequestMapping(value="/userAdd.do")
		public String userAdd(User user,RedirectAttributes attr) {
			Integer count = userService.insertMany(user);
			if(count>0){
				attr.addFlashAttribute("addRet","用户添加成功");
			}else{
				attr.addFlashAttribute("addRet","用户已存在，添加失败");
			}
			return "redirect:userShow.do";}
		
		@RequestMapping(value="/userDel.do")
		public String userDel(String user_identity,RedirectAttributes attr) {
			Integer count = userService.delUser(user_identity);
			if(count>0){
				attr.addFlashAttribute("delRet", "删除成功");
			}else{
				attr.addFlashAttribute("delRet", "删除失败");
			}
			return "redirect:userShow.do";
		}
	
		@RequestMapping(value="/userModifyShow.do")
		public String userModifyShow(String user_identity,Model model,RedirectAttributes attr) {
			User user = userService.modifyShowUser(user_identity);
			model.addAttribute("user", user);
			return "ModifyUser";
		}
		@RequestMapping(value="/userModify.do")
		public String userModify(User user,RedirectAttributes attr) {
			Integer count = userService.modifyUser(user);

			if(count>0){
				attr.addFlashAttribute("modifyRet","修改成功");
			}else{
				attr.addFlashAttribute("modifyRet","修改失败");
			}
			return "redirect:userShow.do";
		}
}
