package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.UserCirCle;

/**
 * Created by Administrator on 2017/4/3.
 */
public interface UserCirCleDao {

    public int InserUserCirCle(@Param("userCirCle") UserCirCle userCirCle);
}
