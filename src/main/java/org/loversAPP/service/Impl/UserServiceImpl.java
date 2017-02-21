package org.loversAPP.service.Impl;

import org.loversAPP.dao.UserMapper;
import org.loversAPP.model.User;
import org.loversAPP.model.UserExample;
import org.loversAPP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Integer res= userMapper.updateByPrimaryKeySelective(user);
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

        User user=new User();
        user.setId(userID);
        user.setSex(sex);
        Integer res = updateUserInfo(user);
        return res;
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
        return userMapper.selectByExample(userExample).get(0).getId();
    }

    public Integer deleteUserByID(Integer userID) {
        return userMapper.deleteByPrimaryKey(userID);
    }

    public List<User> getAllUsers() {

        return userMapper.getAllUsers();
    }

    @Override
    public Integer updateStepsTodayByID(Integer id, Integer stepsToday) {
        User user=new User();
        user.setId(id);
        user.setStepstoday(stepsToday);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
        public Integer updateLocationByID(Integer id, String longtitude, String latitude) {
        User user=new User();
        user.setId(id);
        user.setLongtitude(longtitude);
        user.setLatitude(latitude);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateWexIDByID(Integer userID, String wexID) {
        User user=new User();
        user.setId(userID);
        user.setWexid(wexID);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateQQByID(Integer userID, String qq) {
        User user=new User();
        user.setId(userID);
        user.setQq(qq);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateLevelByID(Integer userID, Integer level) {
        User user=new User();
        user.setId(userID);
        user.setLevel(level);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateStayus(Integer userId, Integer status) {
        User user=new User();
        user.setId(userId);
        user.setStauts(status);
        Integer res = updateUserInfo(user);
        return res;
    }

    public Integer updateSignatureByID(Integer userId, String signature) {
        User user=new User();
        user.setId(userId);
        user.setSignature(signature);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateCheckinDaysByID(Integer id, Integer checkinDays) {
        User user=new User();
        user.setId(id);
        user.setCheckindays(checkinDays);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateAgeByID(Integer id, Integer age) {
        User user=new User();
        user.setId(id);
        user.setAge(age);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateHeightByID(Integer id, Integer height) {
        User user=new User();
        user.setId(id);
        user.setHeight(height);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateWeightByID(Integer id, Integer weight) {
        User user=new User();
        user.setId(id);
        user.setWeight(weight);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateHobbyByID(Integer id, String hobby) {
        User user=new User();
        user.setId(id);
        user.setHobby(hobby);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateExpByID(Integer id, Integer exp) {
        User user=new User();
        user.setId(id);
        user.setExp(exp);
        Integer res = updateUserInfo(user);
        return res;
    }

    @Override
    public Integer updateBimgByID(Integer id, String back) {
        User user=new User();
        user.setId(id);
        user.setBackimage(back);
        Integer res = updateUserInfo(user);
        return res;
    }
}
