package com.student.crm.service;

import com.student.crm.domain.History;
import com.student.crm.page.PageResult;
import com.student.crm.query.HistoryQueryObject;

public interface IHistoryService {

    void deleteByPrimaryKey(Long id);

    void insert(History record);

    History selectByPrimaryKey(Long id);

    void updateByPrimaryKey(History record);

    PageResult query(HistoryQueryObject qo);
}
