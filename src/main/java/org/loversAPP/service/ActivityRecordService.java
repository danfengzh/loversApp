package org.loversAPP.service;

import org.loversAPP.DTO.FriendPhoto;
import org.loversAPP.DTO.FriendText;
import org.loversAPP.model.Activityrecords;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
public interface ActivityRecordService {

    public Integer deleteActiityRecords(String loverID);

    public Integer insertRecord(String loverID,String longtitude ,String latitude);

    public Integer getIDByLoverID(String loverID);

    public Activityrecords getRecordByID(Integer id);


    public Integer updateTotalStepsByID(Integer id,Integer totalSteps);

    public List<Activityrecords> getAllRecords();


    public Integer deleteRecordByID(Integer id);


    public  Integer updateLocationByID(Integer id,String longatitude,String latitude);

    public Integer insertPhotoRecords();

    /**
     * user表与photo_records表联合查询
     * @param id
     * @return
     */
    public FriendPhoto getPhotosByRecordsID(Integer id);

    /**
     * user表与text_records表联合查询
     * @param userID
     * @return
     */
    public FriendText getTextsByUserID(Integer userID);

    /**
     * user表与text_records表联合查询
     * @param textRecoID
     * @return
     */
    public FriendText getTextsByRecordsID(Integer textRecoID);


    public Integer deleteTextByID(Integer textID);


    public Integer deletePhotoByID(Integer photoID);

    public Integer updateRadiusByID(Integer id,Integer radius);

}
