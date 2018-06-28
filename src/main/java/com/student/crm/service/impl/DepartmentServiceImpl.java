package com.student.crm.service.impl;

import com.student.crm.domain.Department;
import com.student.crm.mapper.DepartmentMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.DepartmentQueryObject;
import com.student.crm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private DepartmentMapper DepartmentMapper;
	public int deleteByPrimaryKey(Long id) {
		return DepartmentMapper.deleteByPrimaryKey(id);
	}

	public int insert(Department record) {
		int count = DepartmentMapper.insert(record);
		return count;
	}

	public Department selectByPrimaryKey(Long id) {
		return DepartmentMapper.selectByPrimaryKey(id);
	}

	public List<Department> selectAll() {
		return DepartmentMapper.selectAll();
	}

	public int updateByPrimaryKey(Department record) {
		return DepartmentMapper.updateByPrimaryKey(record);
	}


	@Override
	public PageResult queryPage(DepartmentQueryObject qo) {
		Long count = DepartmentMapper.queryByCount(qo);
		List<Department> data  = DepartmentMapper.queryPage(qo);
		return new PageResult(count.longValue(),data);
	}

}
