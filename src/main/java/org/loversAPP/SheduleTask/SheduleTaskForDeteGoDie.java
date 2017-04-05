package org.loversAPP.SheduleTask;

import org.loversAPP.DTO.TempGoDie;
import org.loversAPP.service.GoDieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/4/4.
 */
@Component
public class SheduleTaskForDeteGoDie {
    @Autowired
    private GoDieService goDieService;

    public void  ifDeleteGoDie(){
        List<TempGoDie> tempGoDieList=goDieService.getTempGoDie();
        long detaTime=1000*60;
        for(TempGoDie tempGoDie:tempGoDieList){
            if(tempGoDie.getCount()==2){
                goDieService.deleteGoDieByPrimairyKey(tempGoDie.getId());
            }
        }
    }

}
