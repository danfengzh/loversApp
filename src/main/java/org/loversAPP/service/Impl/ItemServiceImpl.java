
package org.loversAPP.service.Impl;

import org.loversAPP.DTO.ItemCountWrapper;
import org.loversAPP.DTO.UserItemCount;
import org.loversAPP.dao.*;
import org.loversAPP.model.*;
import org.loversAPP.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
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
    @Autowired
    private UserOneItemMapper userOneItemMapper;

    public Integer insertItem(String itemName, String itemFunction, Long price,
                              String itemImage,Integer itemType,Integer itemlevel ,Integer itemPrivilege) {
        Item item=new Item();
        item.setItemname(itemName);
        item.setItemfunction(itemFunction);
        item.setItemprice(price);
        item.setItemimage(itemImage);
        item.setItemtype(2);
        item.setItemPrivilege(itemPrivilege);
        item.setItemLevel(itemlevel);
        return itemMapper.insertSelective(item);
    }


    public Integer insertUserItem(Integer userID, Integer itemID) {
        UserItem userItem=new UserItem();
        userItem.setUserId(userID);
        userItem.setItemId(itemID);
        userItem.setCount(1);
        return userItemMapper.insert(userItem);
    }


    public Integer deleteUserItemByID(Integer userID,int itemID) {
        UserItemExample userItemExample=new UserItemExample();
        userItemExample.createCriteria().andUserIdEqualTo(userID).andItemIdEqualTo(itemID);
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



    public List<UserItemCount> getItemsByUID(Integer usID) {

        return itemMapper.getItemsByiid(usID);
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

    public int getCountUserItemByid(int userid) {
        return itemMapper.getCountUserItemByid(userid);
    }

    public int updateUserItemCount(int userid,int count) {
        return itemMapper.updateUserItemCount(userid,count);
    }

    public UserItem getUserItemByUsERid(int userid) {

        return itemMapper.getUserItemByUsERid(userid);
    }

    public UserItem getUserItemByID(int ID) {
        return userItemMapper.getUserItemByID(ID);
    }

    public int insertbatchUseritrems(List<UserItem> userItems) {
        return userOneItemMapper.inserBathUserOneItem(userItems);
    }
    public List<UserOneItem> getUserOneItems(int userid) {
        UserOneItemExample userOneItemExample=new UserOneItemExample();
        userOneItemExample.createCriteria().andUseridEqualTo(userid);
        return userOneItemMapper.selectByExample(userOneItemExample);
    }

    public int maxIDu(int userid,int itemID) {
        return userOneItemMapper.maxIDu(userid,itemID);
    }

    public int deleteUSERtoItems(int id) {
        return userOneItemMapper.deleteByPrimaryKey(id);
    }

    public List<Item> getItemsByPrivilege(int prioi) {
        return itemMapper.getItemsByPrivilege(prioi);
    }

    public int insertIntoUserOneItem(UserOneItem userOneItem) {
        return userOneItemMapper.insertIntoUserOneItem(userOneItem);
    }

    public int deletUserOneItem(int id) {
        return userOneItemMapper.deleteByPrimaryKey(id);
    }

    public UserItem getSpeicUseritembY(int userid, int itemid) {
        return userItemMapper.getSpeicUseritembY(userid,itemid);
    }

    public int updateUserItemBindItemIDCount(Integer userID, int itemId, int count) {
        return userItemMapper.updateUserItemBindItemIDCount(userID,itemId,count);
    }
}

