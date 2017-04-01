package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.DoodlePhoto;
import org.loversAPP.model.DoodlePhotoExample;

import java.util.List;

public interface DoodlePhotoMapper {
    long countByExample(DoodlePhotoExample example);

    int deleteByExample(DoodlePhotoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DoodlePhoto record);

    int insertSelective(DoodlePhoto record);

    List<DoodlePhoto> selectByExample(DoodlePhotoExample example);

    DoodlePhoto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DoodlePhoto record, @Param("example") DoodlePhotoExample example);

    int updateByExample(@Param("record") DoodlePhoto record, @Param("example") DoodlePhotoExample example);

    int updateByPrimaryKeySelective(DoodlePhoto record);

    int updateByPrimaryKey(DoodlePhoto record);

    List<DoodlePhoto> getAllDooolePhotos();
}