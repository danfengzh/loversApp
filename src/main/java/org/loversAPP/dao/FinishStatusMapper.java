package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.FinishStatus;
import org.loversAPP.model.FinishStatusExample;

import java.util.List;

public interface FinishStatusMapper {
    long countByExample(FinishStatusExample example);

    int deleteByExample(FinishStatusExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("userid") Integer userid);

    int insert(FinishStatus record);

    int insertSelective(FinishStatus record);

    List<FinishStatus> selectByExample(FinishStatusExample example);

    FinishStatus selectByPrimaryKey(@Param("id") Integer id, @Param("userid") Integer userid);

    int updateByExampleSelective(@Param("record") FinishStatus record, @Param("example") FinishStatusExample example);

    int updateByExample(@Param("record") FinishStatus record, @Param("example") FinishStatusExample example);

    int updateByPrimaryKeySelective(FinishStatus record);

    int updateByPrimaryKey(FinishStatus record);
}