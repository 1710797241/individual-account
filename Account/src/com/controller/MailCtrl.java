package com.controller;

import com.common.MailUtils;
import com.models.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

@Controller
public class MailCtrl {

    @RequestMapping(value = "sendEmail.do",method = RequestMethod.POST)
    public String   sendEmail(HttpSession session,Model model,  @RequestParam("email") String email){
        String resetPassToken = null;
        try {
            Account account = new Account();
            account.setAccount_code("A20190403001");
            account.setUser_identity("320888888888888888");
            session.setAttribute("account",account);
            resetPassToken = MailUtils.sendMail(email, "重置账号密码", "Account/modifyPassIndex.do");
            session.setAttribute("resetPassToken",resetPassToken);
            model.addAttribute("mailMsg","邮件已发送，请注意查看！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "Security";
    }

}
