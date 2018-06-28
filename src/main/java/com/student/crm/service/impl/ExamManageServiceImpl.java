package com.student.crm.service.impl;

import com.student.crm.domain.Employee;
import com.student.crm.domain.ExamManage;
import com.student.crm.mapper.ExamManageMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.ExamManageQueryObject;
import com.student.crm.service.IExamManageService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ExamManageServiceImpl implements IExamManageService {
	@Autowired
	private ExamManageMapper ExamManageMapper;
	public int deleteByPrimaryKey(Long id) {
		return ExamManageMapper.deleteByPrimaryKey(id);
	}

	public int insert(ExamManage record) {
        Employee currentEmp = (Employee) SecurityUtils.getSubject().getPrincipal();
	    record.setEmployee(currentEmp);

		int count = ExamManageMapper.insert(record);
		return count;
	}

	public ExamManage selectByPrimaryKey(Long id) {
		return ExamManageMapper.selectByPrimaryKey(id);
	}

	public List<ExamManage> selectAll() {
		return ExamManageMapper.selectAll();
	}

	public int updateByPrimaryKey(ExamManage record) {
		return ExamManageMapper.updateByPrimaryKey(record);
	}

    @Override
    public PageResult queryPage(ExamManageQueryObject qo) {
        Long count = ExamManageMapper.queryForCount(qo);
        if (count <= 0) {
            return new PageResult(0l, Collections.EMPTY_LIST);
        }
        List<ExamManage> data = ExamManageMapper.queryDataList(qo);
        return new PageResult(count.longValue(),data);
    }

    @Override
    public void updateResult(ExamManage examManage) {
        ExamManageMapper.updateResult(examManage);
    }


}
