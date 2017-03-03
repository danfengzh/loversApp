package org.loversAPP.model.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.Test.model.Activityrecords;
import org.loversAPP.Test.model.ActivityrecordsExample;

import java.util.List;

public interface ActivityrecordsMapper {
    long countByExample(ActivityrecordsExample example);

    int deleteByExample(ActivityrecordsExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("loverid") String loverid);

    int insert(Activityrecords record);

    int insertSelective(Activityrecords record);

    List<Activityrecords> selectByExample(ActivityrecordsExample example);

    Activityrecords selectByPrimaryKey(@Param("id") Integer id, @Param("loverid") String loverid);

    int updateByExampleSelective(@Param("record") Activityrecords record, @Param("example") ActivityrecordsExample example);

    int updateByExample(@Param("record") Activityrecords record, @Param("example") ActivityrecordsExample example);

    int updateByPrimaryKeySelective(Activityrecords record);

    int updateByPrimaryKey(Activityrecords record);
}