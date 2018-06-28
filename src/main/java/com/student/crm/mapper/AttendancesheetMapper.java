package com.student.crm.mapper;

import com.student.crm.domain.Attendancesheet;
import com.student.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AttendancesheetMapper {
    int delete(Long id);
    int insert(Attendancesheet record);
    Attendancesheet select(Long id);
    List<Attendancesheet> selectAll();
    int update(Attendancesheet record);
	Long queryPageCount(QueryObject qo);
	List<Attendancesheet> queryPageData(QueryObject qo);

    Integer queryTodaySign(@Param("start") Date start, @Param("end") Date end,@Param("username") String username);

    List<Map<String,Object>> queryList(@Param("start") String start, @Param("end") String end, @Param("username") String username);

/*	int selectattendance();
	int selectlate();
	int selectearlydays();*/
}