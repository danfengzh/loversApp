package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.DTO.CarePeople;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.TinyUser;
import org.loversAPP.Jpush.JpushClientUtil;
import org.loversAPP.model.User;
import org.loversAPP.service.UserService;
import org.loversAPP.service.friendService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/25.
 */
@Controller
@RequestMapping("/friendShip")
public class friendController extends BaseController {
    @Autowired
    private friendService friendService;
    @Autowired
    @Qualifier("taskExecutor")
    private TaskExecutor taskExecutor;
    @Autowired
    private messageService messageService;
    @Autowired
    private UserService  userService;
    /**
     *
     * @param userID
     * @param friendID
     * @return
     */
    @RequestMapping(value = "/insertFriend",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertFriend(@RequestParam("userID") final Integer userID , @RequestParam("friendID") final Integer friendID){
        FeedBack<String> feedBack;
        int cos= friendService.checkIsFollowed(userID,friendID);
        if(cos==1){
            feedBack=new FeedBack("failure","201");
            return feedBack;
        }
        int count= friendService.insertFriend(userID,friendID);
        taskExecutor.execute(new Runnable() {
            public void run() {
               User user= userService.getUserByID(userID);
                messageService.insertMessage(userID,friendID,"8",new Date(),"你已经被用户"+user.getUsername()+"关注了~~");
                JpushClientUtil.sendDynatic(String.valueOf(friendID),"1","你已经被用户"+user.getUsername()+"关注了~~","你已经被用户"+user.getUsername()+"关注了~~","tips","tips");
            }
        });
        if(count==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value = "/deleteFriend",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> deleteFriend(@RequestParam("userID") Integer userID ,@RequestParam("friendID") Integer friendID){
        FeedBack<String> feedBack;
        int count= friendService.deleteFriend(userID,friendID);
        if(count==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getFriendsByUID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public Map getFriendsByUID(@RequestParam("userID") Integer userID){

        Map hashMap=new HashMap();
        List<TinyUser> tinyUsers= friendService.getAllTinyUser(userID);
        if(tinyUsers!=null){
            hashMap.put("code","200");
            hashMap.put("msg","success");
            hashMap.put("friend",tinyUsers);

        }
        else {
            hashMap.put("code","500");
            hashMap.put("msg","failure");
        }
        return hashMap;
    }
    @RequestMapping(value = "/checkIsFollowed",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> checkIsFollowed(Integer userID ,Integer friendID){
        FeedBack<String> feedBack;
        int cos= friendService.checkIsFollowed(userID,friendID);
        switch (cos){
            case 1:
                feedBack=new FeedBack("success","203");
                break;
            case 2:
                feedBack=new FeedBack("success","202");
                break;
            case 3:
                feedBack=new FeedBack("success","200");
                break;
            case 4:
                feedBack=new FeedBack("success","201");
                break;
            default:
                feedBack=new FeedBack("success","200");
                break;

        }
        return feedBack;
    }
    @RequestMapping(value = "/getFriendsByFID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public Map getFriendsByFID(@RequestParam("friendID") int friendID){
        Map  result=new HashMap();
        List<CarePeople> carePeoples= friendService.getCarePeoples(friendID);
        result.put("code","200");
        result.put("friend",carePeoples);
        result.put("msg","success");
        return result;
    }
}
