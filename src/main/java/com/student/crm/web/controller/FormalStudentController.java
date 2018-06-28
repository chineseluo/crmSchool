package com.student.crm.web.controller;

import com.student.crm.domain.PotentialCustom;
import com.student.crm.page.AjaxResult;
import com.student.crm.query.PotentialCustomQueryObject;
import com.student.crm.service.IFormalStudentService;
import com.student.crm.service.IPotentialCustomService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.commons.io.IOUtils;
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
@RequestMapping("/formalStudent")
public class FormalStudentController {
    @Autowired
    private IFormalStudentService formalStudentService;
    @Autowired
    private IPotentialCustomService potentialCustomService;

    @RequestMapping("")
    public String index() {
        return "formalStudent";
    }



    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(PotentialCustom potentialCustom) {
        AjaxResult result = null;
        try {
            formalStudentService.updateByPrimaryKey(potentialCustom);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/updateClass")
    @ResponseBody
    public AjaxResult updateClass(PotentialCustom potentialCustom) {
        AjaxResult result = null;
        try {
            formalStudentService.updateClass(potentialCustom);
            result = new AjaxResult(true, "转班成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("转班失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/updateStudentStateToLoss")
    @ResponseBody
    public AjaxResult updateStudentStateToLoss( Long id) {
        AjaxResult result = null;
        try {
            formalStudentService.updateStudentStateToLoss(id);
            result = new AjaxResult(true, "学员流失成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("学员流失失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/updateStudentStateToDropOut")
    @ResponseBody
    public AjaxResult updateStudentStateToDropOut( Long id) {
        AjaxResult result = null;
        try {
            formalStudentService.updateStudentStateToDropOut(id);
            result = new AjaxResult(true, "学员休学成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("学员休学失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/payment")
    @ResponseBody
    public AjaxResult payment(  PotentialCustom potentialCustom,Long payment) {
        AjaxResult result = null;
        try {

            formalStudentService.payment(potentialCustom,payment);
            result = new AjaxResult(true, "付款成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("付款失败失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws Exception {

            String[] title={"真实姓名","销售人员","总学费","待交学费","缴费状态","入学时间","学校","QQ","电话","所在班级","学科","付款方式","状态"};
            WritableWorkbook workbook= Workbook.createWorkbook(new FileOutputStream("formalStudent.xls"));
            WritableSheet sheet = workbook.createSheet("正式学员", 0);
            Label label;
            for (int i = 0; i < title.length; i++) {
                label=new Label(i,0,title[i]);
                sheet.addCell(label);
            }
            PotentialCustomQueryObject qo = new PotentialCustomQueryObject();
            qo.setFormal_studentState(1l);
            List<PotentialCustom> list=potentialCustomService.queryPage(qo).getRows();
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");

            for (int i = 0; i < list.size(); i++) {
                label=new Label(0,i+1,list.get(i).getName());
                sheet.addCell(label);
                label=new Label(1,i+1,list.get(i).getMarketingMan() != null ?list.get(i).getMarketingMan().getUsername() :"" );
                sheet.addCell(label);
                label=new Label(2,i+1,list.get(i).getTotalTuition() != null ? list.get(i).getTotalTuition().toString() :"" );
                sheet.addCell(label);
                label=new Label(3,i+1,list.get(i).getDueTuition() != null ? list.get(i).getDueTuition().toString() : "");
                sheet.addCell(label);
                label=new Label(4,i+1,"");
                sheet.addCell(label);
                label=new Label(5,i+1,"");
                sheet.addCell(label);
                label=new Label(6,i+1,list.get(i).getSchoolOrTrainOrganization() );
                sheet.addCell(label);
                label=new Label(7,i+1,list.get(i).getQq());
                sheet.addCell(label);
                label=new Label(8,i+1,list.get(i).getTelephone());
                sheet.addCell(label);
                label=new Label(9,i+1,list.get(i).getCollegeClass());
                sheet.addCell(label);
                label=new Label(10,i+1,"");
                sheet.addCell(label);
                label=new Label(11,i+1,"现金支付");
                sheet.addCell(label);
                label=new Label(12,i+1,"已缴清");
            }
            workbook.write();
            workbook.close();
            response.setHeader("Content-Disposition", "attachment;filename=formalStudent.xls");
            IOUtils.copy(new FileInputStream("formalStudent.xls"),response.getOutputStream());




    }
}
