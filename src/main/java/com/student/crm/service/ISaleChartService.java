
package com.student.crm.service;


import com.student.crm.domain.SaleChart;
import com.student.crm.page.PageResult;
import com.student.crm.query.SaleChartQueryObject;

import java.util.List;

public interface ISaleChartService {
	void deleteByPrimaryKey(Long long1);

	void insert(SaleChart salechart);

	SaleChart selectByPrimaryKey(Long long1);

	List selectAll();

	void updateByPrimaryKey(SaleChart salechart);

	PageResult queryPageResult(SaleChartQueryObject salechartqueryobject);
}
