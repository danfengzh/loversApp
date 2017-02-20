package org.loversAPP.service.Impl;

import org.loversAPP.dao.LoverShipMapper;
import org.loversAPP.dao.UserMapper;
import org.loversAPP.model.LoverShip;
import org.loversAPP.model.LoverShipExample;
import org.loversAPP.model.User;
import org.loversAPP.service.LoverShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
@Service
public class LoverShipServiceImpl implements LoverShipService {
    @Autowired
    private LoverShipMapper loverShipMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public LoverShip QueryLoverShip_HasLoveShip(Integer boyId, Integer GirlID) {

        LoverShip loverShip=  loverShipMapper.selectSelectiveByPrimaryKey(boyId,GirlID);
        return loverShip;
    }

    @Override
    public Integer insertLoverShip(LoverShip loverShip) {

        return loverShipMapper.insertSelective(loverShip);
    }

    @Override
    public String getloveIDByID(Integer id) {
        return loverShipMapper.LoverShipIdByID(id).getLoverid();
    }

    @Override
    public LoverShip getLoverShipByID(String loverID) {
        LoverShipExample loverShipExample=new LoverShipExample();
        loverShipExample.createCriteria().andLoveridEqualTo(loverID);
        List<LoverShip> loverShips=loverShipMapper.selectByExample(loverShipExample);
        if(loverShips.size()==1){
            return loverShips.get(0);
        }
        return null;
    }

    @Override
    public List<LoverShip> getAllLoveShips() {
        return loverShipMapper.selectByExample(new LoverShipExample());
    }

    @Override
    public Integer deleteLoveShipByID(String loverID) {
        LoverShipExample loverShipExample=new LoverShipExample();
        loverShipExample.createCriteria().andLoveridEqualTo(loverID);
        return loverShipMapper.deleteByExample(loverShipExample);
    }

    @Override
    public Integer updateLoveIndexByID(String loverID, Integer loveIndex) {
        LoverShipExample example=new LoverShipExample();
        example.createCriteria().andLoveridEqualTo(loverID);
        LoverShip loverShip=new LoverShip();
        loverShip.setLoveindex(loveIndex);
        return loverShipMapper.updateByExampleSelective(loverShip,example);
    }

    @Override
    public Integer updateStateByID(String loverID, String state) {
        LoverShipExample example=new LoverShipExample();
        example.createCriteria().andLoveridEqualTo(loverID);
        LoverShip loverShip=new LoverShip();
        loverShip.setState(state);
        return loverShipMapper.updateByExampleSelective(loverShip,example);
    }

    /**
     *   获取另一半的信息
     * @param loverID
     * @param Aid
     * @return
     */
    @Override
    public User getHalfByID(String loverID, Integer Aid) {
        User half;
        LoverShip loverShip=loverShipMapper.LoverShipIdByID(Aid);
        if(loverShip.getLoverboyid()==Aid){
            half=userMapper.selectByPrimaryKey(loverShip.getLovergirlid());
        }
        else {
            half=userMapper.selectByPrimaryKey(loverShip.getLoverboyid());
        }
        return half;
    }
}
