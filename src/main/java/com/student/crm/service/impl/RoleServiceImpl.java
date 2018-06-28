package com.student.crm.service.impl;

import com.student.crm.domain.Permission;
import com.student.crm.domain.Role;
import com.student.crm.mapper.RoleMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;
import com.student.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper roleMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	public int insert(Role record) {
		int count = roleMapper.insert(record);
		//处理中间表的关系
		for(Permission p:record.getPermissions()){
			roleMapper.insertRelation(record.getId(),p.getId());
		}
		return count;
	}

	public Role selectByPrimaryKey(Long id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	public List<Role> selectAll() {
		return roleMapper.selectAll();
	}

	public int updateByPrimaryKey(Role record) {
		int count = roleMapper.updateByPrimaryKey(record);
		//删除外键关系
		roleMapper.deleteRelation(record.getId());
		//新增新的外键关系
		//处理中间表的关系
		for(Permission p:record.getPermissions()){
			roleMapper.insertRelation(record.getId(),p.getId());
		}
		return count;
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = roleMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Role> result = roleMapper.queryPageDataResult(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}

	@Override
	public List<Long> queryRoleIdListForEmployeeForm(Long employeeId) {
		return roleMapper.queryRoleIdListForEmployeeForm(employeeId);
	}

	@Override
	public void addMenu(ArrayList<Long> ids, Long roleId) {
		//把中间表的关系删除
		roleMapper.deleteMenuRelation(roleId);
		//循环ids集合,往中间表插入关系
		for(Long id:ids){
			roleMapper.insertMeneRelation(id,roleId);
		}
	}

    @Override
    public List<String> queryRolesByEmpId(Long id) {
        return roleMapper.queryRolesByEmpId(id);
    }
}
