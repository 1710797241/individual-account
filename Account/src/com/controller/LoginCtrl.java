package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.models.entity.Account;
import com.service.AccountService;


@Controller
public class LoginCtrl {

	@Autowired
	private AccountService accountService;
	@RequestMapping(value="/toLogin.do")
	public ModelAndView toLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value="/login.do")
	public String login(RedirectAttributes attr,Account account,HttpSession  session,String vtcode) {
		String checkcode_session = (String)session.getAttribute("checkcode_session");
		Account acc = null;
		if(checkcode_session.equals(vtcode)) {
			acc = accountService.login(account);

			if(acc != null) {
				session.setAttribute("currAcc", acc);
				return "redirect:otherAccountSearch.do";
			}else {
				attr.addFlashAttribute("loginRet", "账号或密码或验证吗错误，登录失败");
				return "redirect:toLogin.do";
			}
		}else {
			attr.addFlashAttribute("loginRet", "账号或密码或验证吗错误，登录失败");
			return "redirect:toLogin.do";
		}
		
		
	}
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession  session) {
		session.removeAttribute("currAcc");
		return "redirect:toLogin.do";
	}
}
