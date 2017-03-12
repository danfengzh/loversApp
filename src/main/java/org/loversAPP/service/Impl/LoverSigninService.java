package org.loversAPP.service.Impl;

import org.loversAPP.Controller.utils.DateUtil;
import org.loversAPP.dao.LoverShipMapper;
import org.loversAPP.dao.LoverSigninMapper;
import org.loversAPP.model.LoverShip;
import org.loversAPP.model.LoverSignin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/3/12.
 */
@Service
public class LoverSigninService {
    @Autowired
    private LoverSigninMapper loverSigninMapper;
    @Autowired
    private LoverShipMapper loverShipMapper;

    /**
     * 4.InsertLoverSignin(情侣一方进行签到，
     * 签到后根据halfID在lover_ship里面查找另一半的id在lover_signin里面今日是否有签到数据，
     * 如果没有返回code=201，有返回code=200)
     * @return
     */
    public Integer WhetherAnotherinsertLoverSignin(Integer halfID){
        LoverShip loverShip= loverShipMapper.LoverShipIdByID(halfID);
        Integer anotherID;
        if(loverShip!=null){

            if(loverShip.getLoverboyid()==halfID){
                anotherID=loverShip.getLovergirlid();
            }else{
                anotherID=loverShip.getLoverboyid();
            }
            LoverSignin tempLoverSign=new LoverSignin();
            tempLoverSign.setUserid(anotherID);
            tempLoverSign.setSignintime(DateUtil.getDay());
            return loverSigninMapper.selectHasSianTodayAnother(tempLoverSign);
        }
        return -1;
    }

    /**
     * 两个方法应该结合着来
     * @param halfID
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.DEFAULT)
    public Integer insertLoverSignin(Integer halfID){
        //仅仅一方进行签到
        LoverSignin loverSignin=new LoverSignin();
        //先判断自己今天是否已经签过到了，如果签了就不做任何处理
        loverSignin.setSignintime(DateUtil.getDay());
        loverSignin.setHalfid(halfID);
        if (loverSigninMapper.selectHasSianToday(loverSignin)==0) {
            loverSignin.setHalfid(halfID);
            loverSignin.setSignintime(DateUtil.getDay());
            int  count = loverSigninMapper.insertSelective(loverSignin);
            return count;
        } else {
            return 0;
        }

    }
}
