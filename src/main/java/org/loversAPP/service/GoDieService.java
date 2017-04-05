package org.loversAPP.service;

import org.loversAPP.DTO.GoDieFeeBack;
import org.loversAPP.DTO.TempGoDie;
import org.loversAPP.model.GoDie;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public interface GoDieService {
    public int getDogActByID(int userID);

    public int insertGoDie(GoDie goDie);

    public GoDieFeeBack getGoDieFeedBackByID(int userID);


    public int deleteGoDieByID(int userID);

    public List<TempGoDie> getTempGoDie();

    int deleteGoDieByPrimairyKey(int id);
}
