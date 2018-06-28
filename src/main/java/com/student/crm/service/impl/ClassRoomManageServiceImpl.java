package com.student.crm.service.impl;

import com.student.crm.domain.ClassRoomManage;
import com.student.crm.mapper.ClassRoomManageMapper;
import com.student.crm.page.PageResult;
import com.student.crm.query.ClassRoomManageQueryObject;
import com.student.crm.service.IClassRoomManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class ClassRoomManageServiceImpl implements IClassRoomManageService {
	@Autowired
	private ClassRoomManageMapper classRoomManageMapper;
	
	public int delete(Long id) {
		return classRoomManageMapper.delete(id);
	}

	public int insert(ClassRoomManage record) {
		return classRoomManageMapper.insert(record);
	}

	public ClassRoomManage select(Long id) {
		return classRoomManageMapper.select(id);
	}

	public List<ClassRoomManage> selectAll() {
		return classRoomManageMapper.selectAll();
	}

	public int update(ClassRoomManage record) {
		return classRoomManageMapper.update(record);
	}



	@Override
	public PageResult queryPage(ClassRoomManageQueryObject qo) {
		Long count = classRoomManageMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<ClassRoomManage> result = classRoomManageMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}

	@Override
	public void updateState(ClassRoomManage classRoomManage) {
		classRoomManageMapper.updateState(classRoomManage);
	}
	@Override
	public void updateState2(Integer state ,List<Long> ids) {
		classRoomManageMapper.updateState2(state,ids);
	}

	@Override
	public List<Long> selectUnuseIds() {
		return classRoomManageMapper.selectUnuseIds();
	}
}
