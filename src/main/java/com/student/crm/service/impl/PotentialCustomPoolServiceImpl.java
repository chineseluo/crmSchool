package com.student.crm.service.impl;

import com.student.crm.domain.History;
import com.student.crm.mapper.HistoryMapper;
import com.student.crm.mapper.PotentialCustomMapper;
import com.student.crm.service.IPotentialCustomPoolSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/14.
 */
@Service
public class PotentialCustomPoolServiceImpl implements IPotentialCustomPoolSerivce {

    @Autowired
    private PotentialCustomMapper potentialCustomMapper;
    @Autowired
    private HistoryMapper historyMapper;
    @Override
    public void removePotentialCustomPool(History history) {
        history.setDate(new Date());
        // 在表中添history

        historyMapper.insert(history);
        history.getClient().setMarketingMan(history.getAfter());
        history.getClient().setStudentState(0l);
        // 改变custom中的marketman的id
        potentialCustomMapper.updateMarketingManById(history.getClient());


    }
}
