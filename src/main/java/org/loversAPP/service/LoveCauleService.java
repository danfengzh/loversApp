package org.loversAPP.service;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.LoverCapsule;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public interface LoveCauleService {

    public int insertCapsule(LoverCapsule loverCapsule);

    public int setStateByID(int id, String state);

    public LoverCapsule getCapsuleByID(int id);


    List<LoverCapsule> getCaspule();

    String getLoverCasuleStateBy( int receiverID);

    LoverCapsule getLoverCasuleByRecID(int receiverID);

    List<LoverCapsule> getAllCanOpenLoverCasules(int recvierID);
}
