package com.student.crm.service.impl;

import com.student.crm.domain.Classroom;
import com.student.crm.mapper.ClassroomMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.ClassroomQueryObject;
import com.student.crm.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ClassroomServiceImpl implements IClassroomService {
    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    public void insert(Classroom classroom) {
        classroomMapper.insert(classroom);
    }

    @Override
    public void updateByPrimaryKey(Classroom classroom) {
        classroomMapper.updateByPrimaryKey(classroom);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        classroomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Classroom selectByPrimaryKey(Long id) {
        return classroomMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(ClassroomQueryObject qo) {
        Long total = classroomMapper.queryCount(qo);
        if (total <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Classroom> rows = classroomMapper.list(qo);
        return new PageResult(total, rows);
    }

    @Override
    public List<Classroom> selectAll() {
        return classroomMapper.selectAll();
    }
}