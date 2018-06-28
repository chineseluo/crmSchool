package com.student.crm.web.controller;


import com.student.crm.domain.SaleChart;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.SaleChartQueryObject;
import com.student.crm.service.ISaleChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/saleChart")
public class SaleChartController {
    @Autowired
    private ISaleChartService saleChartService;
    @RequestMapping("")
    public String index(){
        return "saleChart";
    }
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(SaleChartQueryObject qo){
        PageResult result = saleChartService.queryPageResult(qo);
        return result;
    }
    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(SaleChart saleChart) {
        AjaxResult result = null;
        try {
            saleChartService.insert(saleChart);
            result = new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false,"保存失败");
        }
            return result;
    }
    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(SaleChart saleChart){
        AjaxResult result = null;
        try {
            saleChartService.updateByPrimaryKey(saleChart);
            result = new AjaxResult(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false,"编辑失败");
        }
        return result;
    }
}
