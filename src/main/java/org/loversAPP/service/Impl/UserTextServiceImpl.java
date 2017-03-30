package org.loversAPP.service.Impl;

import org.loversAPP.DTO.UserText;
import org.loversAPP.dao.TextRecordsMapper;
import org.loversAPP.dao.UserItemMapper;
import org.loversAPP.model.TextRecords;
import org.loversAPP.service.UserTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@Service
public class UserTextServiceImpl implements UserTextService {
    @Autowired
    private TextRecordsMapper textRecordsMapper;
    @Autowired
    private UserItemMapper userItemMapper;
    public Integer insertText(Integer recordsID,Integer userID, String text, String longtitude, String latitude) {
        TextRecords textRecords=new TextRecords();
        textRecords.setUserid(userID);
        textRecords.setLatitude(latitude);
        textRecords.setText(text);
        textRecords.setLongtitude(longtitude);
        textRecords.setPublishdate(new Date());
        textRecords.setRecordsid(recordsID);
        return textRecordsMapper.insert(textRecords);
    }
    public List<UserText> getTextsByUserID(Integer userID) {
        return textRecordsMapper.getTextsByUserID(userID);
    }

    public List<UserText> getTextsByRecordsID(Integer recordID) {
        return textRecordsMapper.getTextsByRecordsID(recordID);
    }
    public Integer deleteTextByID(Integer id) {
        return textRecordsMapper.deleteByPrimaryKey(id);
    }

    public List<TextRecords> getTextRecordsByiuserid() {
        return textRecordsMapper.getTextRecordsByiuserid();
    }
}
