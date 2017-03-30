package org.loversAPP.SheduleTask;

import org.loversAPP.model.PhotoRecords;
import org.loversAPP.service.UserPhoService;
import org.loversAPP.utils.TimeIntervalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
@Component
public class SheduleTaskJobForUserPhoto {
    @Autowired
    private UserPhoService userPhoService;
    public void setUserPhoService(UserPhoService userPhoService) {
        this.userPhoService = userPhoService;
    }

    public void testInsert(){
        //轮询 获取分析当前的系统时间
        //如果到达时间的话 就清空 该条记录
        long deltaTime=1000*60;//1分钟
        List<PhotoRecords> userPhotos=userPhoService.getOuterUserPhotosByUseriD();
        for (PhotoRecords userPhoto:userPhotos){
            boolean flag= TimeIntervalUtils.isOutDate(userPhoto.getPublishdate(),60000);
            if(flag){
                //超时
                userPhoService.deletePhotoByID(userPhoto.getId());
            }
        }
        System.out.println("vvcccccccc");
    }
}
