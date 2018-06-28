package com.student.crm.service.impl;

import com.student.crm.domain.Attendance1;
import com.student.crm.domain.Attendance2;
import com.student.crm.domain.Attendance3;
import com.student.crm.domain.AttendanceExport;
import com.student.crm.mapper.AttendanceExportMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;
import com.student.crm.service.IAttendanceExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class AttendanceExportServiceImpl implements IAttendanceExportService {
	@Autowired
	private AttendanceExportMapper attendanceExportMapper;
	
	
	
	
	//设置员工列表方法

	
	public int delete(Long id) {
		return attendanceExportMapper.delete(id);
	}

	public int insert(AttendanceExport record) {
		return attendanceExportMapper.insert(record);
	}

	public AttendanceExport select(Long id) {
		return attendanceExportMapper.select(id);
	}

	public List<AttendanceExport> selectAll() {
		return attendanceExportMapper.selectAll();
	}

	public int update(AttendanceExport record) {
		return attendanceExportMapper.update(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
	
		Long count = attendanceExportMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<AttendanceExport> result = attendanceExportMapper.queryPageData(qo);
		
		
		List<Attendance1> a1=attendanceExportMapper.selectattendance();
		List<Attendance2> a2=attendanceExportMapper.selectlate();
		List<Attendance3> a3=attendanceExportMapper.selectearlydays();
		
		for (int i = 0; i < result.size(); i++) {
			result.get(i).setAttendancedays(a1.get(i).getAttendancedays());
			result.get(i).setLatedays(a2.get(i).getLatedays());
			result.get(i).setEarlydays(a3.get(i).getEarlydays());
		}
		

		//System.out.println(result);
		PageResult pageResult = new PageResult(count,result);
		
		return pageResult;
	}
}
