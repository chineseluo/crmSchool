package com.student.crm.web.controller;

import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.student.crm.query.PermissionQueryObject;
import com.student.crm.service.IPermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	IPermissionService permissionService;
	
	@RequestMapping("")
	public String index(){
		return "permission";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(PermissionQueryObject qo){
		PageResult pageResult = null;
		pageResult = permissionService.queryPagePage(qo);
		return pageResult;
	}
	@RequestMapping("/load")
	@ResponseBody
	public AjaxResult load(){
		AjaxResult result = null;
		try{
			permissionService.load();
			result = new AjaxResult(true,"加载权限成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("加载权限失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/queryPageDataForRoleForm")
	@ResponseBody
	public PageResult queryPageDataForRoleForm(){
		PageResult pageResult = null;
		pageResult = permissionService.queryPageForRoleForm();
		return pageResult;
	}
	@RequestMapping("/selectPageForRoleFormByRoleId")
	@ResponseBody
	public PageResult selectPageForRoleFormByRoleId(Long roleId){
		PageResult pageResult = null;
		pageResult = permissionService.selectPageForRoleFormByRoleId(roleId);
		return pageResult;
	}
	
}
