package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.models.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	@RequestMapping(value="/otherAccountSearch.do")
	public String otherIndex(Model model,@RequestParam(value="pageNum",defaultValue="1") int pageNum,
							 @RequestParam(value="pageSize",defaultValue="8") int pageSize,
							 @RequestParam(value="accountName",required=false)String accountName,
							 @RequestParam(value="usercode",required=false)String usercode) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("pageNum",pageNum);
		map.put("pageSize",pageSize);
		map.put("accountName",accountName);
		map.put("usercode",usercode);
		PageInfo  pageInfo = otherAccountService.selectByMap(map);
		List<User> userList = userService.selectNameAndID();
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userList", userList);
		model.addAttribute("accountName", accountName);
		model.addAttribute("usercode", usercode);
		return "OtherAccount";
	}

	@RequestMapping(value="/otherAccountAdd.do")
	public String otherAccountAdd(Model model, Account account,RedirectAttributes attr) {
		int count = otherAccountService.insertAccount(account);
		if(count>0){
			attr.addFlashAttribute("addRet","账号添加成功");
		}else{
			attr.addFlashAttribute("addRet","账户已存在，添加失败");
		}
		return "redirect:otherAccountSearch.do";
	}
	@RequestMapping(value="/otherAccountDel.do")
	public String otherAccountDel(Model model, String account_code,RedirectAttributes attr) {
		Integer count = otherAccountService.delAccount(account_code);
		if(count>0){
			attr.addFlashAttribute("delRet", "注销成功");
		}else{
			attr.addFlashAttribute("delRet", "注销失败");
		}
		return "redirect:otherAccountSearch.do";
	}
	//修改前展示
	@RequestMapping(value="/otherAccountShowBeforeModify.do")
	public String otherAccountShowBeforeModify(Model model, String account_code) {
		Account account = otherAccountService.showBeforeModify(account_code);
		List<User> userList = userService.selectNameAndID();
		model.addAttribute("userList", userList);
		model.addAttribute("account",account);
		return "ModifyOtherAccount";
	}
	@RequestMapping(value="/otherAccountModify.do")

	public String otherAccounteModify(Model model, Account account,RedirectAttributes attr) {
		Integer count = otherAccountService.modifyAccount(account);

		if(count>0){
			attr.addFlashAttribute("modifyRet","修改成功");
		}else{
			attr.addFlashAttribute("modifyRet","修改失败");
		}
		return "redirect:otherAccountSearch.do";
	}
}
