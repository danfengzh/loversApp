package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.UserItem;
import org.loversAPP.model.UserItemExample;

public interface UserItemMapper {
    long countByExample(UserItemExample example);

    int deleteByExample(UserItemExample example);

    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("itemId") Integer itemId);

    int insert(UserItem record);

    int insertSelective(UserItem record);

    List<UserItem> selectByExample(UserItemExample example);

    int updateByExampleSelective(@Param("record") UserItem record, @Param("example") UserItemExample example);

    int updateByExample(@Param("record") UserItem record, @Param("example") UserItemExample example);
}