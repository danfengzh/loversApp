package org.loversAPP.service.Impl;

import org.loversAPP.dao.UserOneItemMapper;
import org.loversAPP.model.UserItem;
import org.loversAPP.service.UserOneItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
@Service
public class UserOneItemServiceImpl implements UserOneItemService {
    @Autowired
    private UserOneItemMapper userOneItemMapper;
    public int inserBathUserOneItem(List<UserItem> userItems) {
        return userOneItemMapper.inserBathUserOneItem(userItems);
    }
}
