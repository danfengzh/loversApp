package org.loversAPP.dao;

import org.apache.ibatis.annotations.Param;
import org.loversAPP.DTO.ItemCountWrapper;
import org.loversAPP.DTO.UserItemCount;
import org.loversAPP.model.Item;
import org.loversAPP.model.ItemExample;
import org.loversAPP.model.UserItem;

import java.util.List;

public interface ItemMapper {
    long countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
    List<Item>  getAllItems();
    List<Item> getItemsByUID(@Param("userID") Integer userID);
    List<UserItemCount> getItemsByiid(@Param("userID") Integer userID);
    public List<ItemCountWrapper> getItemsCountByUIDForEach(@Param("userid") Integer userid);

    int getCountUserItemByid(@Param("userid") int userid);

    int updateUserItemCount(@Param("userid") int userid,@Param("count") int count);

    UserItem getUserItemByUsERid(@Param("userid")int userid);

    List<Item> getItemsByPrivilege(@Param("prioi") int prioi);
}