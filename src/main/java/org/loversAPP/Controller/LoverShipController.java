package org.loversAPP.Controller;

import org.loversAPP.AsyncTask.SendMessAgeThread;
import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.SuperLoverInfo;
import org.loversAPP.Jpush.JpushClientUtil;
import org.loversAPP.VO.MessAgeContent;
import org.loversAPP.model.LoverShip;
import org.loversAPP.model.User;
import org.loversAPP.model.UserCirCle;
import org.loversAPP.service.Impl.LoverSigninService;
import org.loversAPP.service.LoverShipService;
import org.loversAPP.service.UserCirCleService;
import org.loversAPP.service.UserService;
import org.loversAPP.utils.UniqueStringGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
@Controller
@RequestMapping("/loverShip")
public class LoverShipController extends BaseController{
    @Autowired
    private LoverShipService loverShipService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoverSigninService loverSigninService;
    @Autowired
    @Qualifier("taskExecutor")
    private TaskExecutor taskExecutor;
    @Autowired
    private UserCirCleService userCirCleService;
    /**
     *
     * @param loverAID 女生
     * @param loverBID 男生
     *
     * @param state
     * @return
     */
    @RequestMapping(value = "/insertLoverShip",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertLoverShip(@RequestParam("loverAID") Integer loverAID,@RequestParam("loverBID")Integer loverBID,
                                            @RequestParam("state") Integer state){
        FeedBack feedBack;
        LoverShip loverShip=new LoverShip();
        loverShip.setState(state);
        loverShip.setLovergirlid(loverAID);
        loverShip.setLoverboyid(loverBID);
        loverShip.setLoverid(UniqueStringGenerate.generateRandomStr(8));
        loverShip.setLovetime(new Date());
        int count=loverShipService.insertLoverShip(loverShip);
        if (count==1) {
            feedBack=new FeedBack("success","200");
        } else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }

    /**
     *
     * @param loverAID 任意
     * @return
     */
    @RequestMapping(value="/getloveIDByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> getloveIDByID(@RequestParam("loverAID") Integer loverAID){
        FeedBack<String> feedBack;
        String loverID =loverShipService.getloveIDByID(loverAID);
        if(loverID!=null){
            feedBack=new FeedBack("success","200",loverID);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getLoverShipByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<LoverShip> getLoverShipByID(@RequestParam("loverID") String loverID){
        FeedBack<LoverShip> feedBack;
        LoverShip loverShip=  loverShipService.getLoverShipByID(loverID);
        if(loverShip!=null){
            feedBack=new FeedBack("success","200",loverShip);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getAllLoveShips",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<SuperLoverInfo> getAllLoveShips(){

        FeedBack<SuperLoverInfo> feedBack;
        List<SuperLoverInfo> loverShip=  loverShipService.getAllSuperLoverInfo();
        if(loverShip!=null){
            feedBack=new FeedBack("success","200",loverShip);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }

    /**
     *   解除恋爱关系
     *   1.用户双方status 都变为0
     2.Activityrecord 跟loveship表 删除
     * @param loverID
     * @return
     */
    @RequestMapping(value = "/deleteLoveShipByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> deleteLoveShipByID(@RequestParam("loverID") String loverID){
        FeedBack<String> feedBack;
        int count= loverShipService.deleteLoveShipByID(loverID);
        if (count==1) {
            feedBack=new FeedBack("success","200");
        } else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/updateLoveIndexByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateLoveIndexByID(@RequestParam("loverID") String loverID,@RequestParam("loveIndex") Integer loveIndex){
        FeedBack<Integer> feedBack;
        Integer count=  loverShipService.updateLoveIndexByID(loverID,loveIndex);
        if (count==1) {
            feedBack=new FeedBack("success","200",loveIndex);
        } else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/updateStateByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateStateByID(@RequestParam("loverID") String loverID,@RequestParam("state") Integer state){
        FeedBack<Integer> feedBack;
        Integer count=  loverShipService.updateStateByID(loverID,state);
        if (count==1) {
            feedBack=new FeedBack("success","200",state);
        } else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }

    /**
     *
     * @param loverAID 任意一方id
     * @return
     */
    @RequestMapping(value = "/getHalfByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Map> getHalfByID(@RequestParam("loverAID") Integer loverAID){
        FeedBack<Map> feedBack;
        //User tempUser=new User();
        User U= loverShipService.getHalfByID(loverAID);
//        tempUser.setId(U.getId());
//        tempUser.setUsername(U.getUsername());
//        tempUser.setAvator(U.getAvator());
//        tempUser.setSignature(U.getSignature());
        Map tempUser=new HashMap();
        tempUser.put("id",U.getId());
        tempUser.put("username",U.getUsername());
        tempUser.put("avator",U.getAvator());
        tempUser.put("checkindays",U.getCheckindays());
        tempUser.put("latitude",U.getLatitude());
        tempUser.put("longtitude",U.getLongtitude());
        tempUser.put("stepstoday",U.getStepstoday());
        tempUser.put("sex",U.getSex());
        if(U!=null){
            feedBack=new FeedBack("success","200",tempUser);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }

    /**
     *
     * @param halfID
     * @return
     */
    @RequestMapping(value = "insertLoverSignin",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertLoverSignin(@RequestParam("halfID") Integer halfID){
        FeedBack feedBack=   loverSigninService.insertLoverSignin(halfID);
        return feedBack;
    }

    /**
     *
     * @param loverID
     * @return
     */
    @RequestMapping(value = "cancelLoveShip",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> cancelLoveShip(@RequestParam("loverID") String loverID){
        FeedBack<String> feedBack;
        LoverShip loverShip=  loverShipService.getLoverShipByID(loverID);
        User boy=userService.getUserByID(loverShip.getLoverboyid());
        User girl=userService.getUserByID(loverShip.getLovergirlid());
        int res= loverShipService.cancelLoveShip(loverID);

        String  message="你和恋人已经解除恋爱关系";
        MessAgeContent messAgeContent=new MessAgeContent();
        messAgeContent.setAlias(String.valueOf(boy.getId()));
        messAgeContent.setStatus(String.valueOf(boy.getStauts()));
        messAgeContent.setContent(message);
        MessAgeContent girlmesscontent=new MessAgeContent();
        girlmesscontent.setAlias(String.valueOf(girl.getId()));
        girlmesscontent.setStatus(String.valueOf(girl.getStauts()));
        girlmesscontent.setContent(message);
        if(res==1){
            taskExecutor.execute(new SendMessAgeThread(messAgeContent));
            taskExecutor.execute(new SendMessAgeThread(girlmesscontent));
            feedBack =new FeedBack("success","200");
        }else {
            feedBack =new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "becomeLover",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> becomeLover(@RequestParam("userID") final int userID,
                                        @RequestParam("receiverID") final int  receiverID,
                                        @RequestParam("latitude") String latitude,
                                        @RequestParam("longtitude") String longtitude){
//        UserCirCle userCirCle=new UserCirCle();
//        userCirCle.setLatitude(latitude);
//        userCirCle.setLongtitude(longtitude);
//        userCirCle.setUserID(userID);
//        userCirCleService.insertUserCirCle(userCirCle);
        User user=new User();
        user.setId(userID);
        user.setStauts(2);
        user.setExp(0);
        user.setStepstoday(0);
        user.setMoney(0);
        user.setExp(0);
        User another=new User();
        another.setId(receiverID);
        another.setStauts(2);
        another.setExp(0);
        another.setStepstoday(0);
        another.setMoney(0);
        another.setExp(0);
        userService.updateUserInfoSelective(user);
        userService.updateUserInfoSelective(another);
        taskExecutor.execute(new Runnable() {
            public void run() {
                JpushClientUtil.sendDynatic(String.valueOf(userID),"0","恭喜你摆脱单身","系统消息","恭喜你摆脱单身","tips");
                JpushClientUtil.sendDynatic(String.valueOf(receiverID),"0","恭喜你摆脱单身","系统消息","恭喜你摆脱单身","tips");
            }
        });
        return new FeedBack<String>("success","200");
    }
}
