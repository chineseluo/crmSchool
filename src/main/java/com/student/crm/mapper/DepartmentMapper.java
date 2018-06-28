package com.student.crm.mapper;

import com.student.crm.domain.Department;
import com.student.crm.query.DepartmentQueryObject;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Department record);
    Department selectByPrimaryKey(Long id);
    List<Department> selectAll();
    int updateByPrimaryKey(Department record);
    Long queryByCount(DepartmentQueryObject qo);
    List<Department> queryPage(DepartmentQueryObject qo);
}