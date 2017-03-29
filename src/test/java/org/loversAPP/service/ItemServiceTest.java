package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.model.Item;
import org.loversAPP.model.UserOneItem;
import org.loversAPP.service.baseService.baseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
public class ItemServiceTest extends baseServiceTest {
    @Autowired
    private ItemService itemService;
    @Test
    public void insertItem() throws Exception {
        Item item=new Item();
        item.setItemimage("/ssss");
        item.setItemfunction("杀人");
        item.setItemprice(200l);
        item.setItemname("sjjjs");
        //  itemService.insertItem("钅我哦我ioasjasusuil","阿萨雅安就",2000l,"11314",4);
    }

    @Test
    public void insertUserItem() throws Exception {
       itemService.insertUserItem(17,1);
    }
    @Test
    public void www() throws Exception {
        itemService.deleteUserItemByID(17);
    }
    @Test
    public void wwuuuw() throws Exception {
   List<UserOneItem> userOneItems= itemService.getUserOneItems(10);
        System.out.println("*************");
    }
}