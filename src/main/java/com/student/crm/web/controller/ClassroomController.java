package com.student.crm.web.controller;

import com.student.crm.domain.Classroom;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.ClassroomQueryObject;
import com.student.crm.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private IClassroomService classroomService;

    @RequestMapping("")
    public String index() {
        return "classroom";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(ClassroomQueryObject qo) {
        return classroomService.query(qo);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            classroomService.deleteByPrimaryKey(id);
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("删除失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Classroom classroom) {
        AjaxResult result = null;
        try {
            classroomService.insert(classroom);
            result = new AjaxResult(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("增加失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(Classroom classroom) {
        AjaxResult result = null;
        try {
            classroomService.updateByPrimaryKey(classroom);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/payList")
    @ResponseBody
    public List<Classroom> selectAll(){
        return classroomService.selectAll();
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Classroom> selectAll2(){
        return classroomService.selectAll();
    }
}
