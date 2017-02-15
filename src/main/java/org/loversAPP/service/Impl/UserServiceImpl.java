//package org.loversAPP.service.Impl;
//
//import org.loversAPP.dao.UserMapper;
//import org.loversAPP.model.User;
//import org.loversAPP.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import tk.mybatis.mapper.entity.Example;
//
//import java.util.List;
///**
// * Created by Administrator on 2017/2/15.
// */
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserMapper userMapper;
//
//    public User getUserByID(Integer userID) {
//        return userMapper.selectByPrimaryKey(userID);
//    }
//
//    public Integer getIDByPhoneAndPw(String phoneNumber,String Password) {
//
//        Example userExample=new Example(User.class);
//        userExample.selectProperties("id");
//        userExample.createCriteria().andEqualTo("phonenumber",phoneNumber).andEqualTo("password",Password);
//
//         return null;
//
//    }
//    public Integer insertUser(User user) {
//        return userMapper.insertSelective(user);
//    }
//
//    public Integer updatePwByID(Integer userID) {
//        return null;
//    }
//
//    public Integer updateAvatarByID(Integer userID) {
//        return null;
//    }
//
//    public Integer updateUserNameByID(Integer userID) {
//        return null;
//    }
//
//    public Integer getIDByInviteCode(String inviteCode) {
//        return null;
//    }
//
//    public Integer deleteUserByID(Integer userID) {
//        return null;
//    }
//
//    public List<User> getAllUsers() {
//        return null;
//    }
//}
