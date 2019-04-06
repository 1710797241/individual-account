package com.controller;

import com.models.entity.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class SecurityCtrl extends BaseCtrl  {

	@Autowired
	private AccountService accountService;
	@RequestMapping(value="/securityIndex.do",method=RequestMethod.GET)
	public String otherIndex(Model model) {
		
		
		
		return "Security";
	}
	@RequestMapping(value="/securityConfirm.do",method=RequestMethod.GET)
	public String securityModifyPass(Model model) {

	model.addAttribute("email","1710797241@qq.com");

		return "SendConfirmMail";
	}
	@RequestMapping(value="/modifyPassIndex.do",method=RequestMethod.GET)
	public String modifyPassIndex(HttpSession session,String token) {
		session.setAttribute("token",token);
		return "modifyPass";
	}
	@RequestMapping(value="/modifyPass.do",method=RequestMethod.POST)
	public String modifyPass(HttpSession session, @Valid Account account,Model model) {
		String resetPassToken =(String) session.getAttribute("resetPassToken");
		String token =(String) session.getAttribute("token");
		System.out.println(resetPassToken+":"+token+"----------------");
		if(resetPassToken.equals(token)){
			System.out.println(true+"---------------------------------------------------");
			int count = accountService.modifyPass(account);
			if(count>0){
				model.addAttribute("modifyResult","修改成功");
			}else {
				model.addAttribute("modifyResult","修改失败");
			}

		}else {
			model.addAttribute("modifyResult","修改失败");
			System.out.println(false+"---------------------------------------------------");
		}
		return "modifyPass";
	}
	@RequestMapping(value="/modifyTradePass.do",method=RequestMethod.POST)
	public String modifyTradePass(HttpSession session, @Valid Account account,Model model) {
		String resetPassToken =(String) session.getAttribute("resetPassToken");
		String token =(String) session.getAttribute("token");
		System.out.println(resetPassToken+":"+token+"----------------");
		if(resetPassToken.equals(token)){
			System.out.println(true+"---------------------------------------------------");
			int count = accountService.modifyTradePass(account);
			if(count>0){
				model.addAttribute("modifyResult","修改成功");
			}else {
				model.addAttribute("modifyResult","修改失败");
			}

		}else {
			model.addAttribute("modifyResult","修改失败");
			System.out.println(false+"---------------------------------------------------");
		}
		return "modifyTradePass";
	}
}
