package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.UserItem;
import org.loversAPP.model.UserItemExample;

import java.util.List;

public interface UserItemMapper {
    long countByExample(UserItemExample example);

    int deleteByExample(UserItemExample example);

    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("itemId") Integer itemId);

    int insert(UserItem record);

    int insertSelective(UserItem record);

    List<UserItem> selectByExample(UserItemExample example);

    int updateByExampleSelective(@Param("record") UserItem record, @Param("example") UserItemExample example);

    int updateByExample(@Param("record") UserItem record, @Param("example") UserItemExample example);

    UserItem getUserItemByID(@Param("id") int id);

    UserItem getSpeicUseritembY(@Param("userid") int userid, @Param("itemID") int itemID);

    int updateUserItemBindItemIDCount(@Param("userID") Integer userID,@Param("itemId") int itemId,@Param("count") int count);
}