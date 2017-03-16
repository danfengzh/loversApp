package org.loversAPP.service;

import org.loversAPP.DTO.UserPhoto;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface UserPhoService {

    public Integer insertPhoto(Integer recordsID,Integer userID,String photo,String content
            ,String longtitude,String latitude);

    /**
     * user表与photo_records表联合查询
     * @param
     * @return
     */
    public List<UserPhoto> getPhotosByUserID(Integer userid);
    public List<UserPhoto> getPhotosByRecordsID (Integer recoiD);
    public Integer deletePhotoByID(Integer id);

    public int deletePhotoByID(int id);
}
