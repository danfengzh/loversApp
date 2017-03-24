package org.loversAPP.service.Impl;

import org.loversAPP.DTO.UserMessage;
import org.loversAPP.dao.MessageMapper;
import org.loversAPP.model.Message;
import org.loversAPP.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 */
@Service
public class messageServiceImpl implements messageService {
    @Autowired
    private MessageMapper messageMapper;

    public Integer insertMessage(Integer userID, Integer receiverID, String msgType, Date msgDate, String msgContent) {
        Message message=new Message();
        message.setUserid(userID);
        message.setReceiverid(receiverID);
        message.setMsgtype(msgType);
        message.setMsgcontent(msgContent);
        message.setMsgdate(new Date());
        return messageMapper.insert(message);
    }


    public List<UserMessage> getMessageByRID(Integer receiverID) {

        return messageMapper.getUserMessageByID(receiverID);
    }


    public Integer deleteMessageByID(Integer id) {
        return null;
    }

    /**
     *  根据接收者用户id查看消息
     * @return
     */

    public List<UserMessage> getMessageByRecID(Integer recID) {
        return messageMapper.getUserMessageByRecID(recID);
    }


    public int setReadByMID(Integer messageID) {
        return messageMapper.setReadByMID(messageID);
    }

    public int setAllReadByRID(Integer recieverID) {
        return messageMapper.setAllReadByRID(recieverID);
    }


    public int getUnreadCountByRID(Integer recieverID) {
        return messageMapper.getUnreadCountByRID(recieverID);
    }
}
