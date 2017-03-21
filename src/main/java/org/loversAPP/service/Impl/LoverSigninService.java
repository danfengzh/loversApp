package org.loversAPP.service.Impl;

import org.loversAPP.Controller.utils.DateUtil;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.dao.LoverShipMapper;
import org.loversAPP.dao.LoverSigninMapper;
import org.loversAPP.model.LoverShip;
import org.loversAPP.model.LoverSignin;
import org.loversAPP.model.LoverSigninExample;
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
            tempLoverSign.setId(anotherID);
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
    public FeedBack<String> insertLoverSignin(Integer halfID){
        FeedBack<String> feedBack;
        LoverShip loverShip=loverShipMapper.LoverShipIdByID(halfID);
        Integer anotherID;//另一半的id
        if(halfID.equals(loverShip.getLoverboyid())){
            anotherID=loverShip.getLovergirlid();
        }
        else {
            anotherID=loverShip.getLoverboyid();
        }

        //仅仅一方进行签到
        LoverSignin loverSignin1=new LoverSignin();
        //先判断自己今天是否已经签过到了，如果签了就不做任何处理
        loverSignin1.setSignintime(DateUtil.getDay());
        loverSignin1.setHalfid(halfID);
        LoverSignin loverSignin2=new LoverSignin();
        loverSignin2.setSignintime(DateUtil.getDay());
        loverSignin2.setHalfid(anotherID);
        LoverSignin result1=loverSigninMapper.selectSianToday(loverSignin1);
        LoverSignin result2=loverSigninMapper.selectSianToday(loverSignin2);
        //快速失败
        if(result1!=null&&result2!=null){
            //双方都已经签到
            feedBack=new FeedBack("success","205");
            return feedBack;
        }
        System.out.println(result2+"****************"+result1);
        if(result1!=null||result2!=null){
            //anotherID  已经在halfid的w位置上进行签到，那么 就让当前的id在userid上进行签到
            //有一个人已经完成了签到，置于是halfID还是userid目前不知道---这种限定下已经签到 肯定是 halfID
            LoverSigninExample loverSigninExample=new LoverSigninExample();
            if(result1!=null&&result1.getHalfid().equals(halfID)){
                loverSignin1.setId(anotherID);
                loverSigninExample.createCriteria().andHalfidEqualTo(halfID);
                //一方重复签到
                feedBack=new FeedBack("success","206");
                return feedBack;
            }
            else if(result2!=null&&result2.getHalfid().equals(halfID)){
                loverSignin1.setId(anotherID);
                loverSigninExample.createCriteria().andHalfidEqualTo(halfID);
                //一方重复签到
                feedBack=new FeedBack("success","205");
                return feedBack;
            }
            else {
                loverSignin1.setId(halfID);
                loverSigninExample.createCriteria().andHalfidEqualTo(anotherID);
            }
            loverSignin1.setHalfid(null);
            loverSigninExample.createCriteria().andHalfidEqualTo(halfID);
            loverSigninMapper.updateByExampleSelective(loverSignin1,loverSigninExample);
            feedBack=new FeedBack("success","203");
        }
        else {
            //没有人进行签到。。。。。。--直接将它插入数据库里面
            //默认插入为halfID
            loverSigninMapper.insertSelective(loverSignin1);
            feedBack=new FeedBack("success","202");
        }
        return feedBack;
    }
}
