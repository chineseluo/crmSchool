package com.student.crm.mapper;

import com.student.crm.domain.SystemMenu;
import com.student.crm.query.QueryObject;
import java.util.List;

public interface SystemMenuMapper {
    int deleteByPrimaryKey(Long id);
    int insert(SystemMenu record);
    SystemMenu selectByPrimaryKey(Long id);
    List<SystemMenu> selectAll();
    int updateByPrimaryKey(SystemMenu record);
	Long queryPageCount(QueryObject qo);
	List<SystemMenu> queryPageDataResult(QueryObject qo);
	List<SystemMenu> queryTree();
	List<Long> systemMenuMapper(Long roleId);
	List<Long> queryMenuIdListByEmployeeId(Long id);

    List<Long> queryMenuIdByEmpId(Long id);
}