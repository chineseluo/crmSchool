package com.student.crm.mapper;

import com.student.crm.domain.PotentialCustom;
import com.student.crm.query.QueryObject;

import java.util.List;

public interface PotentialCustomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PotentialCustom record);

    PotentialCustom selectByPrimaryKey(Long id);

    List<PotentialCustom> selectAll();

    int updateByPrimaryKey(PotentialCustom record);

    List<PotentialCustom> queryPageData(QueryObject qo);
    Long queryPageCount(QueryObject qo);

    void saveFormalStudent(PotentialCustom record);

    void updateByTrackStudent(PotentialCustom student);

    void changeCustomToPool(PotentialCustom potentialCustom);

    void updateMarketingManById(PotentialCustom client);


    void updateFormalStudent(PotentialCustom potentialCustom);

    void updateClass(PotentialCustom potentialCustom);

    void updateStudentStateToLoss(PotentialCustom potentialCustom);

    void payment(PotentialCustom potentialCustom);

    void PotentialCustom(PotentialCustom potentialCustom);

    void updateInformById(Long id);
}