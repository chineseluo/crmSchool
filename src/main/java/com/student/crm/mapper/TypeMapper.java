package com.student.crm.mapper;

import com.student.crm.domain.Type;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Type record);

    Type selectByPrimaryKey(Long id);

    List<Type> selectAll();

    int updateByPrimaryKey(Type record);
}