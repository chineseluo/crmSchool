package com.student.crm.service;

import com.student.crm.domain.PotentialCustom;
import com.student.crm.page.PageResult;
import com.student.crm.query.QueryObject;

import java.util.List;

public interface IPotentialCustomService {
	int deleteByPrimaryKey(Long id);
    int insert(PotentialCustom record);
    PotentialCustom selectByPrimaryKey(Long id);
    List<PotentialCustom> selectAll();
    int updateByPrimaryKey(PotentialCustom record);
	PageResult queryPage(QueryObject qo);

    void saveFormalStudent(PotentialCustom potentialCustom);


    void changeStudentState(PotentialCustom potentialCustom);

    void updateLossStudent(PotentialCustom potentialCustom);

    void updateInformById(Long id, String email);
}
