package com.student.crm.service;
import java.util.List;
import com.student.crm.domain.SystemMenu;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;

public interface ISystemMenuService {
	int deleteByPrimaryKey(Long id);
    int insert(SystemMenu record);
    SystemMenu selectByPrimaryKey(Long id);
    List<SystemMenu> selectAll();
    int updateByPrimaryKey(SystemMenu record);
	PageResult queryPage(QueryObject qo);
	List<SystemMenu> queryTree();
	List<SystemMenu> queryForRole();
	List<Long> queryMenuIdsListForRole(Long roleId);
	List<SystemMenu> indexMenu();
}
