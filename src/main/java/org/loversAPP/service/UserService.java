package org.loversAPP.service;

import org.loversAPP.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */
public interface UserService {

    public User getUserByID(Integer userID);


    public Integer getIDByPhoneAndPw(String phoneNumber ,String passWord);

    public Integer insertUser(User user);
    public User isExistUser(String userName,String phoneNumber);
    public Integer updatePwByID(Integer userID,String password);

    public Integer updateAvatarByID(Integer userID,String avator);
    public Integer updateSexByID(Integer userID,String sex);
    public Integer updateUserNameByID(Integer userID,String userName);

    public User getUserByInviteCode(String inviteCode);

    public Integer deleteUserByID(Integer userID);
    public Integer updateStepsTodayByID(Integer id,Integer stepsToday);
    public Integer updateLocationByID(Integer id, String longtitude ,String latitude);
    public Integer updateWexIDByID(Integer userID,String wexID );
    public Integer updateQQByID(Integer userID,String qq );
    public Integer updateLevelByID(Integer userID,Integer  level);
    public Integer updateStayus(Integer userId,Integer status);
    public Integer updateSignatureByID(Integer userId,String signature);
    public Integer updateCheckinDaysByID(Integer id,Integer checkinDays);
    public Integer updateAgeByID(Integer id,Integer age);
    public Integer updateHeightByID(Integer id,Integer height);
    public Integer updateWeightByID(Integer id,Integer weight);
    public Integer updateHobbyByID(Integer id,String weight);
    public Integer updateExpByID(Integer id,Integer exp);
    public Integer updateBimgByID(Integer id,String exp);
    List<User> getAllUsers();
    public Integer getMaxID();
}
