package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.SheduleTest;

/**
 * Created by Administrator on 2017/3/28.
 */
public interface SheduleTestDao {
   public int insert(@Param("sheduleTest") SheduleTest sheduleTest);


   public int updateSheduleTestByID(@Param("id") int id,@Param("content") String content);

}
