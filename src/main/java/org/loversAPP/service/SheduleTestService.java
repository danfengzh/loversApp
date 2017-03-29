package org.loversAPP.service;

import org.loversAPP.model.SheduleTest;

/**
 * Created by Administrator on 2017/3/28.
 */
public interface SheduleTestService {

    public int insertSheduleTest(SheduleTest sheduleTest);


    public int updateSheduleTestInfoByID(int id,String content);
}
