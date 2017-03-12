package org.loversAPP.service.Impl;

import org.loversAPP.dao.LoverShipMapper;
import org.loversAPP.dao.UserMapper;
import org.loversAPP.model.LoverShip;
import org.loversAPP.model.LoverShipExample;
import org.loversAPP.model.User;
import org.loversAPP.service.LoverShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.DEFAULT)
    public Integer insertLoverShip(LoverShip loverShip) {
        final User girl=userMapper.selectByPrimaryKey(loverShip.getLovergirlid());//邀请者
        final User boy=userMapper.selectByPrimaryKey(loverShip.getLoverboyid());//被邀请者
        if (girl!=null&&boy!=null) {
            girl.setStauts(1);
            boy.setStauts(1);
            userMapper.updateByPrimaryKeySelective(boy);
            userMapper.updateByPrimaryKeySelective(girl);
            return loverShipMapper.insertSelective(loverShip);
        }
        else {
            return -1;
        }


    }

    @Override
    public String getloveIDByID(Integer id) {
        LoverShip loverShip=loverShipMapper.LoverShipIdByID(id);
        if(loverShip!=null){
            return loverShip.getLoverid();
        }
        else {
            return null;
        }
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

    /**
     *    解除恋爱关系
     *   1.用户双方status 都变为0
     2.Activityrecord 跟loveship表 删除
     * @param loverID
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.DEFAULT)
    public Integer deleteLoveShipByID(String loverID) {

        LoverShipExample loverShipExample=new LoverShipExample();
        loverShipExample.createCriteria().andLoveridEqualTo(loverID);
        LoverShip loverShip=loverShipMapper.selectByExample(loverShipExample).get(0);
        User boy=userMapper.selectByPrimaryKey(loverShip.getLoverboyid());
        User girl=userMapper.selectByPrimaryKey(loverShip.getLovergirlid());
        boy.setStauts(0);
        girl.setStauts(0);
        userMapper.updateByPrimaryKeySelective(boy);
        userMapper.updateByPrimaryKeySelective(girl);
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
    public Integer updateStateByID(String loverID, Integer state) {
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
