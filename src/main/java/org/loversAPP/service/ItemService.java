package org.loversAPP.service;

import org.loversAPP.DTO.ItemCountWrapper;
import org.loversAPP.DTO.UserItemCount;
import org.loversAPP.model.Item;
import org.loversAPP.model.UserItem;
import org.loversAPP.model.UserOneItem;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
public interface ItemService {
    public Integer insertItem(String itemName, String itemFunction,
                              Long price, String itemImage, Integer itemType, Integer itemlevel, Integer itemPrivilege);

    public Integer insertUserItem(Integer userID, Integer itemID);

    public Integer deleteUserItemByID(Integer userID,int itemID);
    public List<Item> getAllItems();
    public List<Item> getItemsByType(Integer itemType);

    public Item getItemByID(Integer ID);
    public Integer deleteItemByID(Integer itemId);

    public List<UserItemCount> getItemsByUID(Integer usID);

    public List<ItemCountWrapper> getItemsCountByUIDForEach(int userid);


    public int doodlePhoto(int photoID, String photo, int userItemID);

    public int getCountUserItemByid(int userid);
    public int updateUserItemCount(int userid, int count);

    public UserItem getUserItemByUsERid(int userid);
    public UserItem getUserItemByID(int ID);
    public int  insertbatchUseritrems(List<UserItem> userItems);
    List<UserOneItem> getUserOneItems(int userid);
    public int maxIDu(int userid,int itemID);

    public int deleteUSERtoItems(int id);

    public List<Item> getItemsByPrivilege(int prioi);

    public int insertIntoUserOneItem(UserOneItem userOneItem);

    public int deletUserOneItem(int id);
    public UserItem   getSpeicUseritembY(int userid, int itemid);

    int updateUserItemBindItemIDCount(Integer userID,int itemid, int count);
}
