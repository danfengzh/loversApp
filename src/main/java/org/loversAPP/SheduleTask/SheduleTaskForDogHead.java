package org.loversAPP.SheduleTask;

import org.loversAPP.DTO.LoverDogCount;
import org.loversAPP.service.LoverDogService;
import org.loversAPP.utils.TimeIntervalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/4/4.
 *    long deltaTime=1000*60*3;//3分钟
 List<DoodlePhoto> doodlePhotoList=    doolePhotoService.getAllDooolePhotos();
 for(DoodlePhoto doodlePhoto:doodlePhotoList){
 boolean flag= TimeIntervalUtils.isOutDate(doodlePhoto.getDoodletime(),deltaTime);
 */
@Component
public class SheduleTaskForDogHead {
    @Autowired
    LoverDogService  loverDogService;

    public void  ifDeleteLoverDog(){
        //1.先保证后一条
       List<LoverDogCount> loverDogCounts= loverDogService.getLoverDogCount();
        long deltaTime=1000*60*60*3;//
        for(LoverDogCount loverDogCount:loverDogCounts){
            if(loverDogCount.getCount()==2){
                loverDogService.deleteLoverDogByID(loverDogCount.getId());
            }
            //2. 确认时间是否到期
            boolean flag= TimeIntervalUtils.isOutDate(loverDogCount.getInsertTime(),deltaTime);
            if(flag){
                loverDogService.deleteLoverDogByID(loverDogCount.getId());
            }
        }

    }
}
