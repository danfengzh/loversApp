package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.DigHistory;
import org.loversAPP.model.DigHistoryExample;

public interface DigHistoryMapper {
    long countByExample(DigHistoryExample example);

    int deleteByExample(DigHistoryExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("userid") Integer userid, @Param("treasureid") Integer treasureid);

    int insert(DigHistory record);

    int insertSelective(DigHistory record);

    List<DigHistory> selectByExample(DigHistoryExample example);

    DigHistory selectByPrimaryKey(@Param("id") Integer id, @Param("userid") Integer userid, @Param("treasureid") Integer treasureid);

    int updateByExampleSelective(@Param("record") DigHistory record, @Param("example") DigHistoryExample example);

    int updateByExample(@Param("record") DigHistory record, @Param("example") DigHistoryExample example);

    int updateByPrimaryKeySelective(DigHistory record);

    int updateByPrimaryKey(DigHistory record);
}