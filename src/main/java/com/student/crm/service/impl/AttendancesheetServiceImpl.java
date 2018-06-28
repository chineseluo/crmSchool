package com.student.crm.service.impl;

import com.student.crm.domain.Attendancesheet;
import com.student.crm.domain.Employee;
import com.student.crm.mapper.AttendancesheetMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;
import com.student.crm.service.IAttendancesheetService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AttendancesheetServiceImpl implements IAttendancesheetService {
	@Autowired
	private AttendancesheetMapper attendancesheetMapper;
	
	//补签
	public int delete(Long id) {
		
		return attendancesheetMapper.delete(id);
	}

	//出勤天数
	
	
			
	//签到
	public Integer insert(Attendancesheet record) {
		//如果时间超过8:00,那么算迟到,状态是1
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		Date start = calendar.getTime();

		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.SECOND, -1);

		Date end = calendar.getTime();
		Employee current = (Employee) SecurityUtils.getSubject().getPrincipal();
		Integer count=attendancesheetMapper.queryTodaySign(start,end,current.getUsername());
		if(count>0){
			throw new RuntimeException("已签到");
		}
		Date date=new Date();
	       DateFormat df = new SimpleDateFormat("HH:mm:ss");
	       String time1="08:30:00";
	       Date time2;
		try {
			time2 = df.parse(time1);
			if (df.parse(df.format(date)).getTime()>time2.getTime()) {
				record.setState(1);
				System.out.println("迟到");
				
				
			}
			else{
				
				record.setState(0);
			}
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		record.setSignintime(new Date());

	
		record.setEmployee1(current);
		
		try {
			InetAddress currentIp = InetAddress.getLocalHost();
			record.setIp(currentIp.getHostAddress());
			//System.out.println("你的IP地址是：" + myip.getHostAddress());

			//System.out.println("主机名为：" + myip.getHostName() + "。");

		} catch (Exception e) {

			e.printStackTrace();

		}
		attendancesheetMapper.insert(record);
		return record.getState();
	}

	public Attendancesheet select(Long id) {
		return attendancesheetMapper.select(id);
	}

	public List<Attendancesheet> selectAll() {
		return attendancesheetMapper.selectAll();
	}

	//签退
	public int update(Attendancesheet record) {
		
		//如果时间超过8:00,那么算迟到,状态是1
		
				Date date=new Date();
			       DateFormat df = new SimpleDateFormat("HH:mm:ss");
			       String time1="18:30:00";
			       Date time2;
				try {
					time2 = df.parse(time1);
					if (df.parse(df.format(date)).getTime()>time2.getTime()) {
						//System.out.println(date.getTime());
						//System.out.println(time2.getTime());
						record.setState(0);
						//System.out.println("正常");
					}
					else{
						record.setState(1);
						System.out.println("早退");
					}
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
		
		
		record.setSignouttime(new Date());
		Employee current = (Employee) SecurityUtils.getSubject().getPrincipal();
	
		record.setEmployee1(current);
		
		try {
			InetAddress currentIp = InetAddress.getLocalHost();
			record.setIp(currentIp.getHostAddress());
			//System.out.println("你的IP地址是：" + myip.getHostAddress());

			//System.out.println("主机名为：" + myip.getHostName() + "。");

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return attendancesheetMapper.insert(record);
	}
	//补签
	public int update1(Attendancesheet record) {
		record.setRetroactivetime(new Date());
		Employee current = (Employee) SecurityUtils.getSubject().getPrincipal();
		
		record.setEmployee2(current);
		
		try {
			InetAddress currentIp = InetAddress.getLocalHost();
			record.setIp(currentIp.getHostAddress());
			//System.out.println("你的IP地址是：" + myip.getHostAddress());
			
			//System.out.println("主机名为：" + myip.getHostName() + "。");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return attendancesheetMapper.update(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = attendancesheetMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0l, Collections.EMPTY_LIST);
		}
		List<Attendancesheet> result = attendancesheetMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count.longValue(),result);
		return pageResult;
	}

    @Override
    public List<Map<String, Object>> queryList() {
		Calendar cal = Calendar.getInstance();
		int MaxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set( cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), MaxDay, 23, 59, 59);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String end = sdf.format(cal.getTime());
		cal.set( cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
		String start = sdf.format(cal.getTime());
		Employee user = (Employee) SecurityUtils.getSubject().getPrincipal();
		return attendancesheetMapper.queryList(start,end,user.getUsername());
    }
}
