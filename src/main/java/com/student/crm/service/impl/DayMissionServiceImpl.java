package com.student.crm.service.impl;

import com.student.crm.domain.DayMission;
import com.student.crm.domain.Employee;
import com.student.crm.mapper.DayMissionMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.DayMissionQueryObject;
import com.student.crm.service.IDayMissionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DayMissionServiceImpl implements IDayMissionService {
    @Autowired
    private DayMissionMapper dayMissionMapper;

    @Override
    public void insert(DayMission dayMission) {
        Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
        dayMission.setManager(user);
        dayMissionMapper.insert(dayMission);
    }

    @Override
    public void updateByPrimaryKey(DayMission dayMission) {
        dayMissionMapper.updateByPrimaryKey(dayMission);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        dayMissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DayMission selectByPrimaryKey(Long id) {
        return dayMissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(DayMissionQueryObject qo) {
        Long total = dayMissionMapper.queryCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<DayMission> rows = dayMissionMapper.list(qo);
    /*    for (DayMission dayMission : rows) {
            if(dayMission.getMissionInfo().length()>10){
                dayMission.setMissionInfo(dayMission.getMissionInfo().substring(0,10)+".....");
            }
            if(dayMission.getHandlerInfo().length()>10){
                dayMission.setHandlerInfo(dayMission.getHandlerInfo().substring(0,10)+".....");
            }
        }*/
        return new PageResult(total, rows);
    }

    @Override
    public void updateStatusById(DayMission dayMission) {
        dayMissionMapper.updateStatusById(dayMission);
    }

    @Override
    public void selfUpdate(DayMission dayMission) {
        dayMissionMapper.selfUpdate(dayMission);
    }

    @Override
    public List<DayMission> queryList(DayMissionQueryObject qo) {
        return dayMissionMapper.list(qo);
    }
}