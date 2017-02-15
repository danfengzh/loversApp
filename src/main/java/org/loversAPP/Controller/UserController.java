package org.loversAPP.Controller;

import org.loversAPP.DTO.FeedBack;
import org.loversAPP.model.User;
import org.loversAPP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */
@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "getUserByID",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<User> getUserByID(Integer userID){
        FeedBack<User> feedBack;
        User user=  userService.getUserByID(userID);
        if(user!=null){
            feedBack= new FeedBack<User>("查询成功","200",user);
        }
        else {
            feedBack= new FeedBack<User>("查询失败，不存在该用户","200",user);
        }

        return feedBack;
    }
    @RequestMapping(value = "getIDByPhoneAndPw",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> getIDByPhoneAndPw(String phoneNumber ,String passWord){
       Integer res= userService.getIDByPhoneAndPw(phoneNumber,passWord);
        FeedBack<Integer> feedBack;

           feedBack=new FeedBack<Integer>(FeedBack.OK_STR,"200",res);
        return feedBack;
    }

    @RequestMapping(value = "getAllUsers",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<List<User>> getAllUsers(){

        FeedBack<List<User>> feedBack;
       List<User> users=userService.getAllUsers();
        feedBack=new FeedBack(FeedBack.OK_STR,"200",users);
        return feedBack;
    }
    /**
     * 利用第二种方式来生成符合要求的json数据
     * @return
     */
    @RequestMapping(value = "insertUser",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public  FeedBack<String> insertUser(User user){
          FeedBack<String> feedBack;
          Integer count= userService.insertUser(user);
          if(count==1){
            feedBack=new FeedBack("OK","200");
          }
          else {
              feedBack=new FeedBack("FAILURE","200");
          }
          return feedBack;
    }

}
