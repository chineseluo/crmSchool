package com.student.crm.web.controller;

import com.student.crm.domain.ClassCourseManage;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.ClassCourseManageQueryObject;
import com.student.crm.service.IClassCourseManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/classCourseManage")
public class ClassCourseManageController {
	@Autowired
	private IClassCourseManageService classCourseManageService;
	
	@RequestMapping("")
	public String index(){
		return "classCourseManage";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(ClassCourseManageQueryObject qo){
		PageResult pageResult = null;
		pageResult = classCourseManageService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(ClassCourseManage classCourseManage){
		AjaxResult result = null;
		try{
			classCourseManageService.insert(classCourseManage);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(ClassCourseManage classCourseManage){
		AjaxResult result = null;
		try{
			classCourseManageService.update(classCourseManage);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long classCourseManageId){
		AjaxResult result = null;
		try{
			classCourseManageService.delete(classCourseManageId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("删除失败,请联系管理员！");
		}
		return result;
	}
}
