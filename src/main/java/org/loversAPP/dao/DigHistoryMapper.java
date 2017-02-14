package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.DigHistory;

public interface DigHistoryMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("userid") Integer userid, @Param("treasureid") Integer treasureid);

    int insert(DigHistory record);

    List<DigHistory> selectAll();
}