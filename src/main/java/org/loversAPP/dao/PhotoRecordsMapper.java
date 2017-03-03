package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.Test.model.PhotoRecords;
import org.loversAPP.Test.model.PhotoRecordsExample;

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
}