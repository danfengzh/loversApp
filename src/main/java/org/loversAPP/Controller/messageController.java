package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.UserMessage;
import org.loversAPP.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/3/4.
 */
@Controller
@RequestMapping("/message")
public class messageController extends BaseController {
    @Autowired
    private messageService messageService;

    /**
     * 需要自定义map返回数据
     * @param receiverID
     * @return
     */
    @RequestMapping(value = "/getMessageByRID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<UserMessage> getMessageByRID(@RequestParam("receiverID") Integer receiverID){
        FeedBack<UserMessage> feedBack;
        UserMessage userMessage= messageService.getMessageByRID(receiverID);
        if(userMessage!=null){
            feedBack=new FeedBack<>("success","200",userMessage);
        }
        else {
            feedBack=new FeedBack<>("success","200");
        }
        return feedBack;
    }
}
