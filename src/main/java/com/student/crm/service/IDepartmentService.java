package com.student.crm.service;

import com.student.crm.domain.Department;
import com.student.crm.page.PageResult;
import com.student.crm.query.DepartmentQueryObject;

import java.util.List;

public interface IDepartmentService {
    int deleteByPrimaryKey(Long id);
    int insert(Department record);
    Department selectByPrimaryKey(Long id);
    List<Department> selectAll();
    int updateByPrimaryKey(Department record);

    PageResult queryPage(DepartmentQueryObject qo);
}
