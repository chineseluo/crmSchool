package com.student.crm.mapper;

import com.student.crm.domain.Permission;
import com.student.crm.query.QueryObject;
import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Permission record);
    Permission selectByPrimaryKey(Long id);
    List<Permission> selectAll();
    int updateByPrimaryKey(Permission record);
	Long queryPageCount(QueryObject qo);
	List<Permission> queryPageDataResult(QueryObject qo);
	List<Permission> selectPageForRoleFormByRoleId(Long roleId);

    List<String> queryPermissionsByEmpId(Long id);
}