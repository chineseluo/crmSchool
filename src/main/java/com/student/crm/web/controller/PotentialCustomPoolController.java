package com.student.crm.web.controller;

import com.student.crm.domain.History;
import com.student.crm.domain.PotentialCustom;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.PotentialCustomPoolQueryObject;
import com.student.crm.service.IPotentialCustomPoolSerivce;
import com.student.crm.service.IPotentialCustomService;
import com.student.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/potentialCustomPool")
public class PotentialCustomPoolController {
	@Autowired
	private IPotentialCustomService potentialCustomService;

	@Autowired
    private IPotentialCustomPoolSerivce potentialCustomPoolServiceImpl;

    @RequiresPermissions("employee:index")
    @PermissionName("潜在客户池列表")
    @RequestMapping("")
    public String index(){
        return "potentialCustomPool";
    }
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(PotentialCustomPoolQueryObject qo){
        try {

            PageResult result = potentialCustomService.queryPage(qo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(PotentialCustom potentialCustom){

        AjaxResult result = null;
        try{
             potentialCustomService.insert(potentialCustom);
            result = new AjaxResult(true,"保存成功");
        }catch(Exception e){
            e.printStackTrace();
            result = new AjaxResult("保存失败,请联系管理员!");
        }
        return result;



    }
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(PotentialCustom potentialCustom){

        AjaxResult result = null;
        try{
             potentialCustomService.updateByPrimaryKey(potentialCustom);
            result = new AjaxResult(true,"编辑成功");
        }catch(Exception e){
            e.printStackTrace();
            result = new AjaxResult("编辑失败,请联系管理员!");
        }
        return result;



    }
	@RequestMapping("/changeStudentState")
	@ResponseBody
	public AjaxResult changeStudentState(PotentialCustom potentialCustom){

        AjaxResult result = null;
        try{
             potentialCustomService.changeStudentState(potentialCustom);
            result = new AjaxResult(true,"修改成功");
        }catch(Exception e){
            e.printStackTrace();
            result = new AjaxResult("修改失败,请联系管理员!");
        }
        return result;



    }
	@RequestMapping("/removePotentialCustomPool")
	@ResponseBody
	public AjaxResult removePotentialCustomPool(History history){

        AjaxResult result = null;
        try{
            potentialCustomPoolServiceImpl.removePotentialCustomPool(history);
            result = new AjaxResult(true,"移交成功");
        }catch(Exception e){
            e.printStackTrace();
            result = new AjaxResult("移交失败,请联系管理员!");
        }
        return result;



    }
}
