package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.GoDie;
import org.loversAPP.model.GoDieExample;

import java.util.List;

public interface GoDieMapper {
    long countByExample(GoDieExample example);

    int deleteByExample(GoDieExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoDie record);

    int insertSelective(GoDie record);

    List<GoDie> selectByExample(GoDieExample example);

    GoDie selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoDie record, @Param("example") GoDieExample example);

    int updateByExample(@Param("record") GoDie record, @Param("example") GoDieExample example);

    int updateByPrimaryKeySelective(GoDie record);

    int updateByPrimaryKey(GoDie record);
}