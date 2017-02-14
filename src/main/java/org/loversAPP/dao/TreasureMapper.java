package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.Treasure;

public interface TreasureMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("userid") Integer userid, @Param("treasuretype") Integer treasuretype);

    int insert(Treasure record);

    Treasure selectByPrimaryKey(@Param("id") Integer id, @Param("userid") Integer userid, @Param("treasuretype") Integer treasuretype);

    List<Treasure> selectAll();

    int updateByPrimaryKey(Treasure record);
}