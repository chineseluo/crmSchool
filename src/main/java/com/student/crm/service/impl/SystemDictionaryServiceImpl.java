package com.student.crm.service.impl;

import com.student.crm.domain.SystemDictionary;
import com.student.crm.domain.SystemDictionaryItem;
import com.student.crm.mapper.SystemDictionaryItemMapper;
import com.student.crm.mapper.SystemDictionaryMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.SystemDictionaryQueryObject;
import com.student.crm.service.ISystemDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SystemDictionaryServiceImpl implements ISystemDictionaryService {
	@Autowired
	private SystemDictionaryMapper systemDictionaryMapper;
    @Autowired
    private SystemDictionaryItemMapper systemDictionaryItemMapper;

    public int deleteByPrimaryKey(Long id) {
        /*删除的时候还需要把item中的数据给删掉*/
        systemDictionaryItemMapper.deleteByParentId(id);


		return systemDictionaryMapper.deleteByPrimaryKey(id);
	}

	public int insert(SystemDictionary record) {
		int count = systemDictionaryMapper.insert(record);
		// 维护 item 中的关系
        for (SystemDictionaryItem item : record.getItems()) {
            item.setParentId(record.getId());
            systemDictionaryItemMapper.insert(item);

        }


		return count;
	}

	public SystemDictionary selectByPrimaryKey(Long id) {
		return systemDictionaryMapper.selectByPrimaryKey(id);
	}

	public List<SystemDictionary> selectAll() {
		return systemDictionaryMapper.selectAll();
	}

	public int updateByPrimaryKey(SystemDictionary record) {
        // 先删除表中的数据  更具parentId
        systemDictionaryItemMapper.deleteByParentId(record.getId());
        // 在去维护中间表的关系
        for (SystemDictionaryItem item : record.getItems()) {
            item.setParentId(record.getId());
            systemDictionaryItemMapper.insert(item);

        }

		return systemDictionaryMapper.updateByPrimaryKey(record);
	}

    @Override
    public PageResult queryPage(SystemDictionaryQueryObject qo) {



        //符合条件的总数
        Long count = systemDictionaryMapper.queryPageCount(qo);
        if(count <= 0){
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<SystemDictionary> result =  systemDictionaryMapper.queryPageData(qo);
        return new PageResult(count, result);



    }

}
