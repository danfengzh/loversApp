package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.model.LoverShip;
import org.loversAPP.model.User;
import org.loversAPP.service.LoverShipService;
import org.loversAPP.service.UserService;
import org.loversAPP.utils.UniqueStringGenerate;
import org.springframework.beans.factory.annotation.Autowired;
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
            feedBack=new FeedBack<>("success","200",loverID);
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
    public FeedBack<LoverShip> getAllLoveShips(){

        FeedBack<LoverShip> feedBack;
        List<LoverShip> loverShip=  loverShipService.getAllLoveShips();
        if(loverShip!=null){
            feedBack=new FeedBack("failure","400",loverShip);
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
           feedBack=new FeedBack<>("success","200");
        } else {
            feedBack=new FeedBack<>("failure","400");
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
     * @param loverID loverID
     * @return
     */
    @RequestMapping(value = "/getHalfByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Map> getHalfByID(@RequestParam("loverAID") Integer loverAID,@RequestParam("loverID") String loverID){

        FeedBack<Map> feedBack;
        //User tempUser=new User();
        User U= loverShipService.getHalfByID(loverID,loverAID);
//        tempUser.setId(U.getId());
//        tempUser.setUsername(U.getUsername());
//        tempUser.setAvator(U.getAvator());
//        tempUser.setSignature(U.getSignature());
        Map tempUser=new HashMap();
        tempUser.put("id",U.getId());
        tempUser.put("username",U.getUsername());
        tempUser.put("avator",U.getAvator());
        if(U!=null){
            feedBack=new FeedBack<>("200","success",tempUser);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/MyTest/Demo",method = RequestMethod.GET,produces ="application/json;charset=utf-8")
    @ResponseBody
    public User demo(){
        User user=new User();
        user.setStauts(0);
        user.setUsername("孟烨");
        user.setSex("女");
        user.setHobby("睡觉 吃饭");
        return user;
    }
}
