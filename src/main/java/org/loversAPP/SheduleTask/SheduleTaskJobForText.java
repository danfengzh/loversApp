package org.loversAPP.SheduleTask;

import org.loversAPP.model.TextRecords;
import org.loversAPP.service.UserTextService;
import org.loversAPP.utils.TimeIntervalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Component
public class SheduleTaskJobForText
{
    @Autowired
    private UserTextService userTextService;

    public void setUserTextService(UserTextService userTextService) {
        this.userTextService = userTextService;
    }
    public void testText(){
        //轮询 获取分析当前的系统时间
        //如果到达时间的话 就清空 该条记录
        long deltaTime=1000*60*60*24*30;//
        List<TextRecords> usertexts=userTextService.getTextRecordsByiuserid();
        for (TextRecords usertext:usertexts){
            boolean flag= TimeIntervalUtils.isOutDate(usertext.getPublishdate(),60000);
            if(flag){
                //超时
                userTextService.deleteTextByID(usertext.getId());
            }
        }
        System.out.println("vvcccccccc");
    }
}
