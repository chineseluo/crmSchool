package com.student.crm.web.controller;

import com.student.crm.domain.Pay;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.PayQueryObject;
import com.student.crm.service.IPayService;
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
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private IPayService payService;

    @RequestMapping("")
    public String index() {
        return "pay";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(PayQueryObject qo) {
        return payService.query(qo);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            payService.deleteByPrimaryKey(id);
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("删除失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Pay pay) {
        AjaxResult result = null;
        try {
            payService.insert(pay);
            result = new AjaxResult(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("增加失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(Pay pay) {
        AjaxResult result = null;
        try {
            payService.updateByPrimaryKey(pay);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/downloadJxl")
    public void downloadJxl(HttpServletResponse response) throws Exception {
        String[] title = {"支出时间", "支出金额", "支出说明", "出纳人", "经手人", "支付方式", "支出类型", "支出小类", "支票号码", "共享费用", "共享类型", "学科"};
        WritableWorkbook workbook = Workbook.createWorkbook(new FileOutputStream("payout.xls"));
        WritableSheet sheet = workbook.createSheet("支出明细", 0);
        Label label;
        for (int i = 0; i < title.length; i++) {
            label = new Label(i, 0, title[i]);
            sheet.addCell(label);
        }
        List<Pay> list = payService.selectAll();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < list.size(); i++) {
            label = new Label(0, i + 1, df.format(list.get(i).getPayDate()));
            sheet.addCell(label);
            label = new Label(1, i + 1, list.get(i).getPayMoney().toString());
            sheet.addCell(label);
            label = new Label(2, i + 1, list.get(i).getInfo());
            sheet.addCell(label);
            if (list.get(i).getCashier() != null) {
                label = new Label(3, i + 1, list.get(i).getCashier().getUsername());
                sheet.addCell(label);
            }
            if (list.get(i).getBrokerage() != null) {
                label = new Label(4, i + 1, list.get(i).getBrokerage().getUsername());
                sheet.addCell(label);
            }
            if (list.get(i).getPayMode() != null) {
                label = new Label(5, i + 1, list.get(i).getPayMode().getName());
                sheet.addCell(label);
            }
            if (list.get(i).getPayType() != null) {
                label = new Label(6, i + 1, list.get(i).getPayType().getName());
                sheet.addCell(label);
            }
            if (list.get(i).getPaySmall() != null) {
                label = new Label(7, i + 1, list.get(i).getPaySmall().getName());
                sheet.addCell(label);
            }
            label = new Label(8, i + 1, list.get(i).getBillNumber());
            sheet.addCell(label);
            if (list.get(i).getShareCost() != null) {
                label = new Label(9, i + 1, list.get(i).getShareCost().toString());
                sheet.addCell(label);
            }
            if (list.get(i).getShareType() != null) {
                label = new Label(10, i + 1, list.get(i).getShareType().getName());
                sheet.addCell(label);
            }
            if (list.get(i).getSubject() != null) {
                label = new Label(11, i + 1, list.get(i).getSubject().getName());
                sheet.addCell(label);
            }
        }
        workbook.write();
        workbook.close();
        response.setHeader("Content-Disposition", "attachment;filename=pay.xls");
        IOUtils.copy(new FileInputStream("payout.xls"), response.getOutputStream());
    }

    @RequestMapping("/audit")
    @ResponseBody
    public AjaxResult audit(Long id, Integer status) {
        AjaxResult result = null;
        try {
            payService.audit(id, status);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }
}
