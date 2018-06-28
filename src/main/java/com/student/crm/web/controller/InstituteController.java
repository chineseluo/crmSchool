package com.student.crm.web.controller;

import com.student.crm.domain.Institute;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.InstituteQueryObject;
import com.student.crm.service.IInstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/institute")
public class InstituteController {
    @Autowired
    private IInstituteService instituteService;

    @RequestMapping("")
    public String index() {
        return "institute";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(InstituteQueryObject qo) {
        return instituteService.query(qo);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            instituteService.deleteByPrimaryKey(id);
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("删除失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Institute institute) {
        AjaxResult result = null;
        try {
            instituteService.insert(institute);
            result = new AjaxResult(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("增加失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(Institute institute) {
        AjaxResult result = null;
        try {
            instituteService.updateByPrimaryKey(institute);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Institute> selectAll(){
        return instituteService.selectAll();
    }
}
