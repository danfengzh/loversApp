package org.loversAPP.service.Impl;

import org.loversAPP.DTO.UserText;
import org.loversAPP.dao.TextRecordsMapper;
import org.loversAPP.service.UserTextService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@Service
public class UserTextServiceImpl implements UserTextService {
    private TextRecordsMapper textRecordsMapper;
    @Override
    public Integer insertText(Integer recordsID, Integer userItemID, Integer userID, String text, String longtitude, String latitude) {
        return null;
    }



    @Override
    public List<UserText> getTextsByUserID(Integer userID) {
        return textRecordsMapper.getTextsByUserID(userID);
    }

    @Override
    public List<UserText> getTextsByRecordsID(Integer recordID) {
        return textRecordsMapper.getTextsByRecordsID(recordID);
    }

    @Override
    public Integer deleteTextByID(Integer id) {
        return textRecordsMapper.deleteByPrimaryKey(id);
    }
}
