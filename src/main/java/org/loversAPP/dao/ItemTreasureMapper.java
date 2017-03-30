package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.ItemTreasure;
import org.loversAPP.model.ItemTreasureExample;

import java.util.List;

public interface ItemTreasureMapper {
    long countByExample(ItemTreasureExample example);

    int deleteByExample(ItemTreasureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemTreasure record);

    int insertSelective(ItemTreasure record);

    List<ItemTreasure> selectByExample(ItemTreasureExample example);

    ItemTreasure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemTreasure record, @Param("example") ItemTreasureExample example);

    int updateByExample(@Param("record") ItemTreasure record, @Param("example") ItemTreasureExample example);

    int updateByPrimaryKeySelective(ItemTreasure record);

    int updateByPrimaryKey(ItemTreasure record);

    int getItemIDbyTreasureCode(@Param("treasureCode") int treasureCode);
}