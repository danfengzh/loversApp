package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.Controller.utils.ControllerConstant;
import org.loversAPP.Controller.utils.fileUpload;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.model.User;
import org.loversAPP.service.UserService;
import org.loversAPP.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
        user.setPassword(md5pass);
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
     * @param id
     * @return
     */
    @RequestMapping(value ="deleteUserByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> deleteUserByID(Integer id){
        FeedBack<String> feedBack;
       Integer count=userService.deleteUserByID(id);
       if(count==1){
           feedBack=new FeedBack<>("success","200");
       }
       else {
           feedBack=new FeedBack<>("failure","500");
       }
       return feedBack;
    }
}
