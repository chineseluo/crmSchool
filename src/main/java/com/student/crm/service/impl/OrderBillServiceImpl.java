package com.student.crm.service.impl;

import java.util.Collections;
import java.util.List;

import com.student.crm.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.crm.domain.OrderBill;
import com.student.crm.mapper.OrderBillMapper;
import com.student.crm.query.OrderBillQueryObject;
import com.student.crm.service.IOrderBillService;
@Service
public class OrderBillServiceImpl implements IOrderBillService {
	@Autowired
	private OrderBillMapper orderBillMapper;
	
	public int delete(Long id) {
		return orderBillMapper.delete(id);
	}

	public int insert(OrderBill record) {
		return orderBillMapper.insert(record);
	}

	public OrderBill select(Long id) {
		return orderBillMapper.select(id);
	}

	public List<OrderBill> selectAll() {
		return orderBillMapper.selectAll();
	}

	public int update(OrderBill record) {
		return orderBillMapper.update(record);
	}

	@Override
	public PageResult queryPage(OrderBillQueryObject qo) {
		Long count = orderBillMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<OrderBill> result = orderBillMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
