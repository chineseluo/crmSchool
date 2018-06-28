package com.student.crm.mapper;

import com.student.crm.domain.Role;
import com.student.crm.query.QueryObject;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Role record);
    Role selectByPrimaryKey(Long id);
    List<Role> selectAll();
    int updateByPrimaryKey(Role record);
	Long queryPageCount(QueryObject qo);
	List<Role> queryPageDataResult(QueryObject qo);
	void insertRelation(@Param("roleId")Long roleId,@Param("permissionId") Long permissionId);
	void deleteRelation(Long roleId);
	List<Long> queryRoleIdListForEmployeeForm(Long employeeId);
	void insertMeneRelation(@Param("menuId")Long menuId, @Param("roleId")Long roleId);
	void deleteMenuRelation(Long roleId);

    List<String> queryRolesByEmpId(Long id);
}