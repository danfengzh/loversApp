package org.loversAPP.Controller;

import org.loversAPP.DTO.FeedBack;
import org.loversAPP.model.LoverShip;
import org.loversAPP.model.User;
import org.loversAPP.service.LoverShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/2/20.
 */
@Controller("/loverShip")
public class LoverShipController {
    @Autowired
    private LoverShipService loverShipService;

    /**
     *
     * @param loverAID 女生
     * @param loverBID 男生
     * @param loveTime
     * @param state
     * @return
     */
    @RequestMapping(value = "/insertLoverShip",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertLoverShip(@RequestParam("loverAID") Integer loverAID,@RequestParam("loverBID")Integer loverBID,@RequestParam("loveTime") Date loveTime ,
                                            @RequestParam("state") Integer state){
        FeedBack feedBack;
        LoverShip loverShip=new LoverShip();
        loverShip.setState(state);
        loverShip.setLovergirlid(loverAID);
        loverShip.setLoverboyid(loverBID);
        loverShip.setLoverid(UUID.randomUUID().toString());
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
    public FeedBack<LoverShip> getLoverShipByID(@RequestParam("loverAID") String loverAID){
        FeedBack<LoverShip> feedBack;
        LoverShip loverShip=  loverShipService.getLoverShipByID(loverAID);
        if(loverShip!=null){
            feedBack=new FeedBack("failure","400",loverShip);
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
    public FeedBack<LoverShip> deleteLoveShipByID(@RequestParam("loverAID") String loverID){

        return null;
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
    public FeedBack<User> getHalfByID(@RequestParam("loverAID") Integer loverAID,@RequestParam("loverID") String loverID){

        FeedBack<User> feedBack;
        User U= loverShipService.getHalfByID(loverID,loverAID);
        if(U!=null){
            feedBack=new FeedBack<>("","",U);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }

}
