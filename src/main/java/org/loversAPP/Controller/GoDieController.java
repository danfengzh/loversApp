package org.loversAPP.Controller;

import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.GoDieFeeBack;
import org.loversAPP.Jpush.JpushClientUtil;
import org.loversAPP.model.GoDie;
import org.loversAPP.model.User;
import org.loversAPP.model.UserItem;
import org.loversAPP.service.GoDieService;
import org.loversAPP.service.ItemService;
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
        goDie.setUserid(reciveID);
        goDie.setUseritemid(userItemID);
        int cos=goDieService.insertGoDie(goDie);//完成goDie的插入
        //删除道具
        deleItem(userItemID, userID);
        //同时向用户推送消息
        taskExecutor.execute(new Runnable() {
            public void run() {
                User user= userService.getUserByID(userID);
                messageService.insertMessage(userID,reciveID,"2",new Date(),"你被别人限制行动了！");
                JpushClientUtil.sendDynatic(String.valueOf(reciveID),String.valueOf(user.getStauts()),"你有一条消息提醒","tips",
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
        int maxid= itemService.maxIDu(userID);
        itemService.deletUserOneItem(maxid);//删除  user_one_item
        itemService.updateUserItemCount(userID,userItem.getCount()-1);
        userItem.setCount(userItem.getCount()-1);
        if(userItem.getCount()==0){
            itemService.deleteUserItemByID(userID);
        }
    }
}
