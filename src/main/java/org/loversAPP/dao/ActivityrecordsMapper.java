package org.loversAPP.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.Activityrecords;

public interface ActivityrecordsMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("loverid") String loverid);

    int insert(Activityrecords record);

    Activityrecords selectByPrimaryKey(@Param("id") Integer id, @Param("loverid") String loverid);

    List<Activityrecords> selectAll();

    int updateByPrimaryKey(Activityrecords record);
}