package org.loversAPP.service.Impl;

import org.loversAPP.dao.LoverShipMapper;
import org.loversAPP.model.LoverShip;
import org.loversAPP.service.LoverShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/17.
 */
@Service
public class LoverShipServiceImpl implements LoverShipService {
    @Autowired
    private LoverShipMapper loverShipMapper;
    @Override
    public LoverShip QueryLoverShip_HasLoveShip(Integer boyId, Integer GirlID) {

        LoverShip loverShip=  loverShipMapper.selectSelectiveByPrimaryKey(boyId,GirlID);
        return loverShip;
    }
}
