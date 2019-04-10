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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TransferCtrl extends BaseCtrl  {

	@Autowired
	private TransferService transferService;
	
	@RequestMapping(value="/transferIndex.do")
	public String otherIndex(Model model) {
		
		
		
		return "Transfer";
	}
	@RequestMapping(value="/transfer.do")
	public String otherIndex(RedirectAttributes attr, TransferDto transferDto) {
		Integer count = transferService.transfer(transferDto);
		if (count>0){
			attr.addFlashAttribute("transferRet","转账成功");
		}else{
			attr.addFlashAttribute("transferRet","交易密码错误，转账失败");
		}

		return "redirect:transferIndex.do";
	}
	@RequestMapping(value="/selectTransfer.do")
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
