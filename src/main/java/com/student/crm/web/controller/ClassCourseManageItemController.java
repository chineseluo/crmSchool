package com.student.crm.web.controller;

import com.student.crm.domain.ClassCourseManageItem;
import com.student.crm.domain.ClassRoomManage;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.ClassCourseManageItemQueryObject;
import com.student.crm.service.IClassCourseManageItemService;
import com.student.crm.service.IClassRoomManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/classCourseManageItem")
public class ClassCourseManageItemController {
	@Autowired
	private IClassCourseManageItemService classCourseManageItemService;
	@Autowired
	private IClassRoomManageService classRoomManageService;

	@RequestMapping("")
	public String index(){
		return "classCourseManageItem";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(ClassCourseManageItemQueryObject qo){
		PageResult pageResult = null;
		pageResult = classCourseManageItemService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(ClassCourseManageItem classCourseManageItem){
		AjaxResult result = null;
		try{
			classCourseManageItemService.insert(classCourseManageItem);

			//ClassRoomManage classRoomManage = classRoomManageService.select(classCourseManageItem.getClassroomManage().getId());
			ClassRoomManage classroomManage = classCourseManageItem.getClassroomManage();
			classroomManage.setState(1);
			//classRoomManageService.update(classRoomManage);
			classRoomManageService.updateState(classroomManage);

			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(ClassCourseManageItem classCourseManageItem){
		AjaxResult result = null;
		try{
			classCourseManageItemService.update(classCourseManageItem);
			ClassRoomManage classroomManage = classCourseManageItem.getClassroomManage();
			classroomManage.setState(1);
			classRoomManageService.updateState(classroomManage);
			List<Long> ids=classRoomManageService.selectUnuseIds();//选出未使用教室的id
			Integer state=0;
			classRoomManageService.updateState2(state, ids);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long classCourseManageItemId){
		AjaxResult result = null;
		try{
			classCourseManageItemService.delete(classCourseManageItemId);
			List<Long> ids=classRoomManageService.selectUnuseIds();//选出未使用教室的id
			Integer state=0;
			classRoomManageService.updateState2(state, ids);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("删除失败,请联系管理员！");
		}
		return result;
	}
}
