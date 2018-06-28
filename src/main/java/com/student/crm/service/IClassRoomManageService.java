package com.student.crm.service;
import com.student.crm.domain.ClassRoomManage;
import com.student.crm.page.PageResult;
import com.student.crm.query.ClassRoomManageQueryObject;

import java.util.List;

public interface IClassRoomManageService {
	int delete(Long id);
    int insert(ClassRoomManage record);
    ClassRoomManage select(Long id);
    List<ClassRoomManage> selectAll();
    int update(ClassRoomManage record);
	PageResult queryPage(ClassRoomManageQueryObject qo);

    void updateState(ClassRoomManage classRoomManage);
    void updateState2(Integer state,List<Long> ids);

    List<Long> selectUnuseIds();
}
