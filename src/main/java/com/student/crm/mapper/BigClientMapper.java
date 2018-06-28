package com.student.crm.mapper;

import com.student.crm.domain.BigClient;
import com.student.crm.query.BigClientQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BigClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BigClient record);

    BigClient selectByPrimaryKey(Long id);

    List<BigClient> selectAll();

    int updateByPrimaryKey(BigClient record);

    Long queryCount(BigClientQueryObject qo);

    List<BigClient> list(BigClientQueryObject qo);

    void updateFollowById(@Param("id") Long id, @Param("fId") Long fId);
}