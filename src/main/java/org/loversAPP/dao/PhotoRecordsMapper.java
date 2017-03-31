package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.DTO.UserPhoto;
import org.loversAPP.model.PhotoRecordsExample;
import org.loversAPP.model.PhotoRecords;

import java.util.List;


public interface PhotoRecordsMapper {
    long countByExample(PhotoRecordsExample example);

    int deleteByExample(PhotoRecordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PhotoRecords record);

    int insertSelective(PhotoRecords record);

    List<PhotoRecords> selectByExample(PhotoRecordsExample example);

    PhotoRecords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PhotoRecords record, @Param("example") PhotoRecordsExample example);

    int updateByExample(@Param("record") PhotoRecords record, @Param("example") PhotoRecordsExample example);

    int updateByPrimaryKeySelective(PhotoRecords record);

    int updateByPrimaryKey(PhotoRecords record);
    List<UserPhoto> getPhotosByUserID(Integer userid);
    public List<UserPhoto> getPhotosByRecordsID (Integer recoiD);
    List<PhotoRecords> getOuterUserPhotosByUseriD();

    List<UserPhoto> getPhotosExceptOne(@Param("userID") Integer userID);
}