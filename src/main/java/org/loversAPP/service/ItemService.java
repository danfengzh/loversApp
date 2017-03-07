package org.loversAPP.service;

import org.loversAPP.model.Item;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
public interface ItemService {
    public Integer insertItem(String itemName ,String itemFunction ,Long price ,String itemImage,Integer itemType);

    public Integer insertUserItem(Integer userID ,Integer itemID);

    public Integer deleteUserItemByID(Integer userID);
    public List<Item> getAllItems();
    public List<Item> getItemsByType(Integer itemType);

    public Item getItemByID(Integer ID);
    public Integer deleteItemByID(Integer itemId);

    public List<Item> getItemsByUID(Integer usID);
}
