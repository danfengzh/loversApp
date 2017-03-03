package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.Test.model.TextRecords;
import org.loversAPP.Test.model.TextRecordsExample;

import java.util.List;

public interface TextRecordsMapper {
    long countByExample(TextRecordsExample example);

    int deleteByExample(TextRecordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TextRecords record);

    int insertSelective(TextRecords record);

    List<TextRecords> selectByExample(TextRecordsExample example);

    TextRecords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TextRecords record, @Param("example") TextRecordsExample example);

    int updateByExample(@Param("record") TextRecords record, @Param("example") TextRecordsExample example);

    int updateByPrimaryKeySelective(TextRecords record);

    int updateByPrimaryKey(TextRecords record);
}