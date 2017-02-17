package org.loversAPP.service;

import org.loversAPP.model.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */
public interface UserService {

    public User getUserByID(Integer userID);


    public Integer getIDByPhoneAndPw(String phoneNumber ,String passWord);

    public Integer insertUser(User user);

    public Integer updatePwByID(Integer userID,String password);

    public Integer updateAvatarByID(Integer userID,String avator);
    public Integer updateSexByID(Integer userID,String sex);
    public Integer updateUserNameByID(Integer userID,String userName);

    public Integer getIDByInviteCode(String inviteCode);

    public Integer deleteUserByID(Integer userID);
    public Integer updateStepsTodayByID(Integer id,Integer stepsToday);
    public Integer updateLocationByID(Integer id, BigDecimal longtitude ,BigDecimal latitude);
    public Integer updateWexIDByID(Integer userID,String wexID );
    public Integer updateQQByID(Integer userID,String qq );
    public Integer updateLevelByID(Integer userID,Integer  level);
    public Integer updateStayus(Integer userId,Integer status);
    List<User> getAllUsers();
}
