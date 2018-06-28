package com.student.crm.service.impl;

import java.util.Collections;
import java.util.List;

import com.student.crm.page.PageResult;
import com.student.crm.query.ClassCourseManageItemQueryObject;
import com.student.crm.service.IClassCourseManageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.crm.domain.ClassCourseManageItem;
import com.student.crm.mapper.ClassCourseManageItemMapper;

@Service
public class ClassCourseManageItemServiceImpl implements IClassCourseManageItemService {
	@Autowired
	private ClassCourseManageItemMapper classCourseManageItemMapper;
	
	public int delete(Long id) {
		return classCourseManageItemMapper.delete(id);
	}

	public int insert(ClassCourseManageItem record) {
		return classCourseManageItemMapper.insert(record);
	}

	public ClassCourseManageItem select(Long id) {
		return classCourseManageItemMapper.select(id);
	}

	public List<ClassCourseManageItem> selectAll() {
		return classCourseManageItemMapper.selectAll();
	}

	public int update(ClassCourseManageItem record) {
		return classCourseManageItemMapper.update(record);
	}

	@Override
	public PageResult queryPage(ClassCourseManageItemQueryObject qo) {
		Long count = classCourseManageItemMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<ClassCourseManageItem> result = classCourseManageItemMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
