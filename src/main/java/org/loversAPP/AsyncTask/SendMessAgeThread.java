package org.loversAPP.AsyncTask;

import org.loversAPP.Jpush.JpushClientUtil;
import org.loversAPP.VO.MessAgeContent;

/**
 * Created by Administrator on 2017/3/20.
 */
public class SendMessAgeThread implements Runnable{
    private MessAgeContent  messAgeContent;
    public SendMessAgeThread(MessAgeContent messAgeContent){
        this.messAgeContent=messAgeContent;
    }
    @Override
    public void run() {
        JpushClientUtil.sendDynatic(messAgeContent.getAlias(),messAgeContent.getStatus(),"tips","你有一条消息提醒",messAgeContent.getContent(),"tips");
    }
}
