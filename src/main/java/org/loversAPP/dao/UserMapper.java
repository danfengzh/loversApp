package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.DTO.PositionUser;
import org.loversAPP.DTO.UserDistance;
import org.loversAPP.DTO.location;
import org.loversAPP.DTO.StepToday;
import org.loversAPP.model.User;
import org.loversAPP.model.UserExample;

import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<User> getAllUsers();
    User getUserByUserNameOrPass(@Param("username") String username,@Param("phoneNum")String phoneNum);
    Integer getMaxID();
    String getInviteCodeByID(@Param("id") Integer id);

    List<UserDistance> getAllUserDistances();

    List<PositionUser> getAllPositionUsers();

    List<User> searchUserByName(@Param("username") String username);

    int insertLocation(@Param("userID") int userID, @Param("latitude") String latitude,@Param("longtitude") String longtitude);

    location getLocationByiD(@Param("userid") int userid);

    int deleteLocByID(@Param("userid")int userid);

    int insertSingleSign(@Param("userID")int userID,@Param("signDate") String signDate);

    int getSignCount(@Param("userid") int userid, @Param("signDate") String signDate);

    Integer upDateSignTodayByUserID(@Param("userID") int userID,@Param("date") String date,@Param("steps") int steps);

    StepToday getTodySteps(@Param("userID") int userID, @Param("day") String day);

    Integer upDateSignInfo(@Param("userID") int userID,@Param("todayStr") String todayStr, @Param("steps") int steps);

    int insertSignToday(@Param("stepToday") StepToday stepToday);
}