package com.student.crm.web.controller;

import com.student.crm.domain.ContractManage;
import com.student.crm.domain.Employee;
import com.student.crm.domain.OrderBill;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.OrderBillQueryObject;
import com.student.crm.service.IContractManageService;
import com.student.crm.service.IOrderBillService;
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
@RequestMapping("/orderBill")
public class OrderBillController {
	@Autowired
	private IOrderBillService orderBillService;
	@Autowired
	private IContractManageService contractManageService;

	
	@RequestMapping("")
	public String index(){
		return "orderBill";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(OrderBillQueryObject qo){
		PageResult pageResult = null;
		pageResult = orderBillService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(OrderBill orderBill, HttpServletRequest request, MultipartFile pic){
		AjaxResult result = null;
		try{
			if(pic.getSize() > 0){
				String uploadFile = FileUploadUtil.uploadFile(pic.getInputStream(), request, pic.getOriginalFilename());
				orderBill.setAccessory(uploadFile);//设置附件
			}
			orderBill.setState(0);//设置状态为 生成订单
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			orderBill.setSaleMan(employee);

			orderBillService.insert(orderBill);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(OrderBill orderBill, HttpServletRequest request, MultipartFile pic){
		AjaxResult result = null;
		try{
			if(pic.getSize()>0){
				String uploadFile = FileUploadUtil.uploadFile(pic.getInputStream(), request, pic.getOriginalFilename());
				orderBill.setAccessory(uploadFile);//设置附件
			}
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			orderBill.setRecentUpdateMan(employee);
			orderBill.setRecentUpdateTime(new Date());
			orderBillService.update(orderBill);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long orderBillId){
		AjaxResult result = null;
		try{
			orderBillService.delete(orderBillId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("删除失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/selfAudit")
	@ResponseBody
	public AjaxResult selfAudit(Long orderBillId){
		AjaxResult result = null;
		try{
			OrderBill orderBill = orderBillService.select(orderBillId);
			orderBill.setState(1);
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			orderBill.setRecentUpdateMan(employee);
			orderBill.setRecentUpdateTime(new Date());
			orderBillService.update(orderBill);
			result = new AjaxResult(true,"审核成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("审核失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/deptAudit")
	@ResponseBody
	public AjaxResult deptAudit(Long orderBillId){
		AjaxResult result = null;
		try{
			OrderBill orderBill = orderBillService.select(orderBillId);
			orderBill.setState(2);
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			orderBill.setRecentUpdateMan(employee);
			orderBill.setRecentUpdateTime(new Date());
			orderBillService.update(orderBill);
			result = new AjaxResult(true,"审核成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("审核失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/moneyAudit")
	@ResponseBody
	public AjaxResult moneyAudit(Long orderBillId){
		AjaxResult result = null;
		try{
			OrderBill orderBill = orderBillService.select(orderBillId);
			orderBill.setState(3);
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			orderBill.setRecentUpdateMan(employee);
			orderBill.setRecentUpdateTime(new Date());
			orderBillService.update(orderBill);
			ContractManage contract = new ContractManage();
			contract.setContractSn(UUID.randomUUID().toString().substring(16));
			contract.setState(0);
			contract.setTotalAmount(orderBill.getTotalAmount());
			contract.setAccessory(orderBill.getAccessory());
			contract.setClient(orderBill.getClient());
			contract.setOrderAmount(orderBill.getOrderAmount());
			contract.setSaleMan(orderBill.getSaleMan());
			contract.setMark(orderBill.getMark());
			contractManageService.insert(contract);
			result = new AjaxResult(true,"审核成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("审核失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/feiAudit")
	@ResponseBody
	public AjaxResult feiAudit(Long orderBillId){
		AjaxResult result = null;
		try{
			OrderBill orderBill = orderBillService.select(orderBillId);
			orderBill.setState(4);
			Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
			orderBill.setRecentUpdateMan(employee);
			orderBill.setRecentUpdateTime(new Date());
			orderBillService.update(orderBill);
			result = new AjaxResult(true,"处理成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("处理失败,请联系管理员！");
		}
		return result;
	}
}
