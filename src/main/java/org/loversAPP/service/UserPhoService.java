package org.loversAPP.service;

import org.loversAPP.DTO.UserPhoto;
import org.loversAPP.model.PhotoRecords;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface UserPhoService {

    public Integer insertPhoto(Integer recordsID, Integer userID, String photo, String content
            , String longtitude, String latitude);

    /**
     * user表与photo_records表联合查询
     * @param
     * @return
     */
    public List<UserPhoto> getPhotosByUserID(Integer userid);
    public List<UserPhoto> getPhotosByRecordsID(Integer recoiD);
    public Integer deletePhotoByID(Integer id);

    public int deletePhotoByID(int id);

    public List<PhotoRecords> getOuterUserPhotosByUseriD();

    List<UserPhoto> getPhotosExceptOne(Integer userID);

    public UserPhoto getUserPhotoByPhotoID(int photoID);

    public int getUserIDbyPhoid(int phoID);

    int updateUserPhoUrlByUserID(int trueUserid, String photo);
}
