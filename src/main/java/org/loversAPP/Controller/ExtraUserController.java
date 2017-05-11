package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.Controller.utils.DateUtil;
import org.loversAPP.Controller.utils.MapCalculator;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.PositionUser;
import org.loversAPP.DTO.UserDistance;
import org.loversAPP.DTO.location;
import org.loversAPP.DTO.StepToday;
import org.loversAPP.model.User;
import org.loversAPP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
@Controller
@RequestMapping("/Extra/user")
public class ExtraUserController  extends BaseController {
    @Autowired
    private UserService userService;
    /**
     * 返回距离圈子点最近的top 100的用户
     * @param latitude
     * @param longtitude
     * @return
     */
    @RequestMapping(value ="getUserOrderByDistance",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<UserDistance> getUserOrderByDistance(@RequestParam("latitude") String latitude ,
                                                         @RequestParam("longtitude")String longtitude){
        FeedBack feedBack;
        //1 .获取所有的用户 将
        List<PositionUser> positionUsers= userService.getAllPositionUsers();
        List<UserDistance> userDistanceList=new ArrayList<UserDistance>();
        //计算距离
        for(PositionUser positionUser:positionUsers){
            UserDistance userDistance=new UserDistance();
            double dist= MapCalculator.getDistance(latitude,longtitude,positionUser.getLatitude(),positionUser.getLongtitude());
            userDistance.setDistance(dist);
            userDistance.setUserID(positionUser.getId());
            userDistance.setAvatar(positionUser.getAvatar());
            userDistance.setSex(positionUser.getSex());
            userDistanceList.add(userDistance);
        }
        System.out.println("**********************");
        Collections.sort(userDistanceList);
        //取出前 100个
        if(userDistanceList.size()<=100){
            feedBack=new FeedBack("success","200",userDistanceList);
        }
        else {
            feedBack=new FeedBack("success","200",userDistanceList.subList(0,100));
        }
        return feedBack;
    }
    @RequestMapping(value ="searchUserByName",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<User> searchUserByName(@RequestParam("username") String username){
        FeedBack feedBack;
        List<User> users=   userService.searchUserByName(username);
        if(users!=null){
            feedBack=new FeedBack("success","200",users);
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value ="insertLocation",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertLocation(int userID ,String latitude,String longtitude){
        FeedBack  feedBack;
        int cos=userService.insertLocation(userID,latitude,longtitude);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value ="getLocByUID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<location> getLocByUID(@RequestParam("userID") int userID){
        FeedBack  feedBack;
        location location= userService.getLocatonByID(userID);
        if(location!=null){
            feedBack=new FeedBack("success","200",location);
        }
        else {
            feedBack=new FeedBack("failure","400",location);
        }
        return feedBack;
    }
    @RequestMapping(value ="deleteLocByUID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack deleteLocByUID(@RequestParam("userID") int userID){
        FeedBack  feedBack;
        int  cos= userService.delectLocByID(userID);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value ="insertSingleSign",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertSingleSign(@RequestParam("userID") int userID){
        FeedBack feedBack;
        int count=userService.getSignCount(userID, DateUtil.getDay());
        if(count!=0){
            feedBack=new FeedBack("failure","201");
        }
        else {
            userService.insertSingleSign(userID);
            feedBack=new FeedBack("success","200");
        }
        return feedBack;
    }

    /**
     *(检测调用当前接口的日期是否在今天，
     * 如果是，更新数据库中的steps=传参的steps+数据库的steps，
     * 若不是，则用当前日期覆盖数据库中日期，并用当前steps覆盖数据库中的steps)

     * @param userID
     * @param date
     * @param steps
     * @return
     */
    @RequestMapping(value ="updateSteps",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateSteps(int userID,String date,int steps){
        FeedBack feedBack=null;
        StepToday CurstepToday= userService.getSteps(userID,null);
        String todayStr=DateUtil.getDay();
        //查询之前的步数
        if(todayStr.equals(date)){
            userService.updateSteps(userID,date,steps+CurstepToday.getStepsToday());
            feedBack=new FeedBack("success","200",steps+CurstepToday.getStepsToday());
        }else {
            userService.upDateSignInfo(userID,todayStr,steps);
            feedBack=new FeedBack("success","200",steps);
        }
        return feedBack;
    }
    @RequestMapping(value ="getSteps",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<StepToday> getSteps(int userID){
        FeedBack feedBack=null;
        StepToday stepToday= userService.getSteps(userID,null);
        feedBack=new FeedBack("success","200",stepToday);
        return feedBack;
    }
    @RequestMapping(value ="insertSteps",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String>  insertSteps(int userID,int status){

        userService.insertSignToday(userID,status);
        return new FeedBack<String>("success","200");
    }

}
