package com.student.crm.web.controller;

import com.student.crm.domain.Chart;
import com.student.crm.query.ChargeChartQueryObject;
import com.student.crm.service.IChartService;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("chargeChart")
public class ChargeChartController {
    @Autowired
    private IChartService chargeChartService;

    @RequestMapping("")
    public String index() {
        return "chargeChart";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Chart> list(ChargeChartQueryObject qo) {
        List<Chart> charts = chargeChartService.chargeChartQuery(qo);
        Iterator<Chart> iterator = charts.iterator();
        while (iterator.hasNext()){
            Chart chart = iterator.next();
            if(chart==null){
                iterator.remove();
            }else {
                String groupType = chart.getGroupType();
                BigDecimal totalAmount = chart.getTotalAmount();
                if (groupType==null ||totalAmount==null){
                    iterator.remove();
                }
            }

        }

        return charts;
    }

    @ResponseBody
    @RequestMapping("chartBar")
    public ModelAndView chartList(ChargeChartQueryObject qo) {
        ModelAndView mv = new ModelAndView();
        List<Chart> saleCharts = chargeChartService.chargeChartQuery(qo);
        Iterator<Chart> iterator = saleCharts.iterator();
        ArrayList<String> xValues = new ArrayList();
        ArrayList<BigDecimal> yValues = new ArrayList();
        while (iterator.hasNext()) {
            Chart chart = iterator.next();//集合中的chart对象
            if (chart == null) {
                iterator.remove();
            }else {

                xValues.add(chart.getGroupType());
                yValues.add(chart.getTotalAmount());
            }

        }

        mv.addObject("xValues", JSONUtils.toJSONString(xValues));
        mv.addObject("yValues", JSONUtils.toJSONString(yValues));
        mv.addObject("typeName", ChargeChartQueryObject.typeMap.get(qo.getGroupbyCon()));
        mv.setViewName("/chargeHighChart");
        return mv;
    }

    @ResponseBody
    @RequestMapping("chartPie")
    public ModelAndView chartListPie(ChargeChartQueryObject qo) {
        ModelAndView mv = new ModelAndView();
        List<Chart> saleCharts = chargeChartService.chargeChartQuery(qo);
        Iterator<Chart> iterator = saleCharts.iterator();
        List<Map<String, Object>> groupList = new ArrayList<>();

        ArrayList<String> xValues = new ArrayList();
        while (iterator.hasNext()) {
            Chart chart = iterator.next();//集合中的chart对象
            if (chart == null) {
                iterator.remove();
            }else {

                xValues.add(chart.getGroupType());
                Map<String, Object> map=new HashMap<>();
                map.put("name",chart.getGroupType());
                map.put("value",chart.getTotalAmount());
                groupList.add(map);
            }

        }


        mv.addObject("xValues", JSONUtils.toJSONString(xValues));
        mv.addObject("groupList", JSONUtils.toJSONString(groupList));
        mv.addObject("typeName", ChargeChartQueryObject.typeMap.get(qo.getGroupbyCon()));
        mv.setViewName("/chargeHighChartPie");
        return mv;
    }

}
