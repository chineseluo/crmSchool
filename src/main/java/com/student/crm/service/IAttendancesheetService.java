package com.student.crm.service;
import com.student.crm.domain.Attendancesheet;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;

import java.util.List;
import java.util.Map;

public interface IAttendancesheetService {
	int delete(Long id);
    Integer insert(Attendancesheet record);
    Attendancesheet select(Long id);
    List<Attendancesheet> selectAll();
    int update(Attendancesheet record);
    int update1(Attendancesheet record);
	PageResult queryPage(QueryObject qo);

    List<Map<String,Object>> queryList();
}
