package com.student.crm.web.controller;

import com.student.crm.domain.ClassRoomManage;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.ClassRoomManageQueryObject;
import com.student.crm.service.IClassRoomManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/classRoomManage")
public class ClassRoomManageController {
	@Autowired
	private IClassRoomManageService classRoomManageService;
	
	@RequestMapping("")
	public String index(){
		return "classRoomManage";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(ClassRoomManageQueryObject qo){
		PageResult pageResult = null;
		pageResult = classRoomManageService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(ClassRoomManage classRoomManage){
		AjaxResult result = null;
		try{
			classRoomManageService.insert(classRoomManage);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(ClassRoomManage classRoomManage){
		AjaxResult result = null;
		try{
			classRoomManageService.update(classRoomManage);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long classRoomManageId){
		AjaxResult result = null;
		try{
			classRoomManageService.delete(classRoomManageId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("删除失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/payList")
	@ResponseBody
	public List<ClassRoomManage> payList(){
		return classRoomManageService.selectAll();
	}
}
