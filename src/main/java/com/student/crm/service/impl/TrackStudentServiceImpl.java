package com.student.crm.service.impl;

import com.student.crm.domain.Employee;
import com.student.crm.domain.TrackStudent;
import com.student.crm.mapper.PotentialCustomMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.TrackStudentQueryObject;
import com.student.crm.service.ITrackStudentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class TrackStudentServiceImpl implements ITrackStudentService {
	@Autowired
	private com.student.crm.mapper.TrackStudentMapper TrackStudentMapper;
    @Autowired
    private PotentialCustomMapper potentialCustomMapper;

    public int deleteByPrimaryKey(Long id) {
		return TrackStudentMapper.deleteByPrimaryKey(id);
	}

	public int insert(TrackStudent record) {
        Employee currentEmp = (Employee) SecurityUtils.getSubject().getPrincipal();
        record.setConsultPerson(currentEmp);
        // 可能回去更该数据库中的potentialCustom 的状态
        potentialCustomMapper.updateByTrackStudent(record.getStudent());

        record.setTrackTime(new Date());
        int count = TrackStudentMapper.insert(record);
		return count;
	}

	public TrackStudent selectByPrimaryKey(Long id) {
		return TrackStudentMapper.selectByPrimaryKey(id);
	}

	public List<TrackStudent> selectAll() {
		return TrackStudentMapper.selectAll();
	}

	public int updateByPrimaryKey(TrackStudent record) {
            potentialCustomMapper.updateByTrackStudent(record.getStudent());

		return TrackStudentMapper.updateByPrimaryKey(record);
	}

    @Override
    public PageResult queryPage(TrackStudentQueryObject qo) {
        Long count = TrackStudentMapper.queryForCount(qo);
        if (count <= 0) {
            return new PageResult(0l, Collections.EMPTY_LIST);
        }
        List<TrackStudent> data = TrackStudentMapper.queryDataList(qo);
        return new PageResult(count.longValue(),data);
    }



}
