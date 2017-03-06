package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.UserMessage;
import org.loversAPP.Jpush.JpushClientUtil;
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
    @Qualifier("taskExecutor")
    private TaskExecutor taskExecutor;

    @RequestMapping(value = "/insertMessage",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack insertMessage(@RequestParam("userID")  Integer userID, @RequestParam("receiverID") final Integer receiverID ,
                                  @RequestParam("msgType") final String msgType ,
                                  @RequestParam("msgDate") Date msgDate , @RequestParam("msgContent") final String msgContent)
    {
        FeedBack feedBack;
        int count= messageService.insertMessage(userID,receiverID,msgType,msgDate,msgContent);
        //异步发送消息 给receiver----调用极光推送异步完成--
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                JpushClientUtil.sendAnaroidRegisters(String.valueOf(receiverID),msgType,msgContent);
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
     * @param receiverID
     * @return
     */
    @RequestMapping(value = "/getMessageByRID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public Map getMessageByRID(@RequestParam("receiverID") Integer receiverID){
        Map tempMap=new HashMap();
        class  userMessage{
            private String userName;
            private Integer userID;
            private String avatar;
            private String msgType;
            private Date msgDate;
            private String msgContent;

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public Integer getUserID() {
                return userID;
            }

            public void setUserID(Integer userID) {
                this.userID = userID;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getMsgType() {
                return msgType;
            }

            public void setMsgType(String msgType) {
                this.msgType = msgType;
            }

            public Date getMsgDate() {
                return msgDate;
            }

            public void setMsgDate(Date msgDate) {
                this.msgDate = msgDate;
            }

            public String getMsgContent() {
                return msgContent;
            }

            public void setMsgContent(String msgContent) {
                this.msgContent = msgContent;
            }

            public userMessage(String userName, Integer userID, String avatar, String msgType, Date msgDate, String msgContent) {
                this.userName = userName;
                this.userID = userID;
                this.avatar = avatar;
                this.msgType = msgType;
                this.msgDate = msgDate;
                this.msgContent = msgContent;
            }

            public userMessage() {
            }
        }
        List<UserMessage> userMessage= messageService.getMessageByRID(receiverID);
        List<userMessage> myusers=new ArrayList<>();
        for (UserMessage m:userMessage){
            userMessage userMess=new userMessage();
            userMess.setUserID(m.getUser().getId());
            userMess.setUserName(m.getUser().getUsername());
            userMess.setAvatar(m.getUser().getAvator());
            userMess.setMsgType(m.getMsgtype());
            userMess.setMsgDate(m.getMsgdate());
            userMess.setMsgContent(m.getMsgcontent());
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
            tempMap.put("data",myusers);
        }
        return tempMap;
    }
}
