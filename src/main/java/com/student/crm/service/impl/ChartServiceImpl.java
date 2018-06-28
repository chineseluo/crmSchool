package com.student.crm.service.impl;

import com.student.crm.domain.Chart;
import com.student.crm.mapper.ChartMapper;
import com.student.crm.query.ChargeChartQueryObject;
import com.student.crm.query.CustomChartQueryObject;
import com.student.crm.query.payChartQueryObject;
import com.student.crm.service.IChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChartServiceImpl implements IChartService {
	@Autowired
	private ChartMapper payChartMapper;
	@Autowired
	private ChartMapper chargeChartMapper;




	public List<Chart> payChartQuery(payChartQueryObject qo) {
		return payChartMapper.payChartQuery(qo);
	}

	@Override
	public List<Chart> chargeChartQuery(ChargeChartQueryObject qo) {
		return chargeChartMapper.chargeChartQuery(qo);
	}

    @Override
    public List<Chart> customChartQuery(CustomChartQueryObject qo) {
        return chargeChartMapper.customChartQuery(qo);
    }


}
