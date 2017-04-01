package org.loversAPP.service;

import org.loversAPP.DTO.GoDieFeeBack;
import org.loversAPP.model.GoDie;

/**
 * Created by Administrator on 2017/3/31.
 */
public interface GoDieService {
    public int getDogActByID(int userID);

    public int insertGoDie(GoDie goDie);

    public GoDieFeeBack getGoDieFeedBackByID(int userID);
}
