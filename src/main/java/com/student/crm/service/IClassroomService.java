package com.student.crm.service;

import com.student.crm.domain.Classroom;
import com.student.crm.page.PageResult;
import com.student.crm.query.ClassroomQueryObject;

import java.util.List;

public interface IClassroomService {

    void deleteByPrimaryKey(Long id);

    void insert(Classroom record);

    Classroom selectByPrimaryKey(Long id);

    void updateByPrimaryKey(Classroom record);

    PageResult query(ClassroomQueryObject qo);

    List<Classroom> selectAll();
}
