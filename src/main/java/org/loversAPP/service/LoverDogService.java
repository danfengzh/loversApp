package org.loversAPP.service;

import org.loversAPP.DTO.LoverDogCount;
import org.loversAPP.model.LoverDog;

import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 */

public interface LoverDogService {
    public int inserLoverDog(LoverDog loverDog);

    public List<LoverDogCount> getLoverDogCount();

    int deleteLoverDogByID(int id);
}
