package org.loversAPP.SheduleTask;

import com.alibaba.fastjson.JSONObject;
import org.loversAPP.Jpush.JpushClientUtil;
import org.loversAPP.model.LoverCapsule;
import org.loversAPP.model.User;
import org.loversAPP.service.LoveCauleService;
import org.loversAPP.service.LoverShipService;
import org.loversAPP.service.UserService;
import org.loversAPP.service.messageService;
import org.loversAPP.utils.TimeIntervalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Component
public class SheduleTaskForLoverCaspule {
    @Autowired
   private LoveCauleService loveCauleService;
    @Autowired
   private UserService userService;
    @Autowired
    private messageService messageService;
    /**
     *     long deltaTime=1000*60*3;//3分钟
     List<DoodlePhoto> doodlePhotoList=    doolePhotoService.getAllDooolePhotos();
     for(DoodlePhoto doodlePhoto:doodlePhotoList){
     boolean flag= TimeIntervalUtils.isOutDate(doodlePhoto.getDoodletime(),deltaTime);
     if(flag){
     //超时了  替换图片
     //根据phoID得到真正被 替换的用户的id
     int  trueUserid=userPhoService.getUserIDbyPhoid(doodlePhoto.getPhotoid());
     userPhoService.updateUserPhoUrlByUserID(trueUserid,doodlePhoto.getDoodlephoto());
     }
     }
     */
    public void  ifopen(){

      List<LoverCapsule> loverCapsuleList= loveCauleService.getCaspule();
        long deltaTime=10;//
      for(LoverCapsule loverCapsule:loverCapsuleList){
          //
          boolean flag= TimeIntervalUtils.isOutDate(loverCapsule.getOpenday(),deltaTime);
          User user=userService.getUserByID(loverCapsule.getReceiverid());
          //而且当state等于1的时候，就不再进行推送消息了
          if(flag&&!loverCapsule.getState().equals("1")){
              loveCauleService.setStateByID(loverCapsule.getId(),"1");
              loverCapsule.setState("1");
              if(!loverCapsule.getState().equals("2")&&!loverCapsule.getState().equals("0")){

                  JSONObject jsonObject=new JSONObject();
                  jsonObject.put("code","200");
                  jsonObject.put("msg","success");
                  jsonObject.put("data",loverCapsule);
                  messageService.insertMessage(loverCapsule.getUserid(),user.getId(),"3",new Date(),jsonObject.toJSONString());
                  JpushClientUtil.sendDynatic(String.valueOf(user.getId()),String.valueOf(user.getStauts()),"你收到了TA给你的时间沙漏",
                          "你收到了TA给你的时间沙漏…~","你收到了TA给你的时间沙漏…~","hips");
              }
          }
      }
    }

}
