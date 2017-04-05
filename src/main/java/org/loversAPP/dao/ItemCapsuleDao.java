package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.model.ItemCapsule;

/**
 * Created by Administrator on 2017/4/3.
 */
public interface ItemCapsuleDao {

    public int  insertItemCapsule(@Param("itemCapsule") ItemCapsule itemCapsule);
}
