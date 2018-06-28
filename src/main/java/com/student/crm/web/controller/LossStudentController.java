package com.student.crm.web.controller;

import com.student.crm.domain.PotentialCustom;
import com.student.crm.page.AjaxResult;
import com.student.crm.service.IPotentialCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lossStudent")
public class LossStudentController {
    @Autowired
    private IPotentialCustomService potentialCustomService;

    @RequestMapping("")
    public String index() {
        return "lossStudent";
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(PotentialCustom potentialCustom) {
        AjaxResult result = null;
        try {
            potentialCustomService.updateLossStudent(potentialCustom);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }

}
