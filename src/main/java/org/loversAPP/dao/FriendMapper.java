package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.DTO.CarePeople;
import org.loversAPP.DTO.FriendShip;
import org.loversAPP.DTO.TinyUser;
import org.loversAPP.model.Friend;
import org.loversAPP.model.FriendExample;

import java.util.List;

public interface FriendMapper {
    long countByExample(FriendExample example);

    int deleteByExample(FriendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Friend record);

    int insertSelective(Friend record);

    List<Friend> selectByExample(FriendExample example);

    Friend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByExample(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);
    FriendShip getFriendsByUID(@Param("userID") Integer userID);

    List<TinyUser> getAllTinyUser(Integer id);
    public int selectIsFollowed(@Param("userid") Integer userid,@Param("friendID")Integer friendID);

    int  getAllFollersCount(@Param("userid")Integer userid);

    List<CarePeople> getCarePeoples(@Param("friendID") int friendID);
}