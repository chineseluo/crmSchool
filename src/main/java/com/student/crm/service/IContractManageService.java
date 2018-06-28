package com.student.crm.service;

import com.student.crm.domain.ContractManage;
import com.student.crm.page.PageResult;
import com.student.crm.query.ContractManageQueryObject;

import java.util.List;

public interface IContractManageService {
	int delete(Long id);
    int insert(ContractManage record);
    ContractManage select(Long id);
    List<ContractManage> selectAll();
    int update(ContractManage record);
	PageResult queryPage(ContractManageQueryObject qo);
}
