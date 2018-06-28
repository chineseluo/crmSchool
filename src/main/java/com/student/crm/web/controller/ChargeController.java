package com.student.crm.web.controller;

import com.student.crm.domain.Charge;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.ChargeQueryObject;
import com.student.crm.service.IChargeService;
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
@RequestMapping("/charge")
public class ChargeController {
    @Autowired
    private IChargeService chargeService;

    @RequestMapping("")
    public String index() {
        return "charge";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(ChargeQueryObject qo) {
        return chargeService.query(qo);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            chargeService.deleteByPrimaryKey(id);
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("删除失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Charge charge) {
        AjaxResult result = null;
        try {
            chargeService.insert(charge);
            result = new AjaxResult(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("增加失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(Charge charge) {
        AjaxResult result = null;
        try {
            chargeService.updateByPrimaryKey(charge);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/download")
    public void downloadJxl(HttpServletResponse response) throws Exception {
        String[] title = {"学员", "收费时间", "收费金额", "班级", "收款人", "收款方式", "收款单", "是否开票", "学科", "备注", "营销人", "班级变动"};
        WritableWorkbook workbook = Workbook.createWorkbook(new FileOutputStream("charge.xls"));
        WritableSheet sheet = workbook.createSheet("收费明细", 0);
        Label label;
        for (int i = 0; i < title.length; i++) {
            label = new Label(i, 0, title[i]);
            sheet.addCell(label);
        }
        List<Charge> list = chargeService.query(new ChargeQueryObject()).getRows();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudent() != null) {
                label = new Label(0, i + 1,list.get(i).getStudent().getName());
                sheet.addCell(label);
            }
            if (list.get(i).getChargeDate() != null) {
                label = new Label(1, i + 1, df.format(list.get(i).getChargeDate()));
                sheet.addCell(label);
            }
            if (list.get(i).getChargeMoney() != null) {
                label = new Label(2, i + 1, list.get(i).getChargeMoney().toString());
                sheet.addCell(label);
            }
            if(list.get(i).getClassroom()!=null){

            label = new Label(3, i + 1, list.get(i).getClassroom().getName());
            sheet.addCell(label);
            }
            if(list.get(i).getPayee()!=null){

            label = new Label(4, i + 1, list.get(i).getPayee().getUsername());
            sheet.addCell(label);
            }
            if(list.get(i).getChargeType()!=null){
            label = new Label(5, i + 1, list.get(i).getChargeType().getName());
            sheet.addCell(label);
            }
            label = new Label(6, i + 1, list.get(i).getBillNumber());
            sheet.addCell(label);
            if(list.get(i).isTicket()){

            label = new Label(7, i + 1,"是");
            sheet.addCell(label);
            }else{
            label = new Label(7, i + 1,"否");
            sheet.addCell(label);

            }
            if(list.get(i).getSubject()!=null){

            label = new Label(8, i + 1, list.get(i).getSubject().getName());
            sheet.addCell(label);
            }
            label = new Label(9, i + 1, list.get(i).getRemark());
            sheet.addCell(label);
            if(list.get(i).getMarketing()!=null){

            label = new Label(10, i + 1, list.get(i).getMarketing().getUsername());
            sheet.addCell(label);
            }
            label = new Label(11, i + 1, list.get(i).getClassChange());
            sheet.addCell(label);
        }
        workbook.write();
        workbook.close();
        response.setHeader("Content-Disposition", "attachment;filename=charge.xls");
        IOUtils.copy(new FileInputStream("charge.xls"), response.getOutputStream());
    }
}
