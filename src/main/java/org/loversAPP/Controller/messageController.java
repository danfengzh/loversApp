package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.UserMessage;
import org.loversAPP.DTO.urMessage;
import org.loversAPP.Jpush.JpushClientUtil;
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

import java.util.*;

/**
 * Created by Administrator on 2017/3/4.
 */
@Controller
@RequestMapping("/message")
public class messageController extends BaseController {
    @Autowired
    private messageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("taskExecutor")
    private TaskExecutor taskExecutor;
    @RequestMapping(value = "/insertMessage",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack insertMessage(@RequestParam("userID")  Integer userID, @RequestParam("receiverID") final Integer receiverID ,
                                  @RequestParam("msgType") final String msgType ,
                                  @RequestParam("msgContent") final String msgContent)
    {
        Date msgDate=new Date();
        FeedBack feedBack;
        int count= messageService.insertMessage(userID,receiverID,msgType,msgDate,msgContent);
        final int staus=userService.getUserByID(receiverID).getStauts();
        //异步发送消息 给receiver----调用极光推送异步完成--
        taskExecutor.execute(new Runnable() {
            public void run() {
                JpushClientUtil.sendDynatic(String.valueOf(receiverID),String.valueOf(staus),msgContent,msgContent,
                        msgContent,msgContent);
            }
        });
        if(count==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","400");
        }

        return feedBack;
    }

    /**
     * 需要自定义map返回数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/getMessageByUID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public Map getMessageByUID(@RequestParam("id") Integer id){
        Map tempMap=new HashMap();
        List<UserMessage> userMessage= messageService.getMessageByRID(id);
        getAutoDefineMsg(tempMap, userMessage);
        return tempMap;
    }
    @RequestMapping(value = "/deleteMessageByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack deleteMessageByID(@RequestParam("id") Integer id){
        FeedBack feedBack=null;
        int cos=messageService.deleteMessageByID(id);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }else{
            feedBack=new FeedBack("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getMessageByRID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public Map getMessageByRID(@RequestParam("id") Integer id){
        Map tempMap=new HashMap();
        List<UserMessage> userMessage= messageService.getMessageByRecID(id);
        getAutoDefineMsg(tempMap, userMessage);
        return tempMap;
    }

    private void getAutoDefineMsg(Map tempMap, List<UserMessage> userMessage) {
        List<urMessage> myusers=new ArrayList();
        for (UserMessage m:userMessage){
            urMessage userMess=new urMessage();
            userMess.setUserID(m.getUser().getId());
            userMess.setUserName(m.getUser().getUsername());
            userMess.setAvatar(m.getUser().getAvator());
            userMess.setMsgType(m.getMsgtype());
            userMess.setMsgDate(m.getMsgdate());
            userMess.setMsgContent(m.getMsgcontent());
            userMess.setIsRead(m.getIsRead());
            myusers.add(userMess);
        }
        if(userMessage!=null){
            tempMap.put("code","200");
            tempMap.put("msg","success");
            tempMap.put("data",myusers);
        }
        else {
            tempMap.put("code","400");
            tempMap.put("msg","failure");
        }
    }
    @RequestMapping(value = "/setReadByMID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> setReadByMID(@RequestParam("messageID") Integer messageID){
        FeedBack feedBack;
        int cos= messageService.setReadByMID(messageID);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }
        else
        {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/setAllReadByRID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> setAllReadByRID(@RequestParam("recieverID") Integer recieverID){
        FeedBack feedBack;
        int cos= messageService.setAllReadByRID(recieverID);
        if(cos>=1){
            feedBack=new FeedBack("success","200");
        }
        else
        {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getUnreadCountByRID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> getUnreadCountByRID(@RequestParam("recieverID") Integer recieverID){
        FeedBack feedBack;
        int cos= messageService.getUnreadCountByRID(recieverID);
        feedBack=new FeedBack("success","200",cos);
        return feedBack;
    }
}
