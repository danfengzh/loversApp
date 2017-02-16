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

    public Integer updatePwByID(Integer userID,String password);

    public Integer updateAvatarByID(Integer userID,String avator);

    public Integer updateUserNameByID(Integer userID,String userName);

    public Integer getIDByInviteCode(String inviteCode);

    public Integer deleteUserByID(Integer userID);

    List<User> getAllUsers();
}
