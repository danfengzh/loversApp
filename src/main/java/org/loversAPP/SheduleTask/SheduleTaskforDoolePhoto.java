package org.loversAPP.SheduleTask;

import org.loversAPP.model.DoodlePhoto;
import org.loversAPP.service.DoolePhotoService;
import org.loversAPP.service.UserPhoService;
import org.loversAPP.utils.TimeIntervalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@Component
public class SheduleTaskforDoolePhoto {
    @Autowired
   private DoolePhotoService doolePhotoService;
    @Autowired
    private UserPhoService userPhoService;
    /**
     *   long deltaTime=1000*60;//1分钟
     List<TextRecords> usertexts=userTextService.getTextRecordsByiuserid();
     for (TextRecords usertext:usertexts){
     boolean flag= TimeIntervalUtils.isOutDate(usertext.getPublishdate(),60000);
     if(flag){
     //超时
     userTextService.deleteTextByID(usertext.getId());
     }
     }
     */
    public void testifDoolePhotoOutDate(){
        long deltaTime=1000*60*3*60;//3分钟
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
    }
}
