package org.loversAPP.service.Impl;

import org.loversAPP.dao.LoverCapsuleMapper;
import org.loversAPP.model.LoverCapsule;
import org.loversAPP.service.LoveCauleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@Service
public class LoveCauleServiceImpl implements LoveCauleService {
    @Autowired
    private LoverCapsuleMapper loverCapsuleMapper;
    public int insertCapsule(LoverCapsule loverCapsule) {
        return loverCapsuleMapper.insertSelective(loverCapsule);
    }

    public int setStateByID(int id,String state) {
        return loverCapsuleMapper.setStateByID(id,state);
    }

    public LoverCapsule getCapsuleByID(int id) {
        return loverCapsuleMapper.selectByPrimaryKey(id);
    }

    public List<LoverCapsule> getCaspule() {
        return loverCapsuleMapper.getCaspule();
    }

    public String getLoverCasuleStateBy(int receiverID) {
        return loverCapsuleMapper.getLoverCasuleStateBy(receiverID);
    }

    public LoverCapsule getLoverCasuleByRecID(int receiverID) {
        return loverCapsuleMapper.getLoverCasuleByRecID(receiverID);
    }

    public List<LoverCapsule> getAllCanOpenLoverCasules(int recvierID) {
        return loverCapsuleMapper.getAllCanOpenLoverCasules(recvierID);
    }
}

