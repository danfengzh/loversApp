package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.MessageRead;

/**
 * Created by Administrator on 2017/4/3.
 */
public interface MessageReadDao {
    public int insertMessageRead(@Param("messageRead") MessageRead messageRead);

}
