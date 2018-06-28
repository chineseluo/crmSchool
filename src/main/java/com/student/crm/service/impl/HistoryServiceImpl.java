package com.student.crm.service.impl;

import com.student.crm.domain.History;
import com.student.crm.mapper.HistoryMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.HistoryQueryObject;
import com.student.crm.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HistoryServiceImpl implements IHistoryService {
    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public void insert(History history) {
        historyMapper.insert(history);
    }

    @Override
    public void updateByPrimaryKey(History history) {
        historyMapper.updateByPrimaryKey(history);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        historyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public History selectByPrimaryKey(Long id) {
        return historyMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(HistoryQueryObject qo) {
        Long total = historyMapper.queryCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<History> rows = historyMapper.list(qo);
        return new PageResult(total, rows);
    }
}