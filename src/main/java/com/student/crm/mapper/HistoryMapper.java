package com.student.crm.mapper;

import com.student.crm.domain.History;
import com.student.crm.query.HistoryQueryObject;

import java.util.List;

public interface HistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(History record);

    History selectByPrimaryKey(Long id);

    List<History> selectAll();

    int updateByPrimaryKey(History record);

    Long queryCount(HistoryQueryObject qo);

    List<History> list(HistoryQueryObject qo);
}