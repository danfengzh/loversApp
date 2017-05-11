package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.InterestTag;
import org.loversAPP.model.InterestTagExample;

import java.util.List;

public interface InterestTagMapper {
    long countByExample(InterestTagExample example);

    int deleteByExample(InterestTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InterestTag record);

    int insertSelective(InterestTag record);

    List<InterestTag> selectByExample(InterestTagExample example);

    InterestTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InterestTag record, @Param("example") InterestTagExample example);

    int updateByExample(@Param("record") InterestTag record, @Param("example") InterestTagExample example);

    int updateByPrimaryKeySelective(InterestTag record);

    int updateByPrimaryKey(InterestTag record);
}