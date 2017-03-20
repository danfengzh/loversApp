package org.loversAPP.service.Impl;

import org.loversAPP.DTO.FriendIDs;
import org.loversAPP.DTO.SuperLoverInfo;
import org.loversAPP.dao.*;
import org.loversAPP.model.*;
import org.loversAPP.service.LoverShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
@Service
public class LoverShipServiceImpl implements LoverShipService {
    @Autowired
    private LoverShipMapper loverShipMapper;
    @Autowired
    private PhotoRecordsMapper photoRecordsMapper;
    @Autowired
    private ActivityrecordsMapper activityrecordsMapper;
    @Autowired
    private TextRecordsMapper textRecordsMapper;
    @Autowired
    private LoverSigninMapper loverSigninMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public LoverShip QueryLoverShip_HasLoveShip(Integer boyId, Integer GirlID) {

        LoverShip loverShip= loverShipMapper.selectSelectiveByPrimaryKey(boyId,GirlID);
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


        LoverShipExample loverShipExample=new LoverShipExample();
        loverShipExample.setOrderByClause("loveindex DESC");
        return loverShipMapper.selectByExample(loverShipExample);
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
     *
     * @return
     */
    @Override
    public User getHalfByID(Integer loverID) {
        User half;
        LoverShip loverShip=loverShipMapper.LoverShipIdByID(loverID);
        if(loverShip.getLoverboyid().equals(loverID)){
            half=userMapper.selectByPrimaryKey(loverShip.getLovergirlid());
        }
        else {
            half=userMapper.selectByPrimaryKey(loverShip.getLoverboyid());
        }
        return half;
    }

    @Override
    public List<SuperLoverInfo> getAllSuperLoverInfo() {
        List<LoverShip> loverShips=getAllLoveShips();
        List<SuperLoverInfo> superLoverInfos=new ArrayList<>();
        for(LoverShip friend:loverShips){
            SuperLoverInfo superLoverInfo=new SuperLoverInfo();
            User boy=userMapper.selectByPrimaryKey(friend.getLoverboyid());
            User girl=userMapper.selectByPrimaryKey(friend.getLovergirlid());
            superLoverInfo.setBoyavatar(boy.getAvator());
            superLoverInfo.setGirlavatar(girl.getAvator());
            superLoverInfo.setBoyname(boy.getUsername());
            superLoverInfo.setGirlname(girl.getUsername());
            superLoverInfo.setLoverid(friend.getLoverid());
            superLoverInfo.setLovetime(friend.getLovetime());
            superLoverInfo.setLoveindex(friend.getLoveindex());
            superLoverInfo.setState(friend.getState());
            superLoverInfo.setLoverboyid(friend.getLoverboyid());
            superLoverInfo.setLovergirlid(friend.getLovergirlid());
            superLoverInfos.add(superLoverInfo);
        }
        return superLoverInfos;
    }

    @Override
    public List<FriendIDs> getAllFriendIS() {
        return loverShipMapper.getAllFriendIS();
    }

    /**
     * 根据loverID解除恋爱关系 ，同时会删除活动记录 ，以及活动记录附属的相册记录和 纸条记录
     * 以及个人拥有的宝藏
     * @param loverID
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int cancelLoveShip(String loverID) {

        Activityrecords activityrecor;
        ActivityrecordsExample activityrecordsExample=new ActivityrecordsExample();
        activityrecordsExample.createCriteria().andLoveridEqualTo(loverID);
        List<Activityrecords> activityrecordss=activityrecordsMapper.selectByExample(activityrecordsExample);
        PhotoRecordsExample photoRecordsExample=new PhotoRecordsExample();
        TextRecordsExample textRecordsExample=new TextRecordsExample();
        FriendIDs friendIDs;

        if(activityrecordss!=null){
            activityrecor=activityrecordss.get(0);
            photoRecordsExample.createCriteria().andRecordsidEqualTo(activityrecor.getId());
            textRecordsExample.createCriteria().andRecordsidEqualTo(activityrecor.getId());
            friendIDs=loverShipMapper.getFriendIS(loverID);
            loverShipMapper.deleteByLoversID(loverID);
            photoRecordsMapper.deleteByExample(photoRecordsExample);//删除照片
            textRecordsMapper.deleteByExample(textRecordsExample);//删除消息
            LoverSigninExample loverSigninExample=new LoverSigninExample();
            List listIS=new ArrayList();
            listIS.add(friendIDs.getLoverBoyID());
            listIS.add(friendIDs.getLoverGirlID());
            loverSigninExample.createCriteria().andHalfidIn(listIS);
            LoverSigninExample loverSigninExample2=new LoverSigninExample();
            loverSigninExample2.createCriteria().andIdIn(listIS);
            loverSigninMapper.deleteByExample(loverSigninExample2);
            //同时将两者的用户信息  归位置
            User boy=new User();
            boy.setId(friendIDs.getLoverBoyID());
            boy.setMoney(0);
            boy.setExp(0);
            boy.setLevel(0);
            boy.setStauts(1);
            boy.setStepstoday(0);
            boy.setCheckindays(0);
            User girl=new User();
            girl.setId(friendIDs.getLoverBoyID());
            girl.setMoney(0);
            girl.setExp(0);
            girl.setLevel(0);
            girl.setStauts(1);
            girl.setStepstoday(0);
            girl.setCheckindays(0);
            userMapper.updateByPrimaryKeySelective(girl);
        }

        return 1;
    }

    @Override
    public int cancelByIdsLoveShip(Integer loverAID, Integer loverBID) {
        //删除loverShip --
        loverShipMapper.deleteByPrimaryKey(loverAID,loverBID);
        return 0;
    }
}
