package com.student.crm.web.controller;

import com.student.crm.domain.Department;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.DepartmentQueryObject;
import com.student.crm.service.IDepartmentService;
import com.student.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;
	@RequiresPermissions("department:index")
	@PermissionName("部门列表")
	@RequestMapping("")
	public String index(){
		return "department";
	}
	@RequiresPermissions("department:list")
	@PermissionName("部门数据")
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(DepartmentQueryObject qo){
		PageResult result = departmentService.queryPage(qo);
		return result;
	}
	@RequiresPermissions("department:save")
	@PermissionName("部门数据")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Department dept){
		AjaxResult result = null;
		try{
			departmentService.insert(dept);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员!");
		}
		return result;
	}
	@RequiresPermissions("department:update")
	@PermissionName("部门更新")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(Department department){
		AjaxResult result = null;
		try{
			departmentService.updateByPrimaryKey(department);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员!");
		}
		return result;
	}

	@RequestMapping("/selectListForEmployeeForm")
	@ResponseBody
	public List<Department> selectListForEmployeeForm(){
		List<Department> result = departmentService.selectAll();
		return result;
	}
}
