package org.loversAPP.service.Impl;

import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.GoDieFeeBack;
import org.loversAPP.DTO.TempGoDie;
import org.loversAPP.dao.GoDieMapper;
import org.loversAPP.model.GoDie;
import org.loversAPP.service.GoDieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public GoDieFeeBack getGoDieFeedBackByID(int userID) {
        return goDieMapper.getGoDieFeedBackByID(userID);
    }

    public int deleteGoDieByID(int userID) {
        return goDieMapper.deleteGoDieByID(userID);
    }

    public List<TempGoDie> getTempGoDie() {
        return goDieMapper.getTempGoDie();
    }

    public int deleteGoDieByPrimairyKey(int id) {
        return goDieMapper.deleteGoDieByPrimairyKey(id);
    }


}
