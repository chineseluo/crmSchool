package com.student.crm.service;

import com.student.crm.domain.SystemDictionary;
import com.student.crm.page.PageResult;
import com.student.crm.query.SystemDictionaryQueryObject;

import java.util.List;

public interface ISystemDictionaryService {
	int deleteByPrimaryKey(Long id);
    int insert(SystemDictionary record);
    SystemDictionary selectByPrimaryKey(Long id);
    List<SystemDictionary> selectAll();
    int updateByPrimaryKey(SystemDictionary record);

    PageResult queryPage(SystemDictionaryQueryObject qo);
}
