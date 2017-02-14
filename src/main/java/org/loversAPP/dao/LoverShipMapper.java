package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.LoverShip;

public interface LoverShipMapper {
    int deleteByPrimaryKey(@Param("lovergirlid") Integer lovergirlid, @Param("loverboyid") Integer loverboyid);

    int insert(LoverShip record);

    LoverShip selectByPrimaryKey(@Param("lovergirlid") Integer lovergirlid, @Param("loverboyid") Integer loverboyid);

    List<LoverShip> selectAll();

    int updateByPrimaryKey(LoverShip record);
}