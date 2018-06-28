package com.student.crm.web.controller;

import com.student.crm.page.PageResult;
import com.student.crm.query.HistoryQueryObject;
import com.student.crm.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/10/14.
 */
@Controller
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private IHistoryService historyServiceImpl;


    @RequestMapping("")
    public String index() {
        return "history";
    }
    @RequestMapping("list")
    @ResponseBody
    public PageResult list(HistoryQueryObject qo) {
        PageResult result = historyServiceImpl.query(qo);

        return result;
    }
}
