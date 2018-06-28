package com.student.crm.service;

import com.student.crm.domain.SystemDictionaryItem;

import java.util.List;

public interface ISystemDictionaryItemService {
	int deleteByPrimaryKey(Long id);
    int insert(SystemDictionaryItem record);
    SystemDictionaryItem selectByPrimaryKey(Long id);
    List<SystemDictionaryItem> selectAll();
    int updateByPrimaryKey(SystemDictionaryItem record);

    List queryBySystemDictionaryId(Long id);

    List<SystemDictionaryItem> queryAllBySn(String sn);
}
