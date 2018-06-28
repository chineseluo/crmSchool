package com.student.crm.service;

import com.student.crm.domain.TrackStudent;
import com.student.crm.page.PageResult;
import com.student.crm.query.TrackStudentQueryObject;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
public interface ITrackStudentService {

    int deleteByPrimaryKey(Long id);

    int insert(TrackStudent record);

    TrackStudent selectByPrimaryKey(Long id);

    List<TrackStudent> selectAll();

    int updateByPrimaryKey(TrackStudent record);

    PageResult queryPage(TrackStudentQueryObject qo);
}
