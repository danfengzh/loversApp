package org.loversAPP.service;

import org.loversAPP.DTO.UserText;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface UserTextService {

    public Integer insertText(Integer recordsID,Integer userItemID,
                              Integer userID ,String text,String longtitude,String latitude);
    public List<UserText> getTextsByUserID(Integer userid);
    public List<UserText> getTextsByRecordsID (Integer recordID);
    public Integer deleteTextByID(Integer id);
}