package org.loversAPP.SheduleTask;

import org.loversAPP.Jpush.JpushClientUtil;
import org.loversAPP.model.LoverCapsule;
import org.loversAPP.model.User;
import org.loversAPP.service.LoveCauleService;
import org.loversAPP.service.LoverShipService;
import org.loversAPP.service.UserService;
import org.loversAPP.utils.TimeIntervalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        long deltaTime=1000*60*3;//3分钟
      for(LoverCapsule loverCapsule:loverCapsuleList){
          boolean flag= TimeIntervalUtils.isOutDate(loverCapsule.getOpenday(),deltaTime);
          User user=userService.getUserByID(loverCapsule.getReceiverid());
          if(flag){
              loveCauleService.setStateByID(loverCapsule.getId(),"1");
              JpushClientUtil.sendDynatic(String.valueOf(loverCapsule.getReceiverid()),String.valueOf(user.getStauts()),"tips",
                      "你有一条消息提醒","你的时间胶囊可以打开了","hips");
          }
      }
    }

}
