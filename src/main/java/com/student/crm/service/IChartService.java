package com.student.crm.service;

import com.student.crm.domain.Chart;
import com.student.crm.query.ChargeChartQueryObject;
import com.student.crm.query.CustomChartQueryObject;
import com.student.crm.query.payChartQueryObject;

import java.util.List;

public interface IChartService {

    List<Chart> payChartQuery(payChartQueryObject qo);
    List<Chart> chargeChartQuery(ChargeChartQueryObject qo);

    List<Chart> customChartQuery(CustomChartQueryObject qo);
}
