package org.loversAPP.Controller;

import org.loversAPP.DTO.FeedBack;
import org.loversAPP.SheduleTask.SheduleTaskForInsertTreasureCasully;
import org.loversAPP.model.*;
import org.loversAPP.service.ItemService;
import org.loversAPP.service.TreasureService;
import org.loversAPP.service.UserService;
import org.loversAPP.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Controller
@RequestMapping("/TreaSure")
public class TreaSureController {
    @Autowired
    private TreasureService treasureService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private SheduleTaskForInsertTreasureCasully sheduleTaskForInsertTreasureCasully;
    @Autowired
    @Qualifier("taskExecutor")
    private TaskExecutor taskExecutor;
    @Autowired
    private messageService messageService;
    @RequestMapping(value = "getTreasureByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Treasure> getTreasureByID(int id){
        Treasure treasure= treasureService.getTreasureByID(id);
        return new FeedBack<Treasure>("success","200",treasure);
    }
    /**
     * 人工埋宝藏
     * @param userID
     * @param longtitude
     * @param latitude
     * @param treasureCode
     * @param money
     * @return
     */
    @RequestMapping(value = "insertTreasure", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertTreasure(@RequestParam("userID") int userID , @RequestParam("longtitude")String longtitude ,
                                           @RequestParam("latitude")String latitude,  @RequestParam("treasureCode")int  treasureCode ,
                                           @RequestParam(value = "money",required = false,defaultValue ="0") int money){
        FeedBack feedBack=null;
        Treasure treasure=new Treasure();
        treasure.setUserid(userID);
        treasure.setLongtitude(longtitude);
        treasure.setLatitude(latitude);
        treasure.setTreasurecode(treasureCode);
        treasure.setMoney(money);
        int cos= treasureService.insertTreasure(treasure);
        //同时删除用户的宝藏---删除 deleteUserItemByID
        deleItem(treasureCode, userID);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    private void deleItem(Integer treasureCode,Integer userID) {
        UserItem userItem=itemService.getSpeicUseritembY(userID,treasureCode);
        int maxid= itemService.maxIDu(userID,treasureCode);
        itemService.deletUserOneItem(maxid);//删除  user_one_item
        itemService.updateUserItemBindItemIDCount(userID,treasureCode,userItem.getCount()-1);
        userItem.setCount(userItem.getCount()-1);
        if(userItem.getCount()==0){
            itemService.deleteUserItemByID(userID,treasureCode);
        }
    }
    @RequestMapping(value = "getAllTreasures", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Treasure> getAllTreasures(){
        FeedBack feedBack=null;
        List<Treasure> treasure= treasureService.getAllTreasures();
        if(treasure!=null){
            feedBack=new FeedBack("success","200",treasure);
        }else {
            feedBack=new FeedBack("success","400",treasure);
        }
        return feedBack;
    }
    @RequestMapping(value = "insertDigHistory", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertDigHistory(final int digUserID, int treasureCode , int treasureID){
        FeedBack feedBack=null;
        Treasure treasure=   treasureService.getTreasureByID(treasureID);
        User digUser= userService.getUserByID(digUserID);
        if(treasureCode==0)
        {
            if(treasure!=null&&treasure.getMoney()!=null){
                userService.updateMoneyByID(digUser.getMoney()+treasure.getMoney(),digUserID);
            }
        }
        else
        {
            int itemID= treasureService.getItemIDbyTreasureCode(treasureCode);
            // getTreasureByID(treasureID)找到埋宝人userID,将其money增加道具原价的1/4
            final User doTreauserUser=userService.getUserByID(treasure.getUserid());
            final Item item=itemService.getItemByID(itemID);
            userService.updateMoneyByID(doTreauserUser.getId(),(int) (doTreauserUser.getMoney()+item.getItemprice()/4));
            String  digContent="";
            if(treasureCode==0){
                digContent="恭喜你挖到了金币，已经增加到了账户，请查收";
            }
            else {
                digContent="恭喜你你挖到了稀有道具";
            }
            final String finalDigContent = digContent;
            taskExecutor.execute(new Runnable() {
                public void run() {
                    messageService.insertMessage(-1,doTreauserUser.getId(),"7",new Date(),"你埋的宝箱被挖了，你从埋宝人处得到了"+(item.getItemprice()/4)+"的金币");
                    messageService.insertMessage(-1,digUserID,"6",new Date(), finalDigContent);
//                    JpushClientUtil.sendDynatic(String.valueOf(doTreauserUser.getId()),"0","OWO","你埋的宝箱被挖了",
//                            "你埋的宝箱被挖了，你从埋宝人处得到了"+(item.getItemprice()/4)+"的金币","");
                }
            });
            UserItem userItem=itemService.getSpeicUseritembY(digUserID,itemID);
            UserOneItem userOneItem=new UserOneItem();
            if(userItem==null)
            {
                itemService.insertUserItem( digUserID,itemID);
                userOneItem.setItemid(itemID);
                userOneItem.setUserid(digUserID);
            }
            else
            {
                itemService.updateUserItemBindItemIDCount(digUserID,itemID,userItem.getCount()+1);
                userOneItem.setItemid(userItem.getItemId());
                userOneItem.setUserid(userItem.getUserId());
            }
            itemService.insertIntoUserOneItem(userOneItem);
        }
        //最后删除这个道具
        treasureService.deleteTreasureByID(treasureID);
        return new FeedBack<String>("success","200");
    }
    @RequestMapping(value = "sheduleTaskForInsertTreasureCasully", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String sheduleTaskForInsertTreasureCasully(){
        //系统撒宝 并推送消息
        taskExecutor.execute(new Runnable() {
            public void run() {
                sheduleTaskForInsertTreasureCasully.insertTreasureCasully();

            }
        });
        return "宝藏来啦";
    }
}
