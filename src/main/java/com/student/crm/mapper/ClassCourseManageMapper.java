package com.student.crm.mapper;

import com.student.crm.domain.ClassCourseManage;
import com.student.crm.query.QueryObject;
import java.util.List;

public interface ClassCourseManageMapper {
    int delete(Long id);
    int insert(ClassCourseManage record);
    ClassCourseManage select(Long id);
    List<ClassCourseManage> selectAll();
    int update(ClassCourseManage record);
	Long queryPageCount(QueryObject qo);
	List<ClassCourseManage> queryPageData(QueryObject qo);
}