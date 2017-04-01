package org.loversAPP.service;

import org.loversAPP.DTO.FriendIDs;
import org.loversAPP.DTO.SuperLoverInfo;
import org.loversAPP.model.LoverCapsule;
import org.loversAPP.model.LoverShip;
import org.loversAPP.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
public interface LoverShipService {

    public LoverShip QueryLoverShip_HasLoveShip(Integer boyId, Integer GirlID);
    public Integer insertLoverShip(LoverShip loverShip);
    public String getloveIDByID(Integer id);
    public LoverShip getLoverShipByID(String loverID);
    public List<LoverShip> getAllLoveShips();
    public Integer deleteLoveShipByID(String loverID);
    public Integer updateLoveIndexByID(String loverID, Integer loveIndex);
    public Integer updateStateByID(String loverID, Integer state);
    //根据loverID  和 userID获取另一半的信息
    public User getHalfByID(Integer Aid);

    public List<SuperLoverInfo> getAllSuperLoverInfo();
    public List<FriendIDs> getAllFriendIS();

    public int cancelLoveShip(String loverID);
    public int cancelByIdsLoveShip(Integer loverAID, Integer loverBID);

}
