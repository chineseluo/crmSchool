package com.student.crm.service;
import java.util.List;
import com.student.crm.domain.ClassCourseManage;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;

public interface IClassCourseManageService {
	int delete(Long id);
    int insert(ClassCourseManage record);
    ClassCourseManage select(Long id);
    List<ClassCourseManage> selectAll();
    int update(ClassCourseManage record);
	PageResult queryPage(QueryObject qo);
}
