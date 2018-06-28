

package com.student.crm.service.impl;


import com.student.crm.domain.SaleChart;
import com.student.crm.mapper.SaleChartMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.SaleChartQueryObject;
import com.student.crm.service.ISaleChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SaleChartServiceImpl implements ISaleChartService {
	@Autowired
	private SaleChartMapper salechartMapper;

	public void deleteByPrimaryKey(Long id)
	{
		salechartMapper.deleteByPrimaryKey(id);
	}

	public void insert(SaleChart record)
	{
		salechartMapper.insert(record);
	}

	public SaleChart selectByPrimaryKey(Long id)
	{
		return salechartMapper.selectByPrimaryKey(id);
	}

	public List selectAll()
	{
		return salechartMapper.selectAll();
	}

	public void updateByPrimaryKey(SaleChart record)
	{
		salechartMapper.updateByPrimaryKey(record);
	}

	public PageResult queryPageResult(SaleChartQueryObject qo)
	{
		Long count = salechartMapper.queryPageByCount(qo);
		if(count <= 0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<SaleChart> rows = salechartMapper.queryByCondition(qo);
		return new PageResult(count.longValue(),rows);
	}
}
