package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.Controller.utils.ControllerConstant;
import org.loversAPP.Controller.utils.InviteCodeCreator;
import org.loversAPP.Controller.utils.fileUpload;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.model.User;
import org.loversAPP.service.UserService;
import org.loversAPP.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */
@Controller
@RequestMapping("/User")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    /**
     * 根据用户id查询用户个人信息
     * @param userID
     * @return
     */

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

    /**
     * 根据电话号码和密码查询用户id
     * @param phoneNumber
     * @param passWord
     * @return
     */

    @RequestMapping(value = "getIDByPhoneAndPw",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> getIDByPhoneAndPw(String phoneNumber ,String passWord){
        Integer res= userService.getIDByPhoneAndPw(phoneNumber,passWord);
        FeedBack<Integer> feedBack;

        feedBack=new FeedBack<Integer>(FeedBack.OK_STR,"200",res);
        return feedBack;
    }

    /**
     * 查询所有的用户
     * @return
     */

    @RequestMapping(value = "getAllUsers",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<List<User>> getAllUsers(){

        FeedBack<List<User>> feedBack;
        List<User> users=userService.getAllUsers();
        feedBack=new FeedBack(FeedBack.OK_STR,"200",users);
        return feedBack;
    }
    /**
     * 增加用户
     * @return
     */

    @RequestMapping(value = "insertUser",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public  FeedBack<String> insertUser(User user){
        FeedBack<String> feedBack;
        //记得对用户的密码进行加密
        String md5pass=  MD5Utils.getMd5(user.getPassword());
        String inviteCode=InviteCodeCreator.createRandom(true,6);
        user.setPassword(md5pass);
        user.setInvitecode(inviteCode);
        Integer count= userService.insertUser(user);
        if(count==1){
            feedBack=new FeedBack("OK","200");
        }
        else {
            feedBack=new FeedBack("FAILURE","500");
        }
        return feedBack;
    }

    /**
     * 根据用户id更新密码
     * @param id
     * @param password
     * @return
     */

    @RequestMapping(value ="updatePwByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updatePwByID(Integer id,String password){
        FeedBack<String> feedBack;
        //对用户密码进行更新之后在进行插入
        String md5Pass= MD5Utils.getMd5(password);
        int count=  userService.updatePwByID(id,md5Pass);
        if(count==1){
            feedBack=new FeedBack<String>("success","100",md5Pass);
        }
        else {
            feedBack=new FeedBack<String>("FAILURE","500");
        }
        return feedBack;
    }

    /**
     *
     * @param avatar  用户头像文件流
     * @param id  用户id
     * @return
     */

    @RequestMapping(value ="updateAvatarByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateAvatarByID(MultipartFile avatar , Integer id){
        FeedBack<String> feedBack;
        //对文件进行保存处理
        String avatorPath=getMessage(ControllerConstant.userAvatorPath);
        User user=userService.getUserByID(id);
        File filePresious=new File(request.getSession().getServletContext().getRealPath(File.separator)+"/"+user.getAvator());
        if(filePresious.exists()){
            filePresious.delete();
        }
        String newAvatorpath= fileUpload.tacleUpload(avatar,avatorPath,request,user.getPhonenumber());
        int count=userService.updateAvatarByID(id,newAvatorpath);
        if (count==1) {
            feedBack=new FeedBack<String>("success","200",newAvatorpath);
        } else {
            feedBack=new FeedBack<String>("failure","500");
        }
        return feedBack;
    }

    @RequestMapping(value ="updateUserNameByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateUserNameByID(Integer id,String userName){
        FeedBack<String> feedBack;
        int count= userService.updateUserNameByID(id,userName);
        if(count==1){
            feedBack=new FeedBack<>("success","200",userName);
        }
        else {
            feedBack=new FeedBack<>("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value ="getIDByInviteCode",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> getIDByInviteCode(String inviteCode){
        FeedBack<Integer> feedBack;
        Integer id=   userService.getIDByInviteCode(inviteCode);
        if(id!=null){
            feedBack=new FeedBack<>("success","200",id);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }

    /**
     * 删除用户的时候需要将和该用户有关的信息都进行删除
     *  1.解除恋爱关系---也就是删除lover_ship关系--附加删除activity_records
     *  2.删除道具信息
     *  3.删除宝藏信息
     *  4.删除dig_history
     *
     * @param userID
     * @return
     */
    @RequestMapping(value ="deleteUserByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> deleteUserByID(@RequestParam("userID") Integer userID){
        FeedBack<String> feedBack;
        Integer count=userService.deleteUserByID(userID);
        if(count==1){
            feedBack=new FeedBack<>("success","200");
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateSexByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateSexByID(Integer id,String sex){
        FeedBack<String> feedBack;
        Integer count=userService.updateSexByID(id,sex);
        if(count==1){
            feedBack=new FeedBack<>("success","200");
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateSignatureByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateSignatureByID(Integer id,String signature){
        FeedBack<String> feedBack;
        Integer count=userService.updateSignatureByID(id,signature);
        if(count==1){
            feedBack=new FeedBack<>("success","200",signature);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateSignatureByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateSignatureByID(Integer id,Integer stepsToday){
        FeedBack<Integer> feedBack;
        Integer count=userService.updateStepsTodayByID(id,stepsToday);
        if(count==1){
            feedBack=new FeedBack<>("success","200",stepsToday);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }

    @RequestMapping(value ="updateLocationByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateStepsTodayByID(Integer id, BigDecimal longtitude , BigDecimal latitude){
        FeedBack<Integer> feedBack;
        class location {
            Integer longtitud;
            Integer latitud;

            public Integer getLongtitud() {
                return longtitud;
            }

            public void setLongtitud(Integer longtitud) {
                this.longtitud = longtitud;
            }

            public Integer getLatitud() {
                return latitud;
            }

            public void setLatitud(Integer latitud) {
                this.latitud = latitud;
            }

            public location(Integer longtitud, Integer latitud) {
                this.longtitud = longtitud;
                this.latitud = latitud;
            }
        }
        Integer count=userService.updateLocationByID(id,longtitude,latitude);
        if(count==1){
            feedBack=new FeedBack<>("success","200");
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }

    @RequestMapping(value ="updateWexIDByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateWexIDByID(Integer id,String wexID ){
        FeedBack<String> feedBack;
        int count= userService.updateWexIDByID(id,wexID);
        if(count==1){
            feedBack=new FeedBack<>("success","200",wexID);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateQQByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateQQByID(Integer id,String qq ){
        FeedBack<String> feedBack;
        int count= userService.updateQQByID(id,qq);
        if(count==1){
            feedBack=new FeedBack<>("success","200",qq);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateLevelByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateLevelByID(Integer id,Integer level ){
        FeedBack<Integer> feedBack;
        int count= userService.updateLevelByID(id,level);
        if(count==1){
            feedBack=new FeedBack<>("success","200",level);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateStatusByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateStatusByID(Integer id,Integer status ){
        FeedBack<Integer> feedBack;
        int count= userService.updateStayus(id,status);
        if(count==1){
            feedBack=new FeedBack<>("success","200",status);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateCheckinDaysByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateCheckinDaysByID(Integer id,Integer checkinDays ){
        FeedBack<Integer> feedBack;
        int count= userService.updateCheckinDaysByID(id,checkinDays);
        if(count==1){
            feedBack=new FeedBack<>("success","200",checkinDays);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateAgeByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateAgeByID(Integer id,Integer age ){
        FeedBack<Integer> feedBack;
        int count= userService.updateAgeByID(id,age);
        if(count==1){
            feedBack=new FeedBack<>("success","200",age);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateHeightByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateHeightByID(Integer id,Integer height ){
        FeedBack<Integer> feedBack;
        int count= userService.updateHeightByID(id,height);
        if(count==1){
            feedBack=new FeedBack<>("success","200",height);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateWeightByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateWeightByID(Integer id,Integer weight ){
        FeedBack<Integer> feedBack;
        int count= userService.updateWeightByID(id,weight);
        if(count==1){
            feedBack=new FeedBack<>("success","200",weight);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateHobbyByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateHobbyByID(Integer id,String hobby ){
        FeedBack<String> feedBack;
        int count= userService.updateHobbyByID(id,hobby);
        if(count==1){
            feedBack=new FeedBack<>("success","200",hobby);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateExpByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateExpByID(Integer id,Integer  exp ){
        FeedBack<Integer> feedBack;
        int count= userService.updateExpByID(id,exp);
        if(count==1){
            feedBack=new FeedBack<>("success","200",exp);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateBimgByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateBimgByID(Integer id,String backImage ){
        FeedBack<String> feedBack;
        int count= userService.updateBimgByID(id,backImage);
        if(count==1){
            feedBack=new FeedBack<>("success","200",backImage);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
}
