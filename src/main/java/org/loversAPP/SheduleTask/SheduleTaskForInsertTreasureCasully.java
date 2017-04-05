package org.loversAPP.SheduleTask;

import org.loversAPP.Controller.utils.MapCalculator;
import org.loversAPP.DTO.ActivityRecordsPosition;
import org.loversAPP.Jpush.JpushClientUtil;
import org.loversAPP.model.Treasure;
import org.loversAPP.service.ActivityRecordService;
import org.loversAPP.service.TreasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/4/2.
 *   系统随机播撒宝藏函数
 */
@Component
public class SheduleTaskForInsertTreasureCasully {
    @Autowired
    private TreasureService treasureService;
    @Autowired
    private ActivityRecordService activityRecordService;

    public void  insertTreasureCasully(){
        int [] itemId={0,11,10};
        List<ActivityRecordsPosition> activityRecordsPositionList=activityRecordService.getactivityRecordsPositionList();
        //根据圈子半径在周围撒宝
        for (ActivityRecordsPosition activityRecordsPosition:activityRecordsPositionList){
            int radis=  activityRecordsPosition.getRadius();
            int count=radis/200;
            List<MapCalculator.Positon> positonList=  MapCalculator.MakeRandomPositonAroundCircle(activityRecordsPosition.getLatitude(),activityRecordsPosition.getLongtitude(),count,radis);
            List<Treasure> treasureList=new ArrayList<Treasure>();
            for (int i = 0; i <count ; i++) {
                int traSureCde=itemId[new Random().nextInt(3)];
                Treasure  trasure=new Treasure();
                trasure.setLatitude(positonList.get(i).getLatitude());
                trasure.setLongtitude(positonList.get(i).getLongLatitude());
                trasure.setTreasurecode(traSureCde);
                trasure.setUserid(-1);
                if(traSureCde==0){
                    trasure.setMoney(50+new Random().nextInt(460));
                }else{
                    trasure.setMoney(0);
                }
                treasureList.add(trasure);
            }
            if(treasureList.size()>=1)
            {
                treasureService.insertBathch(treasureList);
            }
            System.out.println("快来挖宝藏啦");
        }
        JpushClientUtil.sendToAll("快来挖宝藏啦","快来挖宝藏啦","快来挖宝藏啦啦","tips");
    }


}
