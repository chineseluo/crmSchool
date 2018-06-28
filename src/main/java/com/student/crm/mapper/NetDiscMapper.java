package com.student.crm.mapper;

import com.student.crm.domain.NetDisc;
import com.student.crm.query.NetDiscQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface NetDiscMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NetDisc record);

    NetDisc selectByPrimaryKey(Long id);

    List<NetDisc> selectAll();

    int updateByPrimaryKey(NetDisc record);

    Long queryCount(NetDiscQueryObject qo);

    List<NetDisc> list(NetDiscQueryObject qo);
    List<NetDisc> menus(NetDiscQueryObject qo);

    void move(@Param("id") Long id, @Param("pId") Long pId);

    void share(@Param("id") Long id, @Param("share") Long share, @Param("time") Date time);

    List<NetDisc> children(Long id);

    List<NetDisc> allFile(Long id);

    void updateNameById(@Param("id") Long id, @Param("name") String name);

    List<NetDisc> queryNameByKeyword(NetDiscQueryObject qo);

    Long queryShareCount(NetDiscQueryObject qo);

    List<NetDisc> shareList(NetDiscQueryObject qo);

    List<NetDisc> queryNameByShareKeyword(NetDiscQueryObject qo);

    Long getUserIdByParentId(Long pId);
}