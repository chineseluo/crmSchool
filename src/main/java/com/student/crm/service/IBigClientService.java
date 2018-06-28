package com.student.crm.service;

import com.student.crm.domain.BigClient;
import com.student.crm.page.PageResult;
import com.student.crm.query.BigClientQueryObject;

import java.util.List;

public interface IBigClientService {

    void deleteByPrimaryKey(Long id);

    void insert(BigClient record);

    BigClient selectByPrimaryKey(Long id);
List<BigClient> selectAll();
    void updateByPrimaryKey(BigClient record);

    PageResult query(BigClientQueryObject qo);

    void updateFollowById(Long id,Long fId);
}
