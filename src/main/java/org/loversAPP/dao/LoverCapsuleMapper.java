package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.LoverCapsule;
import org.loversAPP.model.LoverCapsuleExample;

import java.util.List;

public interface LoverCapsuleMapper {
    long countByExample(LoverCapsuleExample example);

    int deleteByExample(LoverCapsuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoverCapsule record);

    int insertSelective(LoverCapsule record);

    List<LoverCapsule> selectByExample(LoverCapsuleExample example);

    LoverCapsule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoverCapsule record, @Param("example") LoverCapsuleExample example);

    int updateByExample(@Param("record") LoverCapsule record, @Param("example") LoverCapsuleExample example);

    int updateByPrimaryKeySelective(LoverCapsule record);

    int updateByPrimaryKey(LoverCapsule record);

    int setStateByID(@Param("id") int id, @Param("state") String state);

    List<LoverCapsule> getCaspule();

    String getLoverCasuleStateBy(@Param("receiverID")int receiverID);

    LoverCapsule getLoverCasuleByRecID(@Param("receiverID")int receiverID);

    List<LoverCapsule> getAllCanOpenLoverCasules(@Param("receiverID")int recvierID);
}