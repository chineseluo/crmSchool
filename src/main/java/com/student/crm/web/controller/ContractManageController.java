package com.student.crm.web.controller;

import com.student.crm.domain.Employee;
import com.student.crm.domain.ContractManage;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.ContractManageQueryObject;
import com.student.crm.service.IContractManageService;
import com.student.crm.util.FileUploadUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/contractManage")
public class ContractManageController {
	@Autowired
	private IContractManageService contractManageService;

	@RequestMapping("")
	public String index(){
		return "contractManage";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(ContractManageQueryObject qo){
		PageResult pageResult = null;
		pageResult = contractManageService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(ContractManage contractManage, HttpServletRequest request, MultipartFile pic){
		AjaxResult result = null;
		try{
			if(pic==null){
				String uploadFile = FileUploadUtil.uploadFile(pic.getInputStream(), request, pic.getOriginalFilename());
				contractManage.setAccessory(uploadFile);//设置附件
			}
			contractManage.setState(0);//设置状态为 生成订单
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			contractManage.setSaleMan(employee);
			contractManage.setContractSn(UUID.randomUUID().toString().substring(16));
			contractManageService.insert(contractManage);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(ContractManage contractManage, HttpServletRequest request, MultipartFile pic){
		AjaxResult result = null;
		try{
			if(pic.getSize()>0){
				String uploadFile = FileUploadUtil.uploadFile(pic.getInputStream(), request, pic.getOriginalFilename());
				contractManage.setAccessory(uploadFile);//设置附件
			}
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			contractManage.setRecentUpdateMan(employee);
			contractManage.setRecentUpdateTime(new Date());
			contractManageService.update(contractManage);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long contractManageId){
		AjaxResult result = null;
		try{
			contractManageService.delete(contractManageId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("删除失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/selfAudit")
	@ResponseBody
	public AjaxResult selfAudit(Long contractManageId){
		AjaxResult result = null;
		try{
			ContractManage contractManage = contractManageService.select(contractManageId);
			contractManage.setState(1);
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			contractManage.setRecentUpdateMan(employee);
			contractManage.setRecentUpdateTime(new Date());
			contractManageService.update(contractManage);
			result = new AjaxResult(true,"审核成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("审核失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/deptAudit")
	@ResponseBody
	public AjaxResult deptAudit(Long contractManageId){
		AjaxResult result = null;
		try{
			ContractManage contractManage = contractManageService.select(contractManageId);
			contractManage.setState(2);
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			contractManage.setRecentUpdateMan(employee);
			contractManage.setRecentUpdateTime(new Date());
			contractManageService.update(contractManage);
			result = new AjaxResult(true,"审核成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("审核失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/moneyAudit")
	@ResponseBody
	public AjaxResult moneyAudit(Long contractManageId){
		AjaxResult result = null;
		try{
			ContractManage contractManage = contractManageService.select(contractManageId);
			contractManage.setState(3);
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			contractManage.setRecentUpdateMan(employee);
			contractManage.setRecentUpdateTime(new Date());
			contractManageService.update(contractManage);

			result = new AjaxResult(true,"审核成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("审核失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/feiAudit")
	@ResponseBody
	public AjaxResult feiAudit(Long contractManageId){
		AjaxResult result = null;
		try{
			ContractManage contractManage = contractManageService.select(contractManageId);
			contractManage.setState(4);
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			contractManage.setRecentUpdateMan(employee);
			contractManage.setRecentUpdateTime(new Date());
			contractManageService.update(contractManage);
			result = new AjaxResult(true,"处理成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("处理失败,请联系管理员！");
		}
		return result;
	}
}
