package org.loversAPP.service.Impl;

import org.loversAPP.DTO.FriendPhoto;
import org.loversAPP.DTO.FriendText;
import org.loversAPP.dao.ActivityrecordsMapper;
import org.loversAPP.dao.TextRecordsMapper;
import org.loversAPP.model.Activityrecords;
import org.loversAPP.model.ActivityrecordsExample;
import org.loversAPP.dao.PhotoRecordsMapper;
import org.loversAPP.service.ActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
@Service
public class ActivityRecordServiceImpl implements ActivityRecordService{
    @Autowired
    private ActivityrecordsMapper activityrecordsMapper;
    @Autowired
    private TextRecordsMapper textRecordsMapper;

    @Autowired
    private PhotoRecordsMapper photoRecordsMapper;
    @Override
    public Integer deleteActiityRecords(String loverID) {
        ActivityrecordsExample activityrecordsExample=new ActivityrecordsExample();
        activityrecordsExample.createCriteria().andLoveridEqualTo(loverID);
        return activityrecordsMapper.deleteByExample(activityrecordsExample);
    }

    @Override
    public Integer insertRecord(String loverID, String longtitude, String latitude) {
        Activityrecords activityrecords=new Activityrecords();
        activityrecords.setLoverid(loverID);
        activityrecords.setLongtitude(longtitude);
        activityrecords.setLatitude(latitude);
        return activityrecordsMapper.insertSelective(activityrecords);
    }

    @Override
    public Integer getIDByLoverID(String loverID) {
        ActivityrecordsExample activityrecordsExample=new ActivityrecordsExample();
        activityrecordsExample.createCriteria().andLoveridEqualTo(loverID);
        List<Activityrecords> activityrecordss=activityrecordsMapper.selectByExample(activityrecordsExample);
        if(activityrecordss!=null){
            return activityrecordss.get(0).getId();
        }
        else {
            return -1;
        }
    }

    @Override
    public Activityrecords getRecordByID(Integer id) {
        ActivityrecordsExample activityrecordsExample=new ActivityrecordsExample();
        activityrecordsExample.createCriteria().andIdEqualTo(id);
        List<Activityrecords> activityrecordss= activityrecordsMapper.selectByExample(activityrecordsExample);
        if(activityrecordss!=null){
            return activityrecordss.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public Integer updateTotalStepsByID(Integer id,Integer totalSteps) {
        Activityrecords activityrecords=new Activityrecords();
        activityrecords.setId(id);
        activityrecords.setTotalsteps(totalSteps);
        updateActivityInfosByid(activityrecords);
        return updateActivityInfosByid(activityrecords);
    }

    @Override
    public List<Activityrecords> getAllRecords() {

        return activityrecordsMapper.selectActivityRecords();
    }

    @Override
    public Integer deleteRecordByID(Integer id) {

        ActivityrecordsExample activityrecordsExample=new ActivityrecordsExample();
        activityrecordsExample.createCriteria().andIdEqualTo(id);
        return activityrecordsMapper.deleteByExample(activityrecordsExample);
    }
    private Integer updateActivityInfosByid(Activityrecords activityrecords){

        Integer c=    activityrecordsMapper.updateSelectiveByid(activityrecords);
        return c;

    }
    @Override
    public Integer updateLocationByID(Integer id,String longatitude,String latitude) {

        Activityrecords activityrecords=new Activityrecords();
        activityrecords.setId(id);
        activityrecords.setLongtitude(latitude);
        activityrecords.setLatitude(latitude);
        updateActivityInfosByid(activityrecords);
        return updateActivityInfosByid(activityrecords);
    }

    @Override
    public Integer insertPhotoRecords() {
        return null;
    }

    @Override
    public FriendPhoto getPhotosByRecordsID(Integer id) {

        return null;
    }

    @Override
    public FriendText getTextsByUserID(Integer userID) {
        return null;
    }

    @Override
    public FriendText getTextsByRecordsID(Integer textRecoID) {
       return null;
    }

    @Override
    public Integer deleteTextByID(Integer textID) {

        return null;
    }

    @Override
    public Integer deletePhotoByID(Integer photoID) {

        return null;
    }

    @Override
    public Integer updateRadiusByID(Integer id, Integer radius) {
        Activityrecords activityrecords=new Activityrecords();
        activityrecords.setId(id);
        activityrecords.setRadius(radius);
        updateActivityInfosByid(activityrecords);
        return updateActivityInfosByid(activityrecords);
    }
}
