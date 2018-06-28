package com.student.crm.mapper;

import com.student.crm.domain.Linkman;
import com.student.crm.query.LinkmanQueryObject;

import java.util.List;

public interface LinkmanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Linkman record);

    Linkman selectByPrimaryKey(Long id);

    List<Linkman> selectAll();

    int updateByPrimaryKey(Linkman record);

    Long queryCount(LinkmanQueryObject qo);

    List<Linkman> list(LinkmanQueryObject qo);
}