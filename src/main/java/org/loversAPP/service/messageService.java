package org.loversAPP.service;

import org.loversAPP.DTO.UserMessage;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/4.
 */
public interface messageService {

    public Integer insertMessage(Integer userID , Integer receiverID , String msgType , Date msgDate ,String msgContent);

    /**
     * 2.message表和user表联合查询receiver的所有消息)
     * @param receiverID
     * @return
     */
    public UserMessage getMessageByRID(Integer receiverID);


    public Integer deleteMessageByID(Integer id);
}
