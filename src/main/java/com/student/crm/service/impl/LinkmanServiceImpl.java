package com.student.crm.service.impl;

import com.student.crm.domain.Linkman;
import com.student.crm.mapper.LinkmanMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.LinkmanQueryObject;
import com.student.crm.service.ILinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LinkmanServiceImpl implements ILinkmanService {
    @Autowired
    private LinkmanMapper linkmanMapper;

    @Override
    public void insert(Linkman linkman) {
        linkmanMapper.insert(linkman);
    }

    @Override
    public void updateByPrimaryKey(Linkman linkman) {
        linkmanMapper.updateByPrimaryKey(linkman);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        linkmanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Linkman selectByPrimaryKey(Long id) {
        return linkmanMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(LinkmanQueryObject qo) {
        Long total = linkmanMapper.queryCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Linkman> rows = linkmanMapper.list(qo);
        return new PageResult(total, rows);
    }
}