package org.loversAPP.service.Impl;

import org.loversAPP.DTO.LoverDogCount;
import org.loversAPP.dao.LoverDogMapper;
import org.loversAPP.model.LoverDog;
import org.loversAPP.service.LoverDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 */
@Service
public class LoverDogServiceImpl implements LoverDogService {
    @Autowired
    private LoverDogMapper  loverDogMapper;
    public int inserLoverDog(LoverDog loverDog) {
        return loverDogMapper.insertLoverDog(loverDog);
    }

    public List<LoverDogCount> getLoverDogCount() {
        return loverDogMapper.getLoverDogCount();
    }

    public int deleteLoverDogByID(int id) {
        return loverDogMapper.deleteLoverDogByID(id);
    }
}
