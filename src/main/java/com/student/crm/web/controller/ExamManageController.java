package com.student.crm.web.controller;

import com.student.crm.domain.ExamManage;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.ExamManageQueryObject;
import com.student.crm.service.IExamManageService;
import com.student.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*/examManage---->访问examManage页面
/examManage/list---->examManage相关的数据
/examManage/save--->保存对象*/
@Controller
@RequestMapping("/examManage")
public class ExamManageController {
	@Autowired
	private IExamManageService examManageService;
	@RequiresPermissions("examManage:index")
	@PermissionName("考试列表")
	@RequestMapping("")
	public String index(){
		return "examManage";
	}
	@RequiresPermissions("examManage:list")
	@PermissionName("考试数据")
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(ExamManageQueryObject qo){
		PageResult result = examManageService.queryPage(qo);

		return result;
	}
	@RequiresPermissions("examManage:save")
	@RequestMapping("/save")
	@ResponseBody
	@PermissionName("考试新增")
	public AjaxResult save(ExamManage examManage){
		AjaxResult result = null;
		try{
			examManageService.insert(examManage);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员!");
		}
		return result;
	}
	@RequestMapping("/examRegister")
	@ResponseBody
	@PermissionName("考试登记")
	public AjaxResult examRegister(ExamManage examManage){
		AjaxResult result = null;
		try{
			examManageService.insert(examManage);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员!");
		}
		return result;
	}
	@RequiresPermissions("examManage:update")
	@PermissionName("考试更新")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(ExamManage examManage){
		AjaxResult result = null;
		try{
			examManageService.updateByPrimaryKey(examManage);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员!");
		}
		return result;
	}
	@RequestMapping("/updateResult")
	@ResponseBody
	public AjaxResult updateResult(ExamManage examManage){
		AjaxResult result = null;
		try{
			examManageService.updateResult(examManage);
			result = new AjaxResult(true,"登记成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("登记失败,请联系管理员!");
		}
		return result;
	}


}
