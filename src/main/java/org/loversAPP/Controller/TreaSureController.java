package org.loversAPP.Controller;

import org.loversAPP.DTO.FeedBack;
import org.loversAPP.model.*;
import org.loversAPP.service.ItemService;
import org.loversAPP.service.TreasureService;
import org.loversAPP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        int maxid= itemService.maxIDu(userID);
        itemService.deletUserOneItem(maxid);//删除  user_one_item
        itemService.updateUserItemCount(userID,userItem.getCount()-1);
        userItem.setCount(userItem.getCount()-1);
        if(userItem.getCount()==0){
            itemService.deleteUserItemByID(userID);
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
    public FeedBack<String> insertDigHistory(int digUserID, int treasureCode , int treasureID){
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
            User doTreauserUser=userService.getUserByID(treasure.getUserid());
            Item item=itemService.getItemByID(itemID);
            userService.updateMoneyByID(doTreauserUser.getId(),(int) (doTreauserUser.getMoney()+item.getItemprice()/4));
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
                itemService.updateUserItemCount(digUserID,userItem.getCount()+1);
                userOneItem.setItemid(userItem.getItemId());
                userOneItem.setUserid(userItem.getUserId());
            }
            itemService.insertIntoUserOneItem(userOneItem);
        }
        //最后删除这个道具
        treasureService.deleteTreasureByID(treasureID);
        return new FeedBack<String>("success","200");
    }
}
