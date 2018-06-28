package com.student.crm.mapper;

import java.util.List;

import com.student.crm.domain.Attendance1;
import com.student.crm.domain.Attendance2;
import com.student.crm.domain.Attendance3;
import com.student.crm.domain.AttendanceExport;
import com.student.crm.query.QueryObject;

public interface AttendanceExportMapper {
    int delete(Long id);
    int insert(AttendanceExport record);
    AttendanceExport select(Long id);
    List<AttendanceExport> selectAll();
    int update(AttendanceExport record);
	Long queryPageCount(QueryObject qo);
	List<AttendanceExport> queryPageData(QueryObject qo);
	
	List<Attendance1> selectattendance();
	List<Attendance2> selectlate();
	List<Attendance3> selectearlydays();
}