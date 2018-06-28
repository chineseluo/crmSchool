package com.student.crm.web.controller;

import com.student.crm.domain.DayMission;
import com.student.crm.domain.Employee;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.DayMissionQueryObject;
import com.student.crm.service.IDayMissionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/dayMission")
public class DayMissionController {
    @Autowired
    private IDayMissionService dayMissionService;

    @RequestMapping("")
    public String index() {
        return "dayMission";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(DayMissionQueryObject qo) {
        return dayMissionService.query(qo);
    }
    @RequestMapping("/selfList")
    @ResponseBody
    public PageResult selfList(DayMissionQueryObject qo) throws ParseException {
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        qo.setUserId(user.getId());
        if(qo.getMissionTime()==null){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String s = sdf.format(new Date());
            qo.setCurrentTime(sdf.parse(s));
        }
        return dayMissionService.query(qo);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            dayMissionService.deleteByPrimaryKey(id);
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("删除失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(DayMission dayMission) {
        AjaxResult result = null;
        try {
            dayMissionService.insert(dayMission);
            result = new AjaxResult(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("增加失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(DayMission dayMission) {
        AjaxResult result = null;
        try {
            dayMissionService.updateByPrimaryKey(dayMission);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/updateStatusById")
    @ResponseBody
    public AjaxResult updateStatusById(DayMission dayMission) {
        AjaxResult result = null;
        try {
            dayMissionService.updateStatusById(dayMission);
            result = new AjaxResult(true, "标志成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("标志失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/selfUpdate")
    @ResponseBody
    public AjaxResult selfUpdate(DayMission dayMission) {
        AjaxResult result = null;
        try {
            dayMissionService.selfUpdate(dayMission);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }
}
