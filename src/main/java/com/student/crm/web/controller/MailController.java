package com.student.crm.web.controller;

import com.student.crm.domain.Mail;
import com.student.crm.page.AjaxResult;
import com.student.crm.service.IMailService;
import com.student.crm.service.IPotentialCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("mail")
public class MailController {
    @Autowired
    private IPotentialCustomService potentialCustomService;
    @Autowired
    private IMailService mailService;
    @RequestMapping("/updateInformById")
    @ResponseBody
    public AjaxResult share(Long id, String email) {
        AjaxResult result = null;
        try {
            potentialCustomService.updateInformById(id,email);
            result = new AjaxResult(true, "发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("发送失败!"+e.getMessage());
        }
        return result;
    }
    @RequestMapping("/send")
    @ResponseBody
    public AjaxResult send(Mail mail) {
        AjaxResult result = null;
        try {
            mailService.send(mail);
            result = new AjaxResult(true, "发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,!"+e.getMessage());
        }
        return result;
    }
}
