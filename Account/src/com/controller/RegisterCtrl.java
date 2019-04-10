package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterCtrl {

	@RequestMapping(value="/registerIndex.do")
	public ModelAndView registerIndex() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}
}
