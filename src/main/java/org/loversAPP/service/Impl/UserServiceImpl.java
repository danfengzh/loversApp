package org.loversAPP.service.Impl;

import org.loversAPP.dao.UserMapper;
import org.loversAPP.model.User;
import org.loversAPP.model.UserExample;
import org.loversAPP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserMapper userMapper;

    public User getUserByID(Integer userID) {
        return userMapper.selectByPrimaryKey(userID);
    }

    public Integer getIDByPhoneAndPw(String phoneNumber,String Password) {

        UserExample userExample=new UserExample();
        userExample.createCriteria().andPhonenumberEqualTo(phoneNumber).andPasswordEqualTo(Password);
        List<User> user=  userMapper.selectByExample(userExample);
        if (user!=null&&user.size()==1) {
            return user.get(0).getId();
        } else {
            return -1;
        }

    }
    public Integer insertUser(User user) {

        return userMapper.insertSelective(user);
    }

    public Integer updatePwByID(Integer userID,String password) {
        User user=new User();
        user.setId(userID);
        user.setPassword(password);
        Integer res= userMapper.updateByPrimaryKey(user);
        return res;
    }

    public Integer updateAvatarByID(Integer userID,String avator) {
        User user=new User();
        user.setId(userID);
        user.setAvator(avator);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateSexByID(Integer userID, String sex) {
        return null;
    }

    private Integer updateUserInfo(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public Integer updateUserNameByID(Integer userID,String userName) {
        User user=new User();
        user.setId(userID);
        user.setUsername(userName);
        Integer res = updateUserInfo(user);
        return res;
    }

    public Integer getIDByInviteCode(String inviteCode) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andInvitecodeEqualTo(inviteCode);
        return userMapper.selectByExample(userExample).size();
    }

    public Integer deleteUserByID(Integer userID) {
        return userMapper.deleteByPrimaryKey(userID);
    }

    public List<User> getAllUsers() {

        return userMapper.getAllUsers();
    }

    @Override
    public Integer updateStepsTodayByID(Integer id, Integer stepsToday) {
        return null;
    }

    @Override
    public Integer updateLocationByID(Integer id, BigDecimal longtitude, BigDecimal latitude) {
        return null;
    }

    @Override
    public Integer updateWexIDByID(Integer userID, String wexID) {
        return null;
    }

    @Override
    public Integer updateQQByID(Integer userID, String qq) {
        return null;
    }

    @Override
    public Integer updateLevelByID(Integer userID, Integer level) {
        return null;
    }

    @Override
    public Integer updateStayus(Integer userId, Integer status) {
        return null;
    }

}
