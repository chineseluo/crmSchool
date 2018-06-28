package com.student.crm.service;

import com.student.crm.domain.Linkman;
import com.student.crm.page.PageResult;
import com.student.crm.query.LinkmanQueryObject;

public interface ILinkmanService {

    void deleteByPrimaryKey(Long id);

    void insert(Linkman record);

    Linkman selectByPrimaryKey(Long id);

    void updateByPrimaryKey(Linkman record);

    PageResult query(LinkmanQueryObject qo);
}
