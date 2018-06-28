package com.student.crm.service;
import com.student.crm.domain.Permission;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;

import java.util.List;

public interface IPermissionService {
	int deleteByPrimaryKey(Long id);
    int insert(Permission record);
    Permission selectByPrimaryKey(Long id);
    List<Permission> selectAll();
    int updateByPrimaryKey(Permission record);
	PageResult queryPagePage(QueryObject qo);
	void load();
	PageResult queryPageForRoleForm();
	PageResult selectPageForRoleFormByRoleId(Long roleId);

    List<String> queryPermissionsByEmpId(Long id);
}
