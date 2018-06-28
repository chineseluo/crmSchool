package com.student.crm.service;
import java.util.List;
import com.student.crm.domain.OrderBill;
import com.student.crm.page.PageResult;
import com.student.crm.query.OrderBillQueryObject;

public interface IOrderBillService {
	int delete(Long id);
    int insert(OrderBill record);
    OrderBill select(Long id);
    List<OrderBill> selectAll();
    int update(OrderBill record);
	PageResult queryPage(OrderBillQueryObject qo);
}
