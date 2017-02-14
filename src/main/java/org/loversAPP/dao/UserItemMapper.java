package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.UserItem;

public interface UserItemMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("itemId") Integer itemId);

    int insert(UserItem record);

    List<UserItem> selectAll();
}