package org.loversAPP.service;

import org.loversAPP.DTO.UserPhoto;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface UserPhoService {

    public Integer insertPhoto(Integer recordsID,Integer userItemID,Integer userID,String photo,String content
            ,String longtitude,String latitude);

    /**
     * user表与photo_records表联合查询
     * @param recordsID
     * @return
     */
    public UserPhoto getPhotosByUserID(Integer recordsID);

    public Integer deletePhotoByID(Integer id);
}
