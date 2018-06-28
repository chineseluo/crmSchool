package com.student.crm.web.controller;

import com.student.crm.domain.SystemDictionaryItem;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.service.ISystemDictionaryItemService;
import com.student.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*/systemDictionaryItem---->访问systemDictionaryItem页面
/systemDictionaryItem/list---->systemDictionaryItem相关的数据
/systemDictionaryItem/save--->保存对象*/
@Controller
@RequestMapping("/systemDictionaryItem")
public class SystemDictionaryItemController {
	@Autowired
	private ISystemDictionaryItemService systemDictionaryItemService;
	@RequiresPermissions("systemDictionaryItem:index")
	@PermissionName("数据字典明细列表")
	@RequestMapping("")
	public String index(){
		return "systemDictionaryItem";
	}
	@RequiresPermissions("systemDictionaryItem:list")
	@PermissionName("数据字典明细数据")
	@RequestMapping("/queryBySystemDictionaryId")
	@ResponseBody
	public PageResult queryBySystemDictionaryId(Long id){
        PageResult result = new PageResult(0l, systemDictionaryItemService.queryBySystemDictionaryId(id));
        return result;
	}
	@RequiresPermissions("systemDictionaryItem:save")
	@RequestMapping("/save")
	@ResponseBody
	@PermissionName("数据字典明细新增")
	public AjaxResult save(SystemDictionaryItem systemDictionaryItem){
		AjaxResult result = null;
		try{
			systemDictionaryItemService.insert(systemDictionaryItem);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员!");
		}
		return result;
	}
	@RequiresPermissions("systemDictionaryItem:update")
	@PermissionName("数据字典明细更新")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(SystemDictionaryItem systemDictionaryItem){
		AjaxResult result = null;
		try{
			systemDictionaryItemService.updateByPrimaryKey(systemDictionaryItem);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员!");
		}
		return result;
	}
	@RequiresPermissions("systemDictionaryItem:quit")
	@PermissionName("数据字典明细删除")
	@RequestMapping("/quit")
	@ResponseBody
	public AjaxResult quit(Long id){
		AjaxResult result = null;
		try{
			systemDictionaryItemService.deleteByPrimaryKey(id);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("删除失败,请联系管理员!");
		}
		return result;
	}
	@RequestMapping("/payList")
	@ResponseBody
	public List<SystemDictionaryItem> payList(String sn){
		return systemDictionaryItemService.queryAllBySn(sn);
	}
}
