package org.loversAPP.service;

import org.junit.Test;
import org.loversAPP.model.Item;
import org.loversAPP.model.UserItem;
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
      int s=  itemService.maxIDu(2,10);
        System.out.println("cccc");
    }
    @Test
    public void wwuuuw() throws Exception {
   List<UserOneItem> userOneItems= itemService.getUserOneItems(10);
        System.out.println("*************");
    }
    @Test
    public void test(){
        UserItem userItem=itemService.getSpeicUseritembY(47,10);
        UserOneItem userOneItem=new UserOneItem();
        if(userItem==null)
        {
            itemService.insertUserItem( 47,10);
            userOneItem.setItemid(47);
            userOneItem.setUserid(10);
        }
        else
        {
           // itemService.updateUserItemBindItemIDCount(47,userItem.getCount()+1);
            userOneItem.setItemid(userItem.getItemId());
            userOneItem.setUserid(userItem.getUserId());
        }
        itemService.insertIntoUserOneItem(userOneItem);
        System.out.println("vvv");
    }
}