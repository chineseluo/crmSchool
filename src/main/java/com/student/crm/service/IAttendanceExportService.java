package com.student.crm.service;
import java.util.List;
import com.student.crm.domain.AttendanceExport;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;

public interface IAttendanceExportService {
	int delete(Long id);
    int insert(AttendanceExport record);
    AttendanceExport select(Long id);
    List<AttendanceExport> selectAll();
    int update(AttendanceExport record);
	PageResult queryPage(QueryObject qo);
}
