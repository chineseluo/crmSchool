package com.student.crm.service.impl;

import com.student.crm.domain.Train;
import com.student.crm.mapper.TrainMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.TrainQueryObject;
import com.student.crm.service.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TrainServiceImpl implements ITrainService {
    @Autowired
    private TrainMapper trainMapper;

    @Override
    public void insert(Train train) {
        trainMapper.insert(train);
    }

    @Override
    public void updateByPrimaryKey(Train train) {
        trainMapper.updateByPrimaryKey(train);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        trainMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Train selectByPrimaryKey(Long id) {
        return trainMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(TrainQueryObject qo) {
        Long total = trainMapper.queryCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Train> rows = trainMapper.list(qo);
        return new PageResult(total, rows);
    }
}