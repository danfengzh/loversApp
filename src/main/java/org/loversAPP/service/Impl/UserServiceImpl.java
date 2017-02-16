package org.loversAPP.service.Impl;

import org.loversAPP.dao.UserMapper;
import org.loversAPP.model.User;
import org.loversAPP.model.UserExample;
import org.loversAPP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by Administrator on 2017/2/15.
 */
@Service
public class UserServiceImpl implements UserService {
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

    private Integer updateUserInfo(User user) {
        return userMapper.updateByPrimaryKey(user);
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
}
