package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.DTO.UserMessage;
import org.loversAPP.model.Message;
import org.loversAPP.model.MessageExample;

import java.util.List;



public interface MessageMapper {
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    List<UserMessage> getUserMessageByID(@Param("userID") Integer userID);

    /**
     *
     * SELECT
     message_read.isRead
     FROM
     message_read ,
     message ,
     `user`
     WHERE
     message.receiverID = 2 AND
     message.userID = `user`.id AND
     message_read.messageID = message.id

     * @param recID
     * @return
     */
    List<UserMessage> getUserMessageByRecID(@Param("recID") Integer recID);
    public int setReadByMID(@Param("messageID")Integer messageID);
    public int setAllReadByRID(Integer recieverID);
    public int getUnreadCountByRID(Integer recieverID);

   public Integer getMaxIDbyUserid();
}