package com.student.crm.web.controller;

import com.student.crm.domain.Linkman;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.LinkmanQueryObject;
import com.student.crm.service.ILinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/linkman")
public class LinkmanController {
    @Autowired
    private ILinkmanService linkmanService;

    @RequestMapping("")
    public String index() {
        return "linkman";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(LinkmanQueryObject qo) {
        return linkmanService.query(qo);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            linkmanService.deleteByPrimaryKey(id);
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("删除失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Linkman linkman) {
        AjaxResult result = null;
        try {
            linkmanService.insert(linkman);
            result = new AjaxResult(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("增加失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(Linkman linkman) {
        AjaxResult result = null;
        try {
            linkmanService.updateByPrimaryKey(linkman);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }
}
