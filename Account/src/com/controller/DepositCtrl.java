package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.WithdrawDto;
import com.service.DepositService;


@Controller
public class DepositCtrl {

	@Autowired
	private DepositService depositService;
	@RequestMapping("/depositIndex.do")
	public String deposit() {
		
		return "qukuan";
		}
	
	
	@RequestMapping("/deposit.do")
	public String deposit(RedirectAttributes attr,WithdrawDto withdrawDto) {
		int count = depositService.withdraw(withdrawDto);
		if (count>0){
			attr.addFlashAttribute("withdrawRet","取款成功");
		}else{
			attr.addFlashAttribute("withdrawRet","交易密码错误，取款失败");
		}

		return "redirect:depositIndex.do";
		}
}
