package com.controller;

import com.models.entity.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String securityModifyPass(HttpSession session,String comfirmType) {
		session.setAttribute("comfirmType",comfirmType);
		return "SendConfirmMail";
	}
	@RequestMapping(value="/modifyPassIndex.do",method=RequestMethod.GET)
	public String modifyPassIndex(HttpSession session,String token,String comfirmType) {
		session.setAttribute("token",token);
		session.setAttribute("comfirmType",comfirmType);
		return "modifyPass";
	}
	//修改登录密码
	@RequestMapping(value="/modifyPass.do")
	public String modifyPass(String comfirmType,RedirectAttributes attr,HttpSession session,  Account account,Model model) {
		try {
			String resetPassToken =(String) session.getAttribute("resetPassToken");
			String token =(String) session.getAttribute("token");
			
			if(resetPassToken.equals(token)){
				Integer count = null;
				if(comfirmType.equals("account_pass")) {
					Account acc = (Account)session.getAttribute("currAcc");
					
					account.setAccount_code(acc.getAccount_code());
					count = accountService.modifyPass(account);
					if(count>0) {
						acc.setAccount_password(account.getAccount_password());
						session.setAttribute("currAcc", acc);
					}
				}
				if(comfirmType.equals("trade_pass")) {
					Account acc = (Account)session.getAttribute("currAcc");
					account.setAccount_code(acc.getAccount_code());
					account.setTrade_password(account.getAccount_password());
					count = accountService.modifyTradePass(account);
					if(count>0) {
						acc.setTrade_password(account.getTrade_password());
						session.setAttribute("currAcc", acc);
					}
				}
				 
				if(count>0){
					attr.addFlashAttribute("modifyResult","修改成功");
				}else {
					attr.addFlashAttribute("modifyResult","修改失败");
				}

			}else {
				attr.addFlashAttribute("modifyResult","修改失败");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:securityIndex.do";
	}
	
}
