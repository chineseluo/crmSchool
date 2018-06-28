package com.student.crm.mapper;

import com.student.crm.domain.Train;
import com.student.crm.query.TrainQueryObject;

import java.util.List;

public interface TrainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Train record);

    Train selectByPrimaryKey(Long id);

    List<Train> selectAll();

    int updateByPrimaryKey(Train record);

    Long queryCount(TrainQueryObject qo);

    List<Train> list(TrainQueryObject qo);
}