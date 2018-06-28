package com.student.crm.service.impl;

import java.util.Collections;
import java.util.List;

import com.student.crm.mapper.ClassCourseManageMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;
import com.student.crm.service.IClassCourseManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.crm.domain.ClassCourseManage;

@Service
public class ClassCourseManageServiceImpl implements IClassCourseManageService {
	@Autowired
	private ClassCourseManageMapper classCourseManageMapper;
	
	public int delete(Long id) {
		return classCourseManageMapper.delete(id);
	}

	public int insert(ClassCourseManage record) {
		return classCourseManageMapper.insert(record);
	}

	public ClassCourseManage select(Long id) {
		return classCourseManageMapper.select(id);
	}

	public List<ClassCourseManage> selectAll() {
		return classCourseManageMapper.selectAll();
	}

	public int update(ClassCourseManage record) {
		return classCourseManageMapper.update(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = classCourseManageMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<ClassCourseManage> result = classCourseManageMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
