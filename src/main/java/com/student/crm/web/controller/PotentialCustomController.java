package com.student.crm.web.controller;

import com.student.crm.domain.PotentialCustom;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.PotentialCustomQueryObject;
import com.student.crm.service.IPotentialCustomService;
import com.student.crm.util.PermissionName;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/potentialCustom")
public class PotentialCustomController {
	@Autowired
	private IPotentialCustomService potentialCustomService;


    @RequiresPermissions("employee:index")
    @PermissionName("售前列表")
    @RequestMapping("")
    public String index(){
        return "potentialCustom";
    }
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(PotentialCustomQueryObject qo){
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
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){

        AjaxResult result = null;
        try{
             potentialCustomService.deleteByPrimaryKey(id);
            result = new AjaxResult(true,"删除成功");
        }catch(Exception e){
            e.printStackTrace();
            result = new AjaxResult("删除失败,请联系管理员!");
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
	@RequestMapping("/saveFormalStudent")
	@ResponseBody
	public AjaxResult saveFormalStudent(PotentialCustom potentialCustom){

        AjaxResult result = null;
        try{
             potentialCustomService.saveFormalStudent(potentialCustom);
            result = new AjaxResult(true,"转正成功");
        }catch(Exception e){
            e.printStackTrace();
            result = new AjaxResult("转正失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<PotentialCustom> selectAll(){
	    return potentialCustomService.selectAll();
    }



    @RequestMapping("/downloadJxl")
    public void export(HttpServletResponse response) throws Exception {

        String[] title={"学员","销售人员","约访时间","下次跟进时间","QQ号码","电话号码","学校","意向程度","意向校区","意向班级","当前状态","备注"};
        WritableWorkbook workbook= Workbook.createWorkbook(new FileOutputStream("potenetialCustom.xls"));
        WritableSheet sheet = workbook.createSheet("潜在学员", 0);
        Label label;
        for (int i = 0; i < title.length; i++) {
            label=new Label(i,0,title[i]);
            sheet.addCell(label);
        }
        PotentialCustomQueryObject qo = new PotentialCustomQueryObject();
        qo.setStudentState(0l);
        List<PotentialCustom> list = potentialCustomService.queryPage(qo).getRows();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < list.size(); i++) {
            label=new Label(0,i+1,list.get(i).getName());
            sheet.addCell(label);
            label=new Label(1,i+1,list.get(i).getMarketingMan() != null ?list.get(i).getMarketingMan().getUsername() :"" );
            sheet.addCell(label);
            label=new Label(2,i+1,list.get(i).getVistitTime() != null ? list.get(i).getVistitTime().toLocaleString():"" );
            sheet.addCell(label);
            label=new Label(3,i+1,list.get(i).getNextFollowUpTime()!= null ? list.get(i).getNextFollowUpTime().toLocaleString(): "");
            sheet.addCell(label);
            label=new Label(4,i+1,list.get(i).getQq());
            sheet.addCell(label);
            label=new Label(5,i+1,"");
            sheet.addCell(label);
            label=new Label(6,i+1,list.get(i).getTelephone() );
            sheet.addCell(label);
            label=new Label(7,i+1,list.get(i).getSchoolOrTrainOrganization());
            sheet.addCell(label);
            label=new Label(8,i+1,list.get(i).getIntentionLevel() != null ?  list.get(i).getIntentionLevel().getName() : "");
            sheet.addCell(label);
            label=new Label(9,i+1,list.get(i).getIntentionSchoolRegion() != null ?  list.get(i).getIntentionSchoolRegion().getName(): "");
            sheet.addCell(label);
            label=new Label(10,i+1,list.get(i).getCurrentState() != null ? list.get(i).getCurrentState().getName():"");
            sheet.addCell(label);
            label=new Label(11,i+1,list.get(i).getRemark());
        }
        workbook.write();
        workbook.close();
        response.setHeader("Content-Disposition", "attachment;filename=potenetialCustom.xls");
        IOUtils.copy(new FileInputStream("potenetialCustom.xls"),response.getOutputStream());




    }
}
