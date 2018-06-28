package com.student.crm.mapper;

import com.student.crm.domain.ContractManage;
import com.student.crm.query.ContractManageQueryObject;

import java.util.List;

public interface ContractManageMapper {
    int delete(Long id);
    int insert(ContractManage record);
    ContractManage select(Long id);
    List<ContractManage> selectAll();
    
    int update(ContractManage record);
	Long queryPageCount(ContractManageQueryObject qo);
	List<ContractManage> queryPageData(ContractManageQueryObject qo);
}