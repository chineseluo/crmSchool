package com.student.crm.web.controller;

import com.student.crm.domain.BigClient;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.BigClientQueryObject;
import com.student.crm.service.IBigClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bigClient")
public class BigClientController {
    @Autowired
    private IBigClientService bigClientService;

    @RequestMapping("")
    public String index() {
        return "bigClient";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(BigClientQueryObject qo) {
        return bigClientService.query(qo);
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    public List selectAll( ) {
        BigClientQueryObject qo = new BigClientQueryObject();
        qo.setRows(100);
        return bigClientService.query(qo).getRows();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            bigClientService.deleteByPrimaryKey(id);
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("删除失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(BigClient bigClient) {
        AjaxResult result = null;
        try {
            bigClientService.insert(bigClient);
            result = new AjaxResult(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("增加失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(BigClient bigClient) {
        AjaxResult result = null;
        try {
            bigClientService.updateByPrimaryKey(bigClient);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }
    @RequestMapping("/payList")
    @ResponseBody
    public List<BigClient> payList(){
        return bigClientService.selectAll();
    }
    @RequestMapping("/updateFollowById")
    @ResponseBody
    public AjaxResult share(Long id,Long fId) {
        AjaxResult result = null;
        try {
            bigClientService.updateFollowById(id,fId);
            result = new AjaxResult(true, "移交成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("移交失败,请联系管理员!");
        }
        return result;
    }
}
