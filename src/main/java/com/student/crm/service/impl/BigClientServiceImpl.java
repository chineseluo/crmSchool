package com.student.crm.service.impl;

import com.student.crm.domain.BigClient;
import com.student.crm.mapper.BigClientMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.BigClientQueryObject;
import com.student.crm.service.IBigClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BigClientServiceImpl implements IBigClientService {
    @Autowired
    private BigClientMapper bigClientMapper;

    @Override
    public void insert(BigClient bigClient) {
        bigClientMapper.insert(bigClient);
    }

    @Override
    public void updateByPrimaryKey(BigClient bigClient) {
        bigClientMapper.updateByPrimaryKey(bigClient);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        bigClientMapper.deleteByPrimaryKey(id);
    }

    @Override
    public BigClient selectByPrimaryKey(Long id) {
        return bigClientMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BigClient> selectAll() {
        return bigClientMapper.selectAll();
    }

    @Override
    public PageResult query(BigClientQueryObject qo) {
        Long total = bigClientMapper.queryCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<BigClient> rows = bigClientMapper.list(qo);
        return new PageResult(total, rows);
    }

    @Override
    public void updateFollowById(Long id,Long fId) {
        bigClientMapper.updateFollowById(id,fId);
    }
}