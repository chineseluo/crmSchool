package com.student.crm.service;

import com.student.crm.domain.NetDisc;
import com.student.crm.domain.Type;
import com.student.crm.page.PageResult;
import com.student.crm.query.NetDiscQueryObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface INetDiscService {

    void deleteByPrimaryKey(String name, Long id, HttpServletRequest request);

    void insert(NetDisc record);

    NetDisc selectByPrimaryKey(Long id);

    void updateByPrimaryKey(NetDisc record);

    PageResult query(NetDiscQueryObject qo);

    void upload(MultipartFile file, Long pid, HttpServletRequest request) throws IOException;

    List<NetDisc> menus();

    void move(Long id, Long pId);

    void addFolder(String name, Long pId);

    void updateShareById(Long id, Long share);

    void deleteAllById(Long id, HttpServletRequest request);

    void updateNameById(Long id, String name);

    List<NetDisc> queryNameByKeyword(NetDiscQueryObject qo);

    List<Type> selectAllType();

    PageResult shareList(NetDiscQueryObject qo);

    /**
     * 转存操作
     * @param id 文件id
     * @param pId 目录id
     * @param request
     */
    void moveSave(Long id, Long pId, HttpServletRequest request) throws IOException;

    List<NetDisc> queryNameByShareKeyword(NetDiscQueryObject qo);

    void shareMove(Long uId, Long id,HttpServletRequest request) throws IOException;
}
