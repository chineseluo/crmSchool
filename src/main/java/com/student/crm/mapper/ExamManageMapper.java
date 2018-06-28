package com.student.crm.mapper;

import com.student.crm.domain.ExamManage;
import com.student.crm.query.ExamManageQueryObject;

import java.util.List;

public interface ExamManageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExamManage record);

    ExamManage selectByPrimaryKey(Long id);

    List<ExamManage> selectAll();

    int updateByPrimaryKey(ExamManage record);


    Long queryForCount(ExamManageQueryObject qo);

    List<ExamManage> queryDataList(ExamManageQueryObject qo);

    void updateResult(ExamManage examManage);
}