package com.student.crm.service;
import com.student.crm.domain.Role;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;

import java.util.ArrayList;
import java.util.List;

public interface IRoleService {
	int deleteByPrimaryKey(Long id);
    int insert(Role record);
    Role selectByPrimaryKey(Long id);
    List<Role> selectAll();
    int updateByPrimaryKey(Role record);
	PageResult queryPage(QueryObject qo);
	List<Long> queryRoleIdListForEmployeeForm(Long employeeId);
	void addMenu(ArrayList<Long> ids, Long roleId);

    List<String> queryRolesByEmpId(Long id);
}
