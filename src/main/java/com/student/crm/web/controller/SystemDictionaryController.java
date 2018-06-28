package com.student.crm.web.controller;

import com.student.crm.domain.SystemDictionary;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.SystemDictionaryQueryObject;
import com.student.crm.service.ISystemDictionaryService;
import com.student.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*/systemDictionary---->访问systemDictionary页面
/systemDictionary/list---->systemDictionary相关的数据
/systemDictionary/save--->保存对象*/
@Controller
@RequestMapping("/systemDictionary")
public class SystemDictionaryController {
	@Autowired
	private ISystemDictionaryService systemDictionaryService;
	@RequiresPermissions("systemDictionary:index")
	@PermissionName("数据字典列表")
	@RequestMapping("")
	public String index(){
		return "systemDictionary";
	}
	@RequiresPermissions("systemDictionary:list")
	@PermissionName("数据字典数据")
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(SystemDictionaryQueryObject qo){
        PageResult result = new PageResult(0l, systemDictionaryService.selectAll());
        return result;
	}
	@RequiresPermissions("systemDictionary:save")
	@RequestMapping("/save")
	@ResponseBody
	@PermissionName("数据字典新增")
	public AjaxResult save(SystemDictionary systemDictionary){
		AjaxResult result = null;
		try{
			systemDictionaryService.insert(systemDictionary);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员!");
		}
		return result;
	}
	@RequiresPermissions("systemDictionary:update")
	@PermissionName("数据字典更新")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(SystemDictionary systemDictionary){
		AjaxResult result = null;
		try{
			systemDictionaryService.updateByPrimaryKey(systemDictionary);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员!");
		}
		return result;
	}
	@RequiresPermissions("systemDictionary:delete")
	@PermissionName("数据字典删除")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		AjaxResult result = null;
		try{
			systemDictionaryService.deleteByPrimaryKey(id);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("删除失败,请联系管理员!");
		}
		return result;
	}
}
