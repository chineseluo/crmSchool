package com.student.crm.web.controller;

import com.student.crm.domain.NetDisc;
import com.student.crm.domain.Type;
import com.student.crm.page.AjaxResult;
import com.student.crm.page.PageResult;
import com.student.crm.query.NetDiscQueryObject;
import com.student.crm.service.INetDiscService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("netDisc")
public class NetDiscController {
    @Autowired
    private INetDiscService netDiscService;

    @RequestMapping("")
    public String index() {
        return "netDisc";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(NetDiscQueryObject qo) {
        PageResult result = netDiscService.query(qo);
        result.setPid(qo.getParentId());
        return result;
    }
    @RequestMapping("/upload")
    @ResponseBody
    public AjaxResult upload(MultipartFile file, Long parentId, HttpServletRequest request) {
        AjaxResult result = null;
        try {
            netDiscService.upload(file, parentId, request);
            result = new AjaxResult(true, "上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("上传失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/download")
    @ResponseBody
    public AjaxResult download(Long id, HttpServletResponse response, HttpServletRequest request) {
        AjaxResult result = null;
        try {
            String name = netDiscService.selectByPrimaryKey(id).getText();
            String string = new String(name.getBytes("UTF-8"), "ISO8859-1");
            String suffix = FilenameUtils.getExtension(name);
            String path = request.getSession().getServletContext().getRealPath("/upload");
            InputStream in = new FileInputStream(path + "\\" + id + "." + suffix);
            response.setHeader("Content-Disposition", "attachment;filename=" + string);
            ServletOutputStream out = response.getOutputStream();
            IOUtils.copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
            result = new AjaxResult("下载失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/getParentId")
    @ResponseBody
    public Long getParentIdById(Long id) {
        NetDisc netDisc = netDiscService.selectByPrimaryKey(id);
        return netDisc.getParentId();
    }

    @RequestMapping("/menus")
    @ResponseBody
    public List<NetDisc> menus() {
        List<NetDisc> menus = new ArrayList<>();
        NetDisc nd = new NetDisc();
        nd.setText("我的网盘");
        nd.setIconCls("icon-my");
        nd.setChildren(netDiscService.menus());
        menus.add(nd);
        return menus;
    }

    @RequestMapping("/move")
    @ResponseBody
    public AjaxResult move(Long id, Long pId) {
        AjaxResult result = null;
        try {
            netDiscService.move(id, pId);
            result = new AjaxResult(true, "移动成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("移动失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/addFolder")
    @ResponseBody
    public AjaxResult addFolder(String name, Long pId) {
        AjaxResult result = null;
        try {
            netDiscService.addFolder(name, pId);
            result = new AjaxResult(true, "创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("创建失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/share")
    @ResponseBody
    public AjaxResult share(Long id, Long share) {
        AjaxResult result = null;
        try {
            netDiscService.updateShareById(id, share);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String name, Long id, Long typeId, HttpServletRequest request) {
        AjaxResult result = null;
        try {
            if (typeId != null) {
                //文件夹处理
                netDiscService.deleteAllById(id, request);
            } else {
                //单一文件处理
                netDiscService.deleteByPrimaryKey(name, id, request);
            }
            result = new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("删除失败" + e.getMessage());
        }
        return result;
    }

    @RequestMapping("/rename")
    @ResponseBody
    public AjaxResult share(Long id, String name) {
        AjaxResult result = null;
        try {
            netDiscService.updateNameById(id, name);
            result = new AjaxResult(true, "更改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更改失败,请联系管理员!");
        }
        return result;
    }

    @RequestMapping("/keyword")
    @ResponseBody
    public List<NetDisc> keyword(NetDiscQueryObject qo) {
        return netDiscService.queryNameByKeyword(qo);
    }
    @RequestMapping("/allType")
    @ResponseBody
    public List<Type> allType() {
        return netDiscService.selectAllType();
    }
    @RequestMapping("/shareDisc")
    public String shareDisc(){
        return "shareDisc";
    }
    @RequestMapping("/shareList")
    @ResponseBody
    public PageResult shareList(NetDiscQueryObject qo){
        return netDiscService.shareList(qo);
    }
    @RequestMapping("/moveSave")
    @ResponseBody
    public AjaxResult moveSave(Long id, Long pId, HttpServletRequest request) {
        AjaxResult result = null;
        try {
            netDiscService.moveSave(id,pId,request);
            result = new AjaxResult(true, "转存成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("转存失败:"+e.getMessage());
        }
        return result;
    }
    @RequestMapping("/shareKeyword")
    @ResponseBody
    public List<NetDisc> shareKeyword(NetDiscQueryObject qo) {
        return netDiscService.queryNameByShareKeyword(qo);
    }
    @RequestMapping("/shareLink")
    public String shareLink(Long uId,Long id,Model model,HttpServletRequest request){
        try {
            netDiscService.shareMove(uId,id,request);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error",e.getMessage());
            return "shareError";
        }
        return "shareSuccess";
    }
}
