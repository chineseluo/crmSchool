package com.student.crm.mapper;

import com.student.crm.domain.SaleChart;
import com.student.crm.query.SaleChartQueryObject;

import java.util.List;

public interface SaleChartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SaleChart record);

    SaleChart selectByPrimaryKey(Long id);

    List<SaleChart> selectAll();

    int updateByPrimaryKey(SaleChart record);

    Long queryPageByCount(SaleChartQueryObject qo);

    List<SaleChart> queryByCondition(SaleChartQueryObject qo);
}