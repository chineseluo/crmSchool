package com.student.crm.service;

import com.student.crm.domain.ExamManage;
import com.student.crm.page.PageResult;
import com.student.crm.query.ExamManageQueryObject;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
public interface IExamManageService {

    int deleteByPrimaryKey(Long id);

    int insert(ExamManage record);

    ExamManage selectByPrimaryKey(Long id);

    List<ExamManage> selectAll();

    int updateByPrimaryKey(ExamManage record);

    PageResult queryPage(ExamManageQueryObject qo);

    void updateResult(ExamManage examManage);
}
