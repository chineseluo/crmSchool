package com.student.crm.mapper;

import com.student.crm.domain.SystemDictionary;
import com.student.crm.query.SystemDictionaryQueryObject;

import java.util.List;

public interface SystemDictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionary record);

    SystemDictionary selectByPrimaryKey(Long id);

    List<SystemDictionary> selectAll();

    int updateByPrimaryKey(SystemDictionary record);

    Long queryPageCount(SystemDictionaryQueryObject qo);

    List<SystemDictionary> queryPageData(SystemDictionaryQueryObject qo);
}