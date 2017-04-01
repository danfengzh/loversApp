package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.LoverDog;
import org.loversAPP.model.LoverDogExample;

import java.util.List;

public interface LoverDogMapper {
    long countByExample(LoverDogExample example);

    int deleteByExample(LoverDogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoverDog record);

    int insertSelective(LoverDog record);

    List<LoverDog> selectByExample(LoverDogExample example);

    LoverDog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoverDog record, @Param("example") LoverDogExample example);

    int updateByExample(@Param("record") LoverDog record, @Param("example") LoverDogExample example);

    int updateByPrimaryKeySelective(LoverDog record);

    int updateByPrimaryKey(LoverDog record);

    int getDogHeadByID(@Param("loverID") String loverID);
}