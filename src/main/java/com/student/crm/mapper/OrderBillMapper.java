package com.student.crm.mapper;

import com.student.crm.domain.OrderBill;
import com.student.crm.query.OrderBillQueryObject;

import java.util.List;

public interface OrderBillMapper {
    int delete(Long id);
    int insert(OrderBill record);
    OrderBill select(Long id);
    List<OrderBill> selectAll();

    int update(OrderBill record);
	Long queryPageCount(OrderBillQueryObject qo);
	List<OrderBill> queryPageData(OrderBillQueryObject qo);
}