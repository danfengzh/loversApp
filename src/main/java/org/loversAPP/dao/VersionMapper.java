package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.DTO.MyVersion;
import org.loversAPP.model.Version;
import org.loversAPP.model.VersionExample;

import java.util.List;

public interface VersionMapper {
    long countByExample(VersionExample example);

    int deleteByExample(VersionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Version record);

    int insertSelective(Version record);

    List<Version> selectByExample(VersionExample example);

    Version selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Version record, @Param("example") VersionExample example);

    int updateByExample(@Param("record") Version record, @Param("example") VersionExample example);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKey(Version record);

    MyVersion getMyversion();
}