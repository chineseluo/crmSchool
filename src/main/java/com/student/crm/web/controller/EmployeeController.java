package com.student.crm.web.controller;

import com.student.crm.domain.Employee;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.EmployeeQueryObject;
import com.student.crm.service.IEmployeeService;
import com.student.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*/employee---->访问employee页面
/employee/list---->employee相关的数据
/employee/save--->保存对象*/
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	@RequiresPermissions("employee:index")
	@PermissionName("员工列表")
	@RequestMapping("")
	public String index(){
		System.out.println("in......."+employeeService);
		return "employee";
	}
	@RequiresPermissions("employee:list")
	@PermissionName("员工数据")
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(EmployeeQueryObject qo){
		PageResult result = employeeService.queryPage(qo);
		return result;
	}
	@RequiresPermissions("employee:save")
	@RequestMapping("/save")
	@ResponseBody
	@PermissionName("员工新增")
	public AjaxResult save(Employee employee){
		AjaxResult result = null;
		try{
			employeeService.insert(employee);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员!");
		}
		return result;
	}
	@RequiresPermissions("employee:update")
	@PermissionName("员工更新")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(Employee employee){
		AjaxResult result = null;
		try{
			employeeService.updateByPrimaryKey(employee);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员!");
		}
		return result;
	}
	@RequiresPermissions("employee:quit")
	@PermissionName("员工离职")
	@RequestMapping("/quit")
	@ResponseBody
	public AjaxResult quit(Long id){
		AjaxResult result = null;
		try{
			employeeService.quit(id);
			result = new AjaxResult(true,"离职成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("离职失败,请联系管理员!");
		}
		return result;
	}
	@RequestMapping("/payList")
	@ResponseBody
	public List<Employee> payList(){
		return employeeService.selectAll();
	}
	@RequestMapping("/queryEmpByRoleSn")
	@ResponseBody
	public List<Employee> queryEmpByRoleSn(String sn ){
		return employeeService.queryEmpByRoleSn(sn);
	}
}
