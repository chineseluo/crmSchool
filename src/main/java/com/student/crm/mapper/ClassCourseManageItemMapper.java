package com.student.crm.mapper;

import com.student.crm.domain.ClassCourseManageItem;
import com.student.crm.query.ClassCourseManageItemQueryObject;
import java.util.List;

public interface ClassCourseManageItemMapper {
    int delete(Long id);
    int insert(ClassCourseManageItem record);
    ClassCourseManageItem select(Long id);
    List<ClassCourseManageItem> selectAll();
    int update(ClassCourseManageItem record);
	Long queryPageCount(ClassCourseManageItemQueryObject qo);
	List<ClassCourseManageItem> queryPageData(ClassCourseManageItemQueryObject qo);
}