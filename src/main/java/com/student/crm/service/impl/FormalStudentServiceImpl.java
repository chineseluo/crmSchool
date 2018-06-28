package com.student.crm.service.impl;

import com.student.crm.domain.PotentialCustom;
import com.student.crm.mapper.PotentialCustomMapper;
import com.student.crm.service.IFormalStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FormalStudentServiceImpl implements IFormalStudentService {
	@Autowired
	private PotentialCustomMapper potentialCustomMapper;
    @Override
    public void updateByPrimaryKey(PotentialCustom potentialCustom) {
        potentialCustomMapper.updateFormalStudent(potentialCustom);
    }

    @Override
    public void updateClass(PotentialCustom potentialCustom) {
        Long beforeId = potentialCustom.getBeforeClass().getId();
        Long currentId = potentialCustom.getCurrentClass().getId();
        Long state = null;
        if (currentId > beforeId) {
            state = PotentialCustom.DOWN_TO_CLASS;
        } else {
            state = PotentialCustom.UP_TO_CLASS;
        }
        potentialCustom.setStudentState(state);
        potentialCustomMapper.updateClass(potentialCustom);
    }

    @Override
    public void updateStudentStateToLoss(Long id) {
        PotentialCustom potentialCustom = new PotentialCustom();
        potentialCustom.setId(id);
        potentialCustom.setLossTime(new Date());
        potentialCustom.setStudentState(PotentialCustom.LOSS_STATE);

        potentialCustomMapper.updateStudentStateToLoss(potentialCustom);

    }

    @Override
    public void updateStudentStateToDropOut(Long id) {
        PotentialCustom potentialCustom = new PotentialCustom();
        potentialCustom.setId(id);
        potentialCustom.setStudentState(PotentialCustom.STUDENT_DROP_OUT);

        potentialCustomMapper.updateStudentStateToLoss(potentialCustom);
    }

    @Override
    public void payment(PotentialCustom potentialCustom, Long payment) {
        // 获取付款的净额
        potentialCustom.setDefraiedTuition(potentialCustom.getDefraiedTuition() + payment);
        potentialCustom.setDueTuition(potentialCustom.getTotalTuition() - potentialCustom.getDefraiedTuition());

        if (potentialCustom.getDueTuition() == 0) {
            //potentialCustom.setPayState();
        }
        potentialCustomMapper.payment(potentialCustom);
    }
}
