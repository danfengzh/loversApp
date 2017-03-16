package org.loversAPP.service;

import org.loversAPP.model.Moment;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public interface MomentService {
    public int insertMoment(Moment moment);

    public int deleteMomentByID(int id);

    public List<Moment> getMommentByUID(int userID);

    public Moment getMommentByID(int id);

}
