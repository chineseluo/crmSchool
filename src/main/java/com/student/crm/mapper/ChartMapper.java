package com.student.crm.mapper;

import com.student.crm.domain.Chart;
import com.student.crm.query.ChargeChartQueryObject;
import com.student.crm.query.CustomChartQueryObject;
import com.student.crm.query.payChartQueryObject;

import java.util.List;

public interface ChartMapper {

	List<Chart> payChartQuery(payChartQueryObject qo);
	List<Chart> chargeChartQuery(ChargeChartQueryObject qo);
	List<Chart> customChartQuery(CustomChartQueryObject qo);
}