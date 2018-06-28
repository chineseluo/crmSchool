package com.student.crm.mapper;

import com.student.crm.domain.DayMission;
import com.student.crm.query.DayMissionQueryObject;

import java.util.List;

public interface DayMissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DayMission record);

    DayMission selectByPrimaryKey(Long id);

    List<DayMission> selectAll();

    int updateByPrimaryKey(DayMission record);

    Long queryCount(DayMissionQueryObject qo);

    List<DayMission> list(DayMissionQueryObject qo);

    void updateStatusById(DayMission dayMission);

    void selfUpdate(DayMission dayMission);
}