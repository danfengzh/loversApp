package org.loversAPP.service;

import org.loversAPP.DTO.UserMessage;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 */
public interface messageService {

    public Integer insertMessage(Integer userID , Integer receiverID , String msgType , Date msgDate ,String msgContent);

    /**
     * 2.message表和user表联合查询receiver的所有消息)  查看消息都发给了谁
     * @param receiverID
     * @return
     */
    public List<UserMessage> getMessageByRID(Integer receiverID);


    public Integer deleteMessageByID(Integer id);

    public List<UserMessage> getMessageByRecID(Integer recID);
    public int setReadByMID(Integer messageID);

    int setAllReadByRID(Integer recieverID);
    int  getUnreadCountByRID(Integer recieverID);
}
