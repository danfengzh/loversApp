package org.loversAPP.service.Impl;

import org.loversAPP.DTO.UserText;
import org.loversAPP.service.UserTextService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/13.
 */
@Service
public class UserTextServiceImpl implements UserTextService {
    @Override
    public Integer insertText(Integer recordsID, Integer userItemID, Integer userID, String text, String longtitude, String latitude) {
        return null;
    }

    @Override
    public UserText getTextsByRecordsID(Integer recordsID) {
        return null;
    }

    @Override
    public Integer deleteTextByID(Integer id) {
        return null;
    }
}
