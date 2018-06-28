package com.student.crm.service;

import com.student.crm.domain.Employee;
import com.student.crm.page.PageResult;
import com.student.crm.query.EmployeeQueryObject;

import java.util.List;

public interface IEmployeeService {
	int deleteByPrimaryKey(Long id);
    int insert(Employee record);
    Employee selectByPrimaryKey(Long id);
    List<Employee> selectAll();
    int updateByPrimaryKey(Employee record);
	PageResult queryPage(EmployeeQueryObject qo);
	void quit(Long id);

    Employee queryByUsername(String username);

    List<Employee> queryEmpByRoleSn(String sn);
}
