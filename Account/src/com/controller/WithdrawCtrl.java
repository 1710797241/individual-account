package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.WithdrawDto;
import com.service.WithdrawService;


@Controller
public class WithdrawCtrl {

	@Autowired
	private WithdrawService withdrawService;
	@RequestMapping("/withdrawIndex.do")
	public String withdrawIndex() {
		
		return "qukuan";
		}
	
	
	@RequestMapping("/withdraw.do")
	public String withdraw(RedirectAttributes attr,WithdrawDto withdrawDto) {
		int count = withdrawService.withdraw(withdrawDto);
		if (count>0){
			attr.addFlashAttribute("withdrawRet","取款成功");
		}else{
			attr.addFlashAttribute("withdrawRet","交易密码错误，取款失败");
		}

		return "redirect:withdrawIndex.do";
		}
}
