package org.loversAPP.dao;

import java.util.List;
import org.loversAPP.model.Item;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    Item selectByPrimaryKey(Integer id);

    List<Item> selectAll();

    int updateByPrimaryKey(Item record);
}