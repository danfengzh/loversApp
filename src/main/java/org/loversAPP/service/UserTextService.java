package org.loversAPP.service;

import org.loversAPP.DTO.UserText;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface UserTextService {

    public Integer insertText(Integer recordsID,Integer userItemID,
                              Integer userID ,String text,String longtitude,String latitude);
    public UserText getTextsByRecordsID(Integer recordsID);
    public Integer deleteTextByID(Integer id);
}
