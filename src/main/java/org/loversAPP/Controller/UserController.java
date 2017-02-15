//package org.loversAPP.Controller;
//
//import org.loversAPP.DTO.FeedBack;
//import org.loversAPP.model.User;
//import org.loversAPP.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
///**
// * Created by Administrator on 2017/2/15.
// */
//@Controller
//@RequestMapping("/User")
//public class UserController {
//    @Autowired
//    private UserService userService;
//    @RequestMapping(value = "getUserByID",method = RequestMethod.POST)
//    public FeedBack<User> getUserByID(Integer userID){
//        FeedBack<User> feedBack;
//        User user=  userService.getUserByID(userID);
//        if(user!=null){
//            feedBack= new FeedBack<User>("查询成功","200",user);
//        }
//        else {
//            feedBack= new FeedBack<User>("查询失败，不存在该用户","200",user);
//        }
//
//        return feedBack;
//    }
//    //
//    public  String getUserByID(){
//          return null;
//    }
//
//}
