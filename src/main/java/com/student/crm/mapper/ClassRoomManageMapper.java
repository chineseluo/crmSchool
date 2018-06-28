package com.student.crm.mapper;

import com.student.crm.domain.ClassRoomManage;
import com.student.crm.query.ClassRoomManageQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassRoomManageMapper {
    int delete(Long id);
    int insert(ClassRoomManage record);
    ClassRoomManage select(Long id);
    List<ClassRoomManage> selectAll();
    int update(ClassRoomManage record);
	Long queryPageCount(ClassRoomManageQueryObject qo);
	List<ClassRoomManage> queryPageData(ClassRoomManageQueryObject qo);

    void updateState(ClassRoomManage classRoomManage);
    void updateState2(@Param("state") Integer state,@Param("ids") List<Long> ids);
    List<Long> selectUnuseIds( );
}