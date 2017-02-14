package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.LoverShip;
import org.loversAPP.model.LoverShipExample;
import org.loversAPP.model.LoverShipKey;

public interface LoverShipMapper {
    long countByExample(LoverShipExample example);

    int deleteByExample(LoverShipExample example);

    int deleteByPrimaryKey(LoverShipKey key);

    int insert(LoverShip record);

    int insertSelective(LoverShip record);

    List<LoverShip> selectByExample(LoverShipExample example);

    LoverShip selectByPrimaryKey(LoverShipKey key);

    int updateByExampleSelective(@Param("record") LoverShip record, @Param("example") LoverShipExample example);

    int updateByExample(@Param("record") LoverShip record, @Param("example") LoverShipExample example);

    int updateByPrimaryKeySelective(LoverShip record);

    int updateByPrimaryKey(LoverShip record);
}