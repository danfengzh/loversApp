package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.UserOneItem;
import org.loversAPP.model.UserOneItemExample;
import org.loversAPP.model.UserItem;

import java.util.List;

public interface UserOneItemMapper {
    long countByExample(UserOneItemExample example);

    int deleteByExample(UserOneItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserOneItem record);

    int insertSelective(UserOneItem record);

    List<UserOneItem> selectByExample(UserOneItemExample example);

    UserOneItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserOneItem record, @Param("example") UserOneItemExample example);

    int updateByExample(@Param("record") UserOneItem record, @Param("example") UserOneItemExample example);

    int updateByPrimaryKeySelective(UserOneItem record);

    int updateByPrimaryKey(UserOneItem record);

    int inserBathUserOneItem(@Param("userItems") List<UserItem> userItems);

    int maxIDu(@Param("userid") int userid,@Param("itemID") int itemID);

    int insertIntoUserOneItem(@Param("userOneItem") UserOneItem userOneItem);
}