package com.student.crm.web.controller;

import com.student.crm.domain.MyDate;
import com.student.crm.page.AjaxResult;
import com.student.crm.query.MyDateQueryObject;
import com.student.crm.service.IMyDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/selfDate")
public class MyDateController {
    @Autowired
    private IMyDateService myDateService;

    @RequestMapping("")
    public String index() {
        return "selfDate";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<MyDate> list(MyDateQueryObject qo) {
        return myDateService.query(qo);
    }

    @RequestMapping("/addEvent")
    @ResponseBody
    public AjaxResult share(MyDate date) {
        AjaxResult result = null;
        try {
            if (date.getId() == null) {
                myDateService.insert(date);
                result = new AjaxResult(true, "增加成功");
            }else{
                myDateService.updateByPrimaryKey(date);
                result = new AjaxResult(true, "更改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("操作失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            myDateService.deleteByPrimaryKey(id);
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("删除失败,请联系管理员!");
        }
        return result;
    }
}
