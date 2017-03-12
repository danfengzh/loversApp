package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.LoverSignin;
import org.loversAPP.model.LoverSigninExample;

import java.util.List;

public interface LoverSigninMapper {
    long countByExample(LoverSigninExample example);

    int deleteByExample(LoverSigninExample example);

    int insert(LoverSignin record);

    int insertSelective(LoverSignin record);

    List<LoverSignin> selectByExample(LoverSigninExample example);

    int updateByExampleSelective(@Param("record") LoverSignin record, @Param("example") LoverSigninExample example);

    int updateByExample(@Param("record") LoverSignin record, @Param("example") LoverSigninExample example);
    int selectHasSianToday(LoverSignin loverSignin);
    int selectHasSianTodayAnother(LoverSignin loverSignin);
}