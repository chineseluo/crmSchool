package com.student.crm.web.controller;

import com.student.crm.domain.Attendancesheet;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.AttendancesheetQueryObject;
import com.student.crm.service.IAttendancesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/attendancesheet")
public class AttendancesheetController {
    @Autowired
    IAttendancesheetService attendancesheetService;

    @RequestMapping("")
    public String index() {
        return "attendancesheet";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(AttendancesheetQueryObject qo) {
        PageResult pageResult = null;
        pageResult = attendancesheetService.queryPage(qo);
        return pageResult;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Attendancesheet attendancesheet) {
        AjaxResult result = null;
        try {
            Integer status=attendancesheetService.insert(attendancesheet);
            result = new AjaxResult(true, "签到成功",status);
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("签到失败," + e.getMessage());
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(Attendancesheet attendancesheet) {
        AjaxResult result = null;
        try {
            attendancesheetService.update(attendancesheet);
            result = new AjaxResult(true, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("保存失败,请联系管理员！");
        }
        return result;
    }

    @RequestMapping("/update1")
    @ResponseBody
    public AjaxResult update1(Attendancesheet attendancesheet) {
        AjaxResult result = null;
        try {
            attendancesheetService.update1(attendancesheet);
            result = new AjaxResult(true, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("保存失败,请联系管理员！");
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long attendancesheetId) {
        AjaxResult result = null;
        try {
            attendancesheetService.delete(attendancesheetId);
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("删除失败,请联系管理员！");
        }
        return result;
    }

    @RequestMapping("/sign")
    @ResponseBody
    public List<Map<String, Object>> sign() {
        return attendancesheetService.queryList();
    }
}
