package org.loversAPP.service.Impl;

import org.loversAPP.dao.ActivityrecordsMapper;
import org.loversAPP.service.ActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/23.
 */
@Service
public class ActivityRecordServiceImpl implements ActivityRecordService{
    @Autowired
    private ActivityrecordsMapper activityrecordsMapper;
    @Override
    public Integer deleteActiityRecords(String loverID) {
        return null;
    }
}
