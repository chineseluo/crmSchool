package com.student.crm.web.controller;

import com.student.crm.domain.AttendanceExport;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.AttendanceExportQueryObject;
import com.student.crm.query.QueryObject;
import com.student.crm.service.IAttendanceExportService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/attendanceExport")
public class AttendanceExportController {
	@Autowired
    IAttendanceExportService attendanceExportService;
	
	@RequestMapping("")
	public String index(){
		return "attendanceExport";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(AttendanceExportQueryObject qo){
		PageResult pageResult = null;
		pageResult = attendanceExportService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(AttendanceExport attendanceExport){
		AjaxResult result = null;
		try{
			attendanceExportService.insert(attendanceExport);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(AttendanceExport attendanceExport){
		AjaxResult result = null;
		try{
			attendanceExportService.update(attendanceExport);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long attendanceExportId){
		AjaxResult result = null;
		try{
			attendanceExportService.delete(attendanceExportId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("删除失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/download")
	public void download(HttpServletResponse response) throws WriteException, IOException {
		String[] title = {"员工姓名", "出勤次数", "早退次数", "迟到次数"};
		WritableWorkbook workbook = Workbook.createWorkbook(new FileOutputStream("attendanceExport.xls"));
		WritableSheet sheet = workbook.createSheet("考勤", 0);
		Label label;
		for (int i = 0; i < title.length; i++) {
			label = new Label(i, 0, title[i]);
			sheet.addCell(label);
		}
		PageResult pageResult = null;
		pageResult = attendanceExportService.queryPage(new QueryObject());
		List<AttendanceExport> list=pageResult.getRows();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i < list.size(); i++) {
			label = new Label(0, i + 1,list.get(i).getEmployee_username());
			sheet.addCell(label);
			label = new Label(1, i + 1,String.valueOf(list.get(i).getAttendancedays()));
			sheet.addCell(label);
			label = new Label(2, i + 1,String.valueOf(list.get(i).getEarlydays()));
			sheet.addCell(label);
			label = new Label(3, i + 1,String.valueOf(list.get(i).getLatedays()));
			sheet.addCell(label);
		}
		workbook.write();
		workbook.close();
		response.setHeader("Content-Disposition", "attachment;filename=attendanceExport.xls");
		IOUtils.copy(new FileInputStream("attendanceExport.xls"), response.getOutputStream());
	}
}
