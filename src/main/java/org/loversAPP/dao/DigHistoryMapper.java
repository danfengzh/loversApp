package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.DigHistoryExample;
import org.loversAPP.model.DigHistoryKey;

public interface DigHistoryMapper {
    long countByExample(DigHistoryExample example);

    int deleteByExample(DigHistoryExample example);

    int deleteByPrimaryKey(DigHistoryKey key);

    int insert(DigHistoryKey record);

    int insertSelective(DigHistoryKey record);

    List<DigHistoryKey> selectByExample(DigHistoryExample example);

    int updateByExampleSelective(@Param("record") DigHistoryKey record, @Param("example") DigHistoryExample example);

    int updateByExample(@Param("record") DigHistoryKey record, @Param("example") DigHistoryExample example);
}