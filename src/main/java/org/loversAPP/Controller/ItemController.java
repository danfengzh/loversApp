package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.model.Item;
import org.loversAPP.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {
    @Autowired
    private ItemService itemService;
    @RequestMapping(value = "/insertItem",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack insertItem(String itemName ,String itemFunction ,Long price ,String itemImage,Integer itemType){
        FeedBack feedBack=null;
        int cos=itemService.insertItem(itemName,itemFunction,price,itemImage,itemType);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/insertUserItem",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack insertUserItem(Integer userID ,Integer itemID){
        FeedBack feedBack=null;
        int cos=itemService.insertUserItem( userID , itemID);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/deleteUserItemByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack deleteUserItemByID(@RequestParam("id") Integer id ){
        FeedBack feedBack=null;
        int cos=itemService.deleteUserItemByID( id);
        if(cos>=1){
            feedBack=new FeedBack("success","200");
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getAllItems",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Item> getAllItems( ){
        FeedBack feedBack=null;
        List<Item> items=itemService.getAllItems();
        if(items!=null){
            feedBack=new FeedBack("success","200",items);
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getItemByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Item> getItemByID( Integer id){
        FeedBack feedBack=null;
        Item items=itemService.getItemByID(id);
        if(items!=null){
            feedBack=new FeedBack("success","200",items);
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/deleteItemByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack deleteItemByID( Integer id){
        FeedBack feedBack=null;
        int cos=itemService.deleteItemByID(id);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getItemsByUID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack getItemsByUID( @RequestParam("userID") Integer userID){
        FeedBack feedBack=null;
        List<Item> items=itemService.getItemsByUID(userID);
        if(items!=null){
            feedBack=new FeedBack("success","200",items);
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getItemsByType",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Item> getItemsByType(@RequestParam("itemType") Integer itemType){
        FeedBack feedBack=null;
        List<Item> items=itemService.getItemsByType(itemType);
        if(items!=null){
            feedBack=new FeedBack("success","200",items);
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
}
