package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.DTO.LoverDogCount;
import org.loversAPP.model.LoverDog;

import java.util.List;

public interface LoverDogMapper {
    public int insertLoverDog(@Param("loverDog") LoverDog loverDog);

    int getDogHeadByID(@Param("loverID") String loverID);

    List<LoverDogCount> getLoverDogCount();

    int deleteLoverDogByID(@Param("id") int id);
}