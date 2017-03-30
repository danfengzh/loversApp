package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.Treasure;
import org.loversAPP.model.TreasureExample;

import java.util.List;

public interface TreasureMapper {
    long countByExample(TreasureExample example);

    int deleteByExample(TreasureExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("userid") Integer userid);

    int insert(Treasure record);

    int insertSelective(Treasure record);

    List<Treasure> selectByExample(TreasureExample example);

    Treasure selectByPrimaryKey(@Param("id") Integer id, @Param("userid") Integer userid);

    int updateByExampleSelective(@Param("record") Treasure record, @Param("example") TreasureExample example);

    int updateByExample(@Param("record") Treasure record, @Param("example") TreasureExample example);

    int updateByPrimaryKeySelective(Treasure record);

    int updateByPrimaryKey(Treasure record);

    Treasure getTreasureByID(@Param("id") int id);

    List<Treasure> getAllTreasures();

    int deleteTreasureByID(@Param("id") int id);

    int insertBathch(@Param("treasures") List<Treasure> treasures);
}