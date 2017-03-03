package org.loversAPP.model.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.Test.model.Friend;
import org.loversAPP.Test.model.FriendExample;

import java.util.List;

public interface FriendMapper {
    long countByExample(FriendExample example);

    int deleteByExample(FriendExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("userid") Integer userid, @Param("friendid") Integer friendid);

    int insert(Friend record);

    int insertSelective(Friend record);

    List<Friend> selectByExample(FriendExample example);

    int updateByExampleSelective(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByExample(@Param("record") Friend record, @Param("example") FriendExample example);
}