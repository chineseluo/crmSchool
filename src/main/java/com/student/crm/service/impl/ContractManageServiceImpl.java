package com.student.crm.service.impl;

import com.student.crm.domain.ContractManage;
import com.student.crm.mapper.ContractManageMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.ContractManageQueryObject;
import com.student.crm.service.IContractManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ContractManageServiceImpl implements IContractManageService {
	@Autowired
	private ContractManageMapper contractManageMapper;
	
	public int delete(Long id) {
		return contractManageMapper.delete(id);
	}

	public int insert(ContractManage record) {
		return contractManageMapper.insert(record);
	}

	public ContractManage select(Long id) {
		return contractManageMapper.select(id);
	}

	public List<ContractManage> selectAll() {
		return contractManageMapper.selectAll();
	}

	public int update(ContractManage record) {
		return contractManageMapper.update(record);
	}

	@Override
	public PageResult queryPage(ContractManageQueryObject qo) {
		Long count = contractManageMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<ContractManage> result = contractManageMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
