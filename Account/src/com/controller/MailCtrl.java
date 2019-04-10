package com.controller;

import com.common.MailUtils;
import com.models.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

@Controller
public class MailCtrl {

    @RequestMapping(value = "sendEmail.do",method = RequestMethod.POST)
    public String   sendEmail(RedirectAttributes attr,HttpSession session,Model model,  @RequestParam("email") String email,String comfirmType){
        String resetPassToken = null;
        try {
        	System.out.println(comfirmType+"**************///////////");
            resetPassToken = MailUtils.sendMail(email, "重置账号密码", "Account/modifyPassIndex.do?comfirmType="+comfirmType);
            session.setAttribute("resetPassToken",resetPassToken);
            attr.addFlashAttribute("mailMsg","邮件已发送，请注意查看！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "redirect:securityIndex.do";
    }
    
    
    

}
