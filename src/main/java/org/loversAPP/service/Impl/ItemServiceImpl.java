package org.loversAPP.service.Impl;

import com.lowagie.text.ListItem;
import org.loversAPP.dao.ItemMapper;
import org.loversAPP.dao.UserItemMapper;
import org.loversAPP.model.Item;
import org.loversAPP.model.ItemExample;
import org.loversAPP.model.UserItem;
import org.loversAPP.model.UserItemExample;
import org.loversAPP.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private UserItemMapper userItemMapper;
    @Override
    public Integer insertItem(String itemName, String itemFunction, Long price, String itemImage,Integer itemType) {
        Item item=new Item();
        item.setItemname(itemName);
        item.setItemfunction(itemFunction);
        item.setItemprice(price);
        item.setItemimage(itemImage);
        item.setItemtype(2);
        return itemMapper.insertSelective(item);
    }

    @Override
    public Integer insertUserItem(Integer userID, Integer itemID) {
        UserItem userItem=new UserItem();
        userItem.setUserId(userID);
        userItem.setItemId(itemID);
        return userItemMapper.insert(userItem);
    }

    @Override
    public Integer deleteUserItemByID(Integer userID) {
        UserItemExample userItemExample=new UserItemExample();
        userItemExample.createCriteria().andUserIdEqualTo(userID);
        return userItemMapper.deleteByExample(userItemExample);
    }

    @Override
    public List<Item> getAllItems() {
        return itemMapper.getAllItems();
    }
    @Override
    public List<Item> getItemsByType(Integer itemType) {
        ItemExample itemExample=new ItemExample();
        itemExample.createCriteria().andItemtypeEqualTo(itemType);
        return itemMapper.selectByExample(itemExample);
    }

    @Override
    public Item getItemByID(Integer ID) {
        return itemMapper.selectByPrimaryKey(ID);
    }

    @Override
    public Integer deleteItemByID(Integer itemId) {
        return itemMapper.deleteByPrimaryKey(itemId);
    }

    /**
     * 根据用户id来获取道具
     * @param usID
     * @return
     */
    @Override
    public List<Item> getItemsByUID(Integer usID) {

        return itemMapper.getItemsByUID(usID);
    }
}
