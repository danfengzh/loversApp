package org.loversAPP.service;

import org.loversAPP.model.LoverShip;
import org.loversAPP.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
public interface LoverShipService {

    public LoverShip QueryLoverShip_HasLoveShip(Integer boyId,Integer GirlID);
    public Integer insertLoverShip(LoverShip loverShip);
    public String getloveIDByID(Integer id);
    public LoverShip getLoverShipByID(String loverID);
    public List<LoverShip> getAllLoveShips();
    public Integer deleteLoveShipByID(String loverID);
    public Integer updateLoveIndexByID(String loverID,Integer loveIndex);
    public Integer updateStateByID(String loverID,String state);
    //根据loverID  和 userID获取另一半的信息
    public User getHalfByID(String loverID, Integer Aid);
}
