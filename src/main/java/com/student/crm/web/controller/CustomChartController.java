package com.student.crm.web.controller;

import com.student.crm.domain.Chart;
import com.student.crm.query.CustomChartQueryObject;
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
@RequestMapping("/customChart")
public class CustomChartController {
    @Autowired
    private IChartService contractManageService;

    @RequestMapping("")
    public String index() {
        return "customChart";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Chart> list(CustomChartQueryObject qo) {
        List<Chart> charts = contractManageService.customChartQuery(qo);
        Iterator<Chart> iterator = charts.iterator();
        while (iterator.hasNext()){
            Chart chart = iterator.next();
            if(chart==null){
                iterator.remove();
            }else {
                String groupType = chart.getGroupType();
                BigDecimal totalNumber = chart.getTotalNumber();
                if (groupType==null ||totalNumber==null){
                    iterator.remove();
                }
            }

        }
        return charts;
    }

    @ResponseBody
    @RequestMapping("chartBar")
    public ModelAndView chartList(CustomChartQueryObject qo) {
        ModelAndView mv = new ModelAndView();
        List<Chart> saleCharts = contractManageService.customChartQuery(qo);

        Iterator<Chart> iterator = saleCharts.iterator();
        ArrayList<String> xValues = new ArrayList();
        ArrayList<BigDecimal> yValues = new ArrayList();
        while (iterator.hasNext()) {
            Chart chart = iterator.next();//集合中的chart对象
            if (chart == null) {
                iterator.remove();
            }else {

                xValues.add(chart.getGroupType());
                yValues.add(chart.getTotalNumber());
            }

        }

        mv.addObject("xValues", JSONUtils.toJSONString(xValues));
        mv.addObject("yValues", JSONUtils.toJSONString(yValues));
        mv.addObject("typeName", CustomChartQueryObject.typeMap.get(qo.getGroupbyCon()));
        mv.setViewName("/chargeHighChart");
        return mv;
    }

    @ResponseBody
    @RequestMapping("chartPie")
    public ModelAndView chartListPie(CustomChartQueryObject qo) {
        ModelAndView mv = new ModelAndView();
        List<Chart> saleCharts = contractManageService.customChartQuery(qo);
        List<Map<String, Object>> groupList = new ArrayList<>();
        Iterator<Chart> iterator = saleCharts.iterator();

        ArrayList<String> xValues = new ArrayList();
        while (iterator.hasNext()) {
            Chart chart = iterator.next();//集合中的chart对象
            if (chart == null) {
                iterator.remove();
            }else {
                String groupType = chart.getGroupType();
                BigDecimal totalNumber = chart.getTotalNumber();
                if (groupType==null ||totalNumber==null){
                    iterator.remove();
                }else {
                    xValues.add(chart.getGroupType());
                    Map<String, Object> map=new HashMap<>();
                    map.put("name",chart.getGroupType());
                    map.put("value",chart.getTotalNumber());
                    groupList.add(map);
                }

            }


        }

        mv.addObject("xValues", JSONUtils.toJSONString(xValues));
        mv.addObject("groupList", JSONUtils.toJSONString(groupList));
        mv.addObject("typeName", CustomChartQueryObject.typeMap.get(qo.getGroupbyCon()));
        mv.setViewName("/chargeHighChartPie");
        return mv;
    }

}
