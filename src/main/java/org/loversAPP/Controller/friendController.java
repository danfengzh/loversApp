package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.FriendShip;
import org.loversAPP.service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/2/25.
 */
@Controller
@RequestMapping("/friendShip")
public class friendController extends BaseController {
    @Autowired
    private friendService friendService;

    /**
     *
     * @param userID
     * @param friendID
     * @return
     */
    @RequestMapping(value = "/insertFriend",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertFriend(@RequestParam("userID") Integer userID ,@RequestParam("friendID") Integer friendID){
           FeedBack<String> feedBack;
          int count= friendService.insertFriend(userID,friendID);
          if(count==1){
              feedBack=new FeedBack<>("success","200");
          }
          else {
              feedBack=new FeedBack<>("failure","500");
          }
          return feedBack;
    }
    @RequestMapping(value = "/deleteFriend",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> deleteFriend(@RequestParam("userID") Integer userID ,@RequestParam("friendID") Integer friendID){
        FeedBack<String> feedBack;
        int count= friendService.deleteFriend(userID,friendID);
        if(count==1){
            feedBack=new FeedBack<>("success","200");
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getFriendsByUID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<FriendShip> getFriendsByUID(@RequestParam("userID") Integer userID){
        FeedBack<FriendShip> feedBack;
        FriendShip friendShip= friendService.getFriendsByUID(userID);
        if(friendShip!=null){
            feedBack=new FeedBack<>("success","200",friendShip);
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }
}
