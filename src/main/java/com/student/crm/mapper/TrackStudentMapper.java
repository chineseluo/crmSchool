package com.student.crm.mapper;

import com.student.crm.domain.TrackStudent;
import com.student.crm.query.TrackStudentQueryObject;

import java.util.List;

public interface TrackStudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TrackStudent record);

    TrackStudent selectByPrimaryKey(Long id);

    List<TrackStudent> selectAll();

    int updateByPrimaryKey(TrackStudent record);

    Long queryForCount(TrackStudentQueryObject qo);

    List<TrackStudent> queryDataList(TrackStudentQueryObject qo);
}