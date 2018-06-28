package com.student.crm.mapper;

import com.student.crm.domain.Classroom;
import com.student.crm.query.ClassroomQueryObject;

import java.util.List;

public interface ClassroomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Classroom record);

    Classroom selectByPrimaryKey(Long id);

    List<Classroom> selectAll();

    int updateByPrimaryKey(Classroom record);

    Long queryCount(ClassroomQueryObject qo);

    List<Classroom> list(ClassroomQueryObject qo);
}