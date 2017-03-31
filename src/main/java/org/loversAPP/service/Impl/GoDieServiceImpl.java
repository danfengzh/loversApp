package org.loversAPP.service.Impl;

import org.loversAPP.dao.GoDieMapper;
import org.loversAPP.model.GoDie;
import org.loversAPP.service.GoDieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/31.
 */
@Service
public class GoDieServiceImpl implements GoDieService {
    @Autowired
    private GoDieMapper goDieMapper;
    public int getDogActByID(int userID) {
        return goDieMapper.getDogActByID(userID);
    }

    public int insertGoDie(GoDie goDie) {
        goDie.setTime(new Date());
        return goDieMapper.insertSelective(goDie);
    }
}
