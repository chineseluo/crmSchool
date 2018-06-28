package com.student.crm.service;

import com.student.crm.domain.DayMission;
import com.student.crm.page.PageResult;
import com.student.crm.query.DayMissionQueryObject;

import java.util.List;

public interface IDayMissionService {

    void deleteByPrimaryKey(Long id);

    void insert(DayMission record);

    DayMission selectByPrimaryKey(Long id);

    void updateByPrimaryKey(DayMission record);

    PageResult query(DayMissionQueryObject qo);

    void updateStatusById(DayMission dayMission);

    void selfUpdate(DayMission dayMission);

    List<DayMission> queryList(DayMissionQueryObject qo);
}
