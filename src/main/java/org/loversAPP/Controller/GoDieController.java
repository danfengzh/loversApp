package org.loversAPP.Controller;

import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.GoDieFeeBack;
import org.loversAPP.Jpush.JpushClientUtil;
import org.loversAPP.SheduleTask.SheduleTaskForDeteGoDie;
import org.loversAPP.SheduleTask.SheduleTaskForDogHead;
import org.loversAPP.model.*;
import org.loversAPP.service.*;
import org.omg.CORBA.PUBLIC_MEMBER;
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
import java.util.Map;


/**
 * Created by Administrator on 2017/3/31.
 */
@Controller
@RequestMapping("/GoDie")
public class GoDieController {
    @Autowired
    private GoDieService goDieService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;
    @Autowired
    private messageService messageService;
    @Autowired
    @Qualifier("taskExecutor")
    private TaskExecutor taskExecutor;
    @Autowired
    private LoverDogService  loverDogService;
    @Autowired
    private MomentService momentService;
    @Autowired
    private LoverShipService loverShipService;
    @Autowired
    private  DoolePhotoService doolePhotoService;
    @Autowired
    private SheduleTaskForDogHead sheduleTaskForDogHead;
    @Autowired
    private SheduleTaskForDeteGoDie sheduleTaskForDeteGoDie;
    @RequestMapping(value = "/getDogActByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public Map getDogActByID(int userID){
        Map map=new HashMap();
        GoDieFeeBack goDieFeeBack=goDieService.getGoDieFeedBackByID(userID);

        if(goDieFeeBack!=null&&goDieFeeBack.getItemID()>=1){
            map.put("code","200");
            map.put("msg","success");
            map.put("step",goDieFeeBack.getSteps());
        }else {
            map.put("code","201");
            map.put("msg","success");
        }
        return map;
    }

    /**
     *
     * @param userID  释放道具者
     * @param userItemID  道具id
     * @param reciveID  被道具作用者id
     * @return
     */
    @RequestMapping(value = "/insertGoDie",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertGoDie(final int userID, int userItemID, final int reciveID){
        FeedBack feedBack;
        GoDie goDie=new GoDie();
        goDie.setUserid(userID);
        goDie.setUseritemid(userItemID);
        goDie.setReciveID(reciveID);
        int cos=goDieService.insertGoDie(goDie);//完成goDie的插入
        //删除道具
        deleItem(userItemID, userID);
        //同时向用户推送消息
        taskExecutor.execute(new Runnable() {
            public void run() {
                messageService.insertMessage(userID,reciveID,"4",new Date(),"你被别人限制行动了！");
                    JpushClientUtil.sendDynatic(String.valueOf(reciveID),"0","你被别人限制行动了！","你被别人限制行动了！",
                        "你被别人限制行动了！","hips");
            }
        });
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    private void deleItem( Integer itemID,  Integer userID) {
        UserItem userItem=itemService.getSpeicUseritembY(userID,itemID);
        int maxid= itemService.maxIDu(userID,itemID);
        itemService.deletUserOneItem(maxid);//删除  user_one_item
        itemService.updateUserItemBindItemIDCount(userID,itemID,userItem.getCount()-1);
        userItem.setCount(userItem.getCount()-1);
        if(userItem.getCount()==0){
            itemService.deleteUserItemByID(userID,itemID);
        }
    }

    /**
     *
     * @param loverID
     * @param userID
     * @param ItemID
     * @return
     */
    @RequestMapping(value = "/insertDog",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertDog(final String loverID, int userID, int ItemID){
        deleItem(ItemID,userID);
        LoverDog  loverDog=new LoverDog();
        loverDog.setInserttime(new Date());
        loverDog.setLoverid(loverID);
        loverDog.setUserID(userID);
        loverDog.setItemID(ItemID);
        loverDogService.inserLoverDog(loverDog);
        Moment moment=new Moment();
        moment.setUserid(userID);
        moment.setMomenttype(15);
        moment.setMomentimage("");
        moment.setMomentdate(new Date());
        moment.setMomentcontent("使用了道具：“let’s狗”");
        momentService.insertMoment(moment);
        taskExecutor.execute(new Runnable() {
            public void run() {
                LoverShip loverShip=loverShipService.getLoverShipByID(loverID);
                messageService.insertMessage(-1,loverShip.getLoverboyid(),"4",new Date(),"你们的情侣主页被恶搞了");
                messageService.insertMessage(-1,loverShip.getLovergirlid(),"4",new Date(),"你们的情侣主页被恶搞了");
                JpushClientUtil.sendDynatic(String.valueOf(loverShip.getLoverboyid()),"你们的情侣主页被恶搞了","你们的情侣主页被恶搞了","你们的情侣主页被恶搞了","你们的情侣主页被恶搞了","hips");
                JpushClientUtil.sendDynatic(String.valueOf(loverShip.getLovergirlid()),"你们的情侣主页被恶搞了","你们的情侣主页被恶搞了","你们的情侣主页被恶搞了","你们的情侣主页被恶搞了","hips");
            }
        });
        return new FeedBack<String>("success","200");
    }
    @RequestMapping(value = "/getDogHeadByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> getDogHeadByID(String loverID){
        FeedBack feedBack=null;
        int cos= doolePhotoService.getDogHeadByID(loverID);
        if(cos>=1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("success","201");
        }
        return feedBack;
    }
    @RequestMapping(value = "/testDogHead",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public String testDogHead(){
        sheduleTaskForDogHead.ifDeleteLoverDog();
        sheduleTaskForDeteGoDie.ifDeleteGoDie();
        return "god";
    }

    @RequestMapping(value = "/deleteGoDieByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> deleteGoDieByID(@RequestParam("userID") int userID){
        FeedBack  feedBack=null;
        int cos=goDieService.deleteGoDieByID(userID);
        if(cos>=1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
}
