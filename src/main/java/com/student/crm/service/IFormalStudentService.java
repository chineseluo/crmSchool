package com.student.crm.service;

import com.student.crm.domain.PotentialCustom;

/**
 * Created by Administrator on 2017/10/15.
 */
public interface IFormalStudentService {

    void updateByPrimaryKey(PotentialCustom potentialCustom);

    void updateClass(PotentialCustom potentialCustom);

    void updateStudentStateToLoss(Long id);

    void updateStudentStateToDropOut(Long id);

    void payment(PotentialCustom potentialCustom, Long payment);
}
