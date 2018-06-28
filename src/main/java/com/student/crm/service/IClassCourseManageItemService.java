package com.student.crm.service;
import java.util.List;
import com.student.crm.domain.ClassCourseManageItem;
import com.student.crm.page.PageResult;
import com.student.crm.query.ClassCourseManageItemQueryObject;

public interface IClassCourseManageItemService {
	int delete(Long id);
    int insert(ClassCourseManageItem record);
    ClassCourseManageItem select(Long id);
    List<ClassCourseManageItem> selectAll();
    int update(ClassCourseManageItem record);
	PageResult queryPage(ClassCourseManageItemQueryObject qo);
}
