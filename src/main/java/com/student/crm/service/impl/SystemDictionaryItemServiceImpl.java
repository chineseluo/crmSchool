package com.student.crm.service.impl;

import com.student.crm.domain.SystemDictionaryItem;
import com.student.crm.mapper.SystemDictionaryItemMapper;
import com.student.crm.service.ISystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemDictionaryItemServiceImpl implements ISystemDictionaryItemService {
	@Autowired
	private SystemDictionaryItemMapper systemDictionaryItemMapper;
	public int deleteByPrimaryKey(Long id) {
		return systemDictionaryItemMapper.deleteByPrimaryKey(id);
	}

	public int insert(SystemDictionaryItem record) {
		int count = systemDictionaryItemMapper.insert(record);
		return count;
	}

	public SystemDictionaryItem selectByPrimaryKey(Long id) {
		return systemDictionaryItemMapper.selectByPrimaryKey(id);
	}

	public List<SystemDictionaryItem> selectAll() {
		return systemDictionaryItemMapper.selectAll();
	}

	public int updateByPrimaryKey(SystemDictionaryItem record) {
		return systemDictionaryItemMapper.updateByPrimaryKey(record);
	}

    @Override
    public List queryBySystemDictionaryId(Long id) {
        return systemDictionaryItemMapper.queryBySystemDictionaryId(id);
    }

    @Override
    public List<SystemDictionaryItem> queryAllBySn(String sn) {
        return systemDictionaryItemMapper.queryAllBySn(sn);
    }


}
