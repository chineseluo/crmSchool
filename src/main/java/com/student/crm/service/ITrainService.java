package com.student.crm.service;

import com.student.crm.domain.Train;
import com.student.crm.page.PageResult;
import com.student.crm.query.TrainQueryObject;

public interface ITrainService {

    void deleteByPrimaryKey(Long id);

    void insert(Train record);

    Train selectByPrimaryKey(Long id);

    void updateByPrimaryKey(Train record);

    PageResult query(TrainQueryObject qo);
}
