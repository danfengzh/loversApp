package org.loversAPP.service.Impl;

import org.loversAPP.dao.FinishStatusMapper;
import org.loversAPP.model.FinishStatus;
import org.loversAPP.model.FinishStatusExample;
import org.loversAPP.service.finishStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@Service
public class finishStatusServiceImpl implements finishStatusService {
    @Autowired
    private FinishStatusMapper finishStatusMapper;
    @Transactional
    public Integer finishStatus(Integer userID) {
        FinishStatus finishStatus=new FinishStatus();
        finishStatus.setUserid(userID);
        return finishStatusMapper.insertSelective(finishStatus);
    }
    public int setFinishStatusByUID(Integer userID,Integer status) {
        FinishStatus finishStatus=new FinishStatus();
        finishStatus.setFinishstatus(status);
        FinishStatusExample finishStatusExample=new FinishStatusExample();
        finishStatusExample.createCriteria().andUseridEqualTo(userID);
        finishStatusMapper.updateByExampleSelective(finishStatus,finishStatusExample);
        return status;
    }

    public FinishStatus getFinishStatusByUID(Integer userID) {
        FinishStatusExample finishStatusExample=new FinishStatusExample();
        finishStatusExample.createCriteria().andUseridEqualTo(userID);
        List<FinishStatus> finishStatuses= finishStatusMapper.selectByExample(finishStatusExample);
        if(finishStatuses!=null){
            return finishStatuses.get(0);
        }
        else {
            return null;
        }
    }
}
