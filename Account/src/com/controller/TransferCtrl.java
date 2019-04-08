package com.controller;

import com.dto.TransferDto;
import com.models.entity.PageInfo;
import com.models.entity.Transfer;
import com.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TransferCtrl extends BaseCtrl  {

	@Autowired
	private TransferService transferService;
	
	@RequestMapping(value="/transferIndex.do",method=RequestMethod.GET)
	public String otherIndex(Model model) {
		
		
		
		return "Transfer";
	}
	@RequestMapping(value="/transfer.do",method=RequestMethod.POST)
	public String otherIndex(Model model, TransferDto transferDto) {
		Integer count = transferService.transfer(transferDto);
		if (count>0){
			model.addAttribute("transferRet","转账成功");
		}else{
			model.addAttribute("transferRet","转账失败");
		}

		return "redirect:transferIndex.do";
	}
	@RequestMapping(value="/selectTransfer.do",method=RequestMethod.GET)
	public String selectTransfer(Model model,@RequestParam(value="pageNum",defaultValue="1") int pageNum,
								 @RequestParam(value="pageSize",defaultValue="8") int pageSize,
								 @RequestParam(value="startTime")String startTime,
								 @RequestParam(value="endTime")String endTime) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("pageNum",pageNum);
		map.put("pageSize",pageSize);
		map.put("startTime",startTime);
		map.put("endTime",endTime);
		PageInfo pageInfo = transferService.selectTransfer(map);
		return "redirect:transferIndex.do";
	}


}
