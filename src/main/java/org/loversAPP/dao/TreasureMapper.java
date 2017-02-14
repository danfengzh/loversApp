package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.Treasure;
import org.loversAPP.model.TreasureExample;
import org.loversAPP.model.TreasureKey;

public interface TreasureMapper {
    long countByExample(TreasureExample example);

    int deleteByExample(TreasureExample example);

    int deleteByPrimaryKey(TreasureKey key);

    int insert(Treasure record);

    int insertSelective(Treasure record);

    List<Treasure> selectByExample(TreasureExample example);

    Treasure selectByPrimaryKey(TreasureKey key);

    int updateByExampleSelective(@Param("record") Treasure record, @Param("example") TreasureExample example);

    int updateByExample(@Param("record") Treasure record, @Param("example") TreasureExample example);

    int updateByPrimaryKeySelective(Treasure record);

    int updateByPrimaryKey(Treasure record);
}