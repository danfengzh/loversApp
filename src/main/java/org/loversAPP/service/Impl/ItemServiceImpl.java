package org.loversAPP.service.Impl;

import org.loversAPP.DTO.ItemCountWrapper;
import org.loversAPP.dao.DoodlePhotoMapper;
import org.loversAPP.dao.ItemMapper;
import org.loversAPP.dao.UserItemMapper;
import org.loversAPP.dao.UserMapper;
import org.loversAPP.model.*;
import org.loversAPP.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private DoodlePhotoMapper doodlePhotoMapper;
    @Autowired
    private UserItemMapper userItemMapper;
    @Autowired
    private UserMapper userMapper;
    
    public Integer insertItem(String itemName, String itemFunction, Long price, String itemImage,Integer itemType) {
        Item item=new Item();
        item.setItemname(itemName);
        item.setItemfunction(itemFunction);
        item.setItemprice(price);
        item.setItemimage(itemImage);
        item.setItemtype(2);
        return itemMapper.insertSelective(item);
    }

    
    public Integer insertUserItem(Integer userID, Integer itemID) {
        UserItem userItem=new UserItem();
        userItem.setUserId(userID);
        userItem.setItemId(itemID);
        return userItemMapper.insert(userItem);
    }

    
    public Integer deleteUserItemByID(Integer userID) {
        UserItemExample userItemExample=new UserItemExample();
        userItemExample.createCriteria().andUserIdEqualTo(userID);
        return userItemMapper.deleteByExample(userItemExample);
    }

    
    public List<Item> getAllItems() {
        return itemMapper.getAllItems();
    }
    
    public List<Item> getItemsByType(Integer itemType) {
        ItemExample itemExample=new ItemExample();
        itemExample.createCriteria().andItemtypeEqualTo(itemType);
        return itemMapper.selectByExample(itemExample);
    }
    public Item getItemByID(Integer ID) {
        return itemMapper.selectByPrimaryKey(ID);
    }
    public Integer deleteItemByID(Integer itemId) {
        return itemMapper.deleteByPrimaryKey(itemId);
    }
    /**
     * 根据用户id来获取道具
     * @param usID
     * @return
     */
    
    public List<Item> getItemsByUID(Integer usID) {

        return itemMapper.getItemsByUID(usID);
    }

    public List<ItemCountWrapper> getItemsCountByUIDForEach(int userid) {
        return itemMapper.getItemsCountByUIDForEach(userid);
    }

    public int doodlePhoto(int photoID, String photo, int userItemID) {
        DoodlePhoto doodlePhoto=new DoodlePhoto();
        doodlePhoto.setDoodletime(new Date());
        doodlePhoto.setPhotoid(photoID);
        doodlePhoto.setUseritemid(userItemID);
        //通过photoId可以得到recordid---loverid---双方的id
        return doodlePhotoMapper.insertSelective(doodlePhoto);//仅仅完成涂鸦照片的删除操作
    }
}
