package org.loversAPP.service.Impl;

import org.loversAPP.dao.ItemCapsuleDao;
import org.loversAPP.model.ItemCapsule;
import org.loversAPP.model.LoverCapsule;
import org.loversAPP.service.ItemCapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/3.
 */
@Service
public class ItemCapsuleServiceImpl implements ItemCapsuleService {
    @Autowired
    private ItemCapsuleDao itemCapsuleDao;
    public int insertItemCapsule(ItemCapsule itemCapsule) {
        return itemCapsuleDao.insertItemCapsule(itemCapsule);
    }
}
