package com.student.crm.service.impl;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.student.crm.mapper.PermissionMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;
import com.student.crm.service.IPermissionService;
import com.student.crm.util.PermissionName;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.crm.domain.Permission;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Service
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private RequestMappingHandlerMapping rmhm;

	public int deleteByPrimaryKey(Long id) {
		return permissionMapper.deleteByPrimaryKey(id);
	}

	public int insert(Permission record) {
		return permissionMapper.insert(record);
	}

	public Permission selectByPrimaryKey(Long id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	public List<Permission> selectAll() {
		return permissionMapper.selectAll();
	}

	public int updateByPrimaryKey(Permission record) {
		return permissionMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPagePage(QueryObject qo) {
		Long count = permissionMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Permission> result = permissionMapper.queryPageDataResult(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}

	@Override
	public void load() {
		//获取目前所有的权限集合放入到Set集合中.
		List<Permission> permissions = permissionMapper.selectAll();
		Set<String> permissionSet = new HashSet<String>();
		for(Permission p:permissions){
			permissionSet.add(p.getResource());
		}
		//获取到所有控制器
		Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
		Collection<HandlerMethod> methodCollection = handlerMethods.values();
		Permission p = null;
		Method[] methods = null;
		RequiresPermissions rp = null;
		PermissionName pn = null;
		String expression = null;
		for(HandlerMethod method:methodCollection){
			//获取控制器方法
			//获取方法上的注解
			rp = method.getMethodAnnotation(RequiresPermissions.class);
			if(rp==null){
				continue;
			}
			expression = StringUtils.join(rp.value(), ",");
			pn = method.getMethodAnnotation(PermissionName.class);
			//判断是否已经存在该权限了.
			if(!permissionSet.contains(expression)){
				p = new Permission();
				p.setResource(expression);
				p.setName(pn.value());
				permissionMapper.insert(p);
			}
		}
	}
	@Override
	public PageResult queryPageForRoleForm() {
		List<Permission> result = permissionMapper.selectAll();
		return new PageResult(Long.MAX_VALUE, result);
	}
	@Override
	public PageResult selectPageForRoleFormByRoleId(Long roleId) {
		List<Permission> result = permissionMapper.selectPageForRoleFormByRoleId(roleId);
		return new PageResult(Long.MAX_VALUE, result);
	}

    @Override
    public List<String> queryPermissionsByEmpId(Long id) {
        return permissionMapper.queryPermissionsByEmpId(id);
    }
}
