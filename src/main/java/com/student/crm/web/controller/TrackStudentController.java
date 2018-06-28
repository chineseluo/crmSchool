package com.student.crm.web.controller;

import com.student.crm.domain.TrackStudent;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.TrackStudentQueryObject;
import com.student.crm.service.ITrackStudentService;
import com.student.crm.util.FileUploadUtil;
import com.student.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/*/trackStudent---->访问trackStudent页面
/trackStudent/list---->trackStudent相关的数据
/trackStudent/save--->保存对象*/
@Controller
@RequestMapping("/trackStudent")
public class TrackStudentController {
	@Autowired
	private ITrackStudentService trackStudentService;
	@RequiresPermissions("trackStudent:index")
	@PermissionName("学员跟踪列表")
	@RequestMapping("")
	public String index(){
		return "trackStudent";
	}
	@RequiresPermissions("trackStudent:list")
	@PermissionName("学员跟踪数据")
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(TrackStudentQueryObject qo){
		PageResult result = trackStudentService.queryPage(qo);

		return result;
	}
	@RequiresPermissions("trackStudent:save")
	@RequestMapping("/save")
	@ResponseBody
	@PermissionName("学员跟踪新增")
	public AjaxResult save( MultipartFile multipartFile,TrackStudent trackStudent, HttpServletRequest httpRequest){
		AjaxResult result = null;
        String fileName = null;


        try{


            InputStream inputStream = multipartFile.getInputStream();

            if (inputStream != null ) {
                fileName = FileUploadUtil.uploadFile(inputStream, httpRequest,multipartFile.getOriginalFilename() );
                trackStudent.setFileAddress(fileName);

            }

			trackStudentService.insert(trackStudent);

            result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("保存失败,请联系管理员!");
		}
		return result;
	}

	@RequiresPermissions("trackStudent:update")
	@PermissionName("学员跟踪更新")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(MultipartFile multipartFile,TrackStudent trackStudent,HttpServletRequest httpRequest){
		AjaxResult result = null;
        String fileName = null;

        try{



            InputStream inputStream = multipartFile.getInputStream();

            if (inputStream != null) {

                FileUploadUtil.deleteFile(trackStudent.getFileAddress(), httpRequest);
                fileName = FileUploadUtil.uploadFile(inputStream, httpRequest, multipartFile.getOriginalFilename());
                trackStudent.setFileAddress(fileName);
            }




			trackStudentService.updateByPrimaryKey(trackStudent);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("更新失败,请联系管理员!");
		}
		return result;
	}
	@RequiresPermissions("trackStudent:delete")
	@PermissionName("学员跟踪删除")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		AjaxResult result = null;
		try{
			trackStudentService.deleteByPrimaryKey(id);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult("删除失败,请联系管理员!");
		}
		return result;
	}


}
