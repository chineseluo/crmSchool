package com.student.crm.service.impl;

import com.student.crm.domain.Employee;
import com.student.crm.domain.NetDisc;
import com.student.crm.domain.Type;
import com.student.crm.mapper.NetDiscMapper;
import com.student.crm.mapper.TypeMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.NetDiscQueryObject;
import com.student.crm.service.INetDiscService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class NetDiscServiceImpl implements INetDiscService {
    @Autowired
    private NetDiscMapper netDiscMapper;
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public void insert(NetDisc netDisc) {
        netDiscMapper.insert(netDisc);
    }

    @Override
    public void updateByPrimaryKey(NetDisc netDisc) {
        netDiscMapper.updateByPrimaryKey(netDisc);
    }

    @Override
    public void deleteByPrimaryKey(String name, Long id, HttpServletRequest request) {
        netDiscMapper.deleteByPrimaryKey(id);
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String file = path + "\\" + id + "." + FilenameUtils.getExtension(name);
        File f = new File(file);
        if (f.exists()) {
            f.delete();
        } else {
            throw new RuntimeException("文件不存在");
        }
    }

    @Override
    public NetDisc selectByPrimaryKey(Long id) {
        return netDiscMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(NetDiscQueryObject qo) {
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        if (!user.isAdmin()) {
            qo.setUserId(user.getId());
        }
        Long total = netDiscMapper.queryCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<NetDisc> rows = netDiscMapper.list(qo);
        return new PageResult(total, rows);
    }

    @Override
    public void upload(MultipartFile file, Long pid, HttpServletRequest request) throws IOException {
        NetDisc nd = new NetDisc();
        nd.setType(new Type());
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        nd.setText(file.getOriginalFilename());
        nd.setParentId(pid);
        nd.setShare(NetDisc.SHARE_NO);
        nd.setUploadTime(new Date());
        nd.setSize(file.getSize());
        nd.setUser(new Employee());
        nd.setUser(user);
        String suffix = FilenameUtils.getExtension(file.getOriginalFilename().toLowerCase());
        List<String> pic = Arrays.asList("jpg", "png", "jpeg", "bmp", "gif");
        List<String> mis = Arrays.asList("mp3", "wma", "ogg", "wmv");
        List<String> video = Arrays.asList("avi", "mp4", "rmvb", "rm");
        if (pic.contains(suffix)) {
            nd.getType().setId(2L);
        } else if ("xls".equals(suffix)) {
            nd.getType().setId(3L);
        } else if ("doc".equals(suffix)) {
            nd.getType().setId(4L);
        } else if ("txt".equals(suffix)) {
            nd.getType().setId(5L);
        } else if (mis.contains(suffix)) {
            nd.getType().setId(6L);
        } else if (video.contains(suffix)) {
            nd.getType().setId(7L);
        } else if ("pdf".equals(suffix)) {
            nd.getType().setId(8L);
        } else {
            nd.getType().setId(9L);
        }
        netDiscMapper.insert(nd);
        String path = request.getSession().getServletContext().getRealPath("/upload");
        OutputStream out = new FileOutputStream(path + "\\" + nd.getId() + "." + suffix);
        IOUtils.copy(file.getInputStream(), out);
        file.getInputStream().close();
        out.close();
    }

    @Override
    public List<NetDisc> menus() {
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        NetDiscQueryObject qo = new NetDiscQueryObject();
        if (!user.isAdmin()) {
            qo.setUserId(user.getId());
        }
        return netDiscMapper.menus(qo);
    }

    @Override
    public void move(Long id, Long pId) {
        netDiscMapper.move(id, pId);
    }

    @Override
    public void addFolder(String name, Long pId) {
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        NetDisc nd = new NetDisc();
        nd.setUser(user);
        if (pId != null) {
            Long id = netDiscMapper.getUserIdByParentId(pId);
            nd.getUser().setId(id);
        }
        nd.setText(name);
        nd.setParentId(pId);
        nd.setType(new Type());
        nd.getType().setId(1L);
        nd.setUploadTime(new Date());
        nd.setShare(NetDisc.SHARE_NO);
        netDiscMapper.insert(nd);
    }

    @Override
    public void updateShareById(Long id, Long share) {
        Date time = null;
        if (share == 1) {
            time = new Date();
        }
        netDiscMapper.share(id, share, time);
    }

    @Override
    public void deleteAllById(Long id, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File f = null;
        //先获取所有文件夹
        List<NetDisc> allFolder = netDiscMapper.children(id);
        //递归删除
        if (allFolder.size() > 0) {
            handlerFile(allFolder, path);
        }
        netDiscMapper.deleteByPrimaryKey(id);
        List<NetDisc> allFile = netDiscMapper.allFile(id);
        if (allFile.size() > 0) {
            for (NetDisc disc : allFile) {
                netDiscMapper.deleteByPrimaryKey(disc.getId());
                String file = path + "\\" + disc.getId() + "." + FilenameUtils.getExtension(disc.getText());
                f = new File(file);
                if (f.exists()) {
                    f.delete();
                } else {
                    throw new RuntimeException("文件不存在");
                }
            }
        }
    }

    @Override
    public void updateNameById(Long id, String name) {
        NetDisc netDisc = netDiscMapper.selectByPrimaryKey(id);
        if (netDisc.getText().indexOf(".")>=0) {
            name = name + "." + FilenameUtils.getExtension(netDisc.getText());
        }
        netDiscMapper.updateNameById(id, name);
    }

    @Override
    public List<NetDisc> queryNameByKeyword(NetDiscQueryObject qo) {
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        if (!user.isAdmin()) {
            qo.setUserId(user.getId());
        }
        return netDiscMapper.queryNameByKeyword(qo);
    }

    @Override
    public List<Type> selectAllType() {
        return typeMapper.selectAll();
    }

    //共享页面数据
    @Override
    public PageResult shareList(NetDiscQueryObject qo) {
        Long total = netDiscMapper.queryShareCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<NetDisc> rows = netDiscMapper.shareList(qo);
        return new PageResult(total, rows);
    }

    //转存操作
    @Override
    public void moveSave(Long id, Long pId, HttpServletRequest request) throws IOException {
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        NetDisc netDisc = netDiscMapper.selectByPrimaryKey(id);
        if (user.getId().equals(netDisc.getUser().getId())) {
            throw new RuntimeException("已存在");
        }
        NetDisc n = new NetDisc();
        n.setShare(NetDisc.SHARE_NO);
        n.setUser(user);
        n.setUploadTime(new Date());
        n.setType(netDisc.getType());
        n.setParentId(pId);
        n.setText(netDisc.getText());
        n.setSize(netDisc.getSize());
        netDiscMapper.insert(n);
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String file = path + "\\" + netDisc.getId() + "." + FilenameUtils.getExtension(netDisc.getText());
        String saveFile = path + "\\" + n.getId() + "." + FilenameUtils.getExtension(netDisc.getText());
        IOUtils.copy(new FileInputStream(file), new FileOutputStream(saveFile));
    }

    @Override
    public List<NetDisc> queryNameByShareKeyword(NetDiscQueryObject qo) {
        return netDiscMapper.queryNameByShareKeyword(qo);
    }

    @Override
    public void shareMove(Long uId, Long id, HttpServletRequest request) throws IOException {
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        if (user.getId().equals(uId)) {
            throw new RuntimeException("已存在该文件");
        }
        NetDisc netDisc = netDiscMapper.selectByPrimaryKey(id);
        NetDisc n = new NetDisc();
        n.setShare(NetDisc.SHARE_NO);
        n.setUser(user);
        n.setUploadTime(new Date());
        n.setType(netDisc.getType());
        n.setText(netDisc.getText());
        n.setSize(netDisc.getSize());
        netDiscMapper.insert(n);
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String file = path + "\\" + netDisc.getId() + "." + FilenameUtils.getExtension(netDisc.getText());
        String saveFile = path + "\\" + n.getId() + "." + FilenameUtils.getExtension(netDisc.getText());
        IOUtils.copy(new FileInputStream(file), new FileOutputStream(saveFile));
    }

    //递归
    private void handlerFile(List<NetDisc> allFolder, String path) {
        File f = null;
        for (NetDisc netDisc : allFolder) {
            if (netDisc.getChildren().size() > 0) {
                handlerFile(netDisc.getChildren(), path);
            } else {
                netDiscMapper.deleteByPrimaryKey(netDisc.getId());
                List<NetDisc> allFile = netDiscMapper.allFile(netDisc.getId());
                if (allFile.size() > 0) {
                    for (NetDisc disc : allFile) {
                        netDiscMapper.deleteByPrimaryKey(disc.getId());
                        String file = path + "\\" + disc.getId() + "." + FilenameUtils.getExtension(disc.getText());
                        f = new File(file);
                        if (f.exists()) {
                            f.delete();
                        } else {
                            throw new RuntimeException("文件不存在");
                        }
                    }
                }
            }
        }
    }
}