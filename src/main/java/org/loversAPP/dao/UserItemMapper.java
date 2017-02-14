package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.UserItemExample;
import org.loversAPP.model.UserItemKey;

public interface UserItemMapper {
    long countByExample(UserItemExample example);

    int deleteByExample(UserItemExample example);

    int deleteByPrimaryKey(UserItemKey key);

    int insert(UserItemKey record);

    int insertSelective(UserItemKey record);

    List<UserItemKey> selectByExample(UserItemExample example);

    int updateByExampleSelective(@Param("record") UserItemKey record, @Param("example") UserItemExample example);

    int updateByExample(@Param("record") UserItemKey record, @Param("example") UserItemExample example);
}