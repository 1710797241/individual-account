package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.entity.User;
import com.models.entity.PageInfo;
import com.service.OtherAccountService;
import com.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class OtherAccountCtrl extends BaseCtrl  {
	
	@Autowired
	private OtherAccountService otherAccountService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/otherAccountIndex.do",method=RequestMethod.GET)
	public String otherIndex(Model model, @RequestParam(value="pageNum",defaultValue="1") int pageNum,
                             @RequestParam(value="pageSize",defaultValue="8") int pageSize) {
		PageInfo  pageInfo = otherAccountService.selectAll(pageNum,pageSize);
		List<User> userList = userService.selectNameAndID();
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userList", userList);
		return "OtherAccount";
	}
	@RequestMapping(value="/otherAccountSearch.do",method=RequestMethod.GET)
	public String otherIndex(Model model,@RequestParam(value="pageNum",defaultValue="1") int pageNum,
							 @RequestParam(value="pageSize",defaultValue="8") int pageSize,
							 @RequestParam(value="account")String account,
							 @RequestParam(value="usercode")String usercode) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("pageNum",pageNum);
		map.put("pageSize",pageSize);
		map.put("account",account);
		map.put("usercode",usercode);
		PageInfo  pageInfo = otherAccountService.selectByMap(map);
		List<User> userList = userService.selectNameAndID();
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userList", userList);
		return "OtherAccount";
	}
}
