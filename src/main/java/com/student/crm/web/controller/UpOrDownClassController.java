package com.student.crm.web.controller;

import com.student.crm.domain.PotentialCustom;
import com.student.crm.query.PotentialCustomQueryObject;
import com.student.crm.service.IPotentialCustomService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/upOrDownClass")
public class UpOrDownClassController {
//	@Autowired
//	IUpOrDownClassService upOrDownClassService;
    @Autowired
    private IPotentialCustomService potentialCustomService;

    @RequestMapping("")
	public String index(){
		return "upOrDownClass";
	}

    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws Exception {

        String[] title={"真实姓名","销售人员","总学费","待交学费","缴费状态","入学时间","学校","QQ","电话","所在班级","学科","付款方式","状态"};
        WritableWorkbook workbook= Workbook.createWorkbook(new FileOutputStream("upOrDownClass.xls"));
        WritableSheet sheet = workbook.createSheet("正式学员", 0);
        Label label;
        for (int i = 0; i < title.length; i++) {
            label=new Label(i,0,title[i]);
            sheet.addCell(label);
        }
        PotentialCustomQueryObject qo = new PotentialCustomQueryObject();
        qo.setFormal_studentState(1l);
        List<PotentialCustom> list = potentialCustomService.queryPage(qo).getRows();
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
        response.setHeader("Content-Disposition", "attachment;filename=upOrDownClass.xls");
        IOUtils.copy(new FileInputStream("upOrDownClass.xls"),response.getOutputStream());




    }
}
