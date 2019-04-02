package com.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.Result;
import com.dto.UserDto;
import com.service.UserService;

@Controller
public class UserController extends BaseCtrl {
	
	@Autowired
	private UserService userService;
	@RequestMapping(value="/show.do",method=RequestMethod.GET)
	@ResponseBody
	public Result selectForPage(@RequestParam(value="pageNum",defaultValue="1") int pageNum,
			@RequestParam(value="pageSize",defaultValue="1") int pageSize) {
		
		return this.send(userService.selectAll(pageNum,pageSize));
	}
	@RequestMapping(value="/add.do",method=RequestMethod.POST)
	@ResponseBody
	public Result add(@Valid UserDto userDto) {
		
		return this.send(userService.insertMany(userDto));
	}
}
