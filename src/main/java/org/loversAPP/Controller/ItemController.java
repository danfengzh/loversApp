package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.Controller.utils.ControllerConstant;
import org.loversAPP.Controller.utils.fileUpload;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.ItemCountWrapper;
import org.loversAPP.model.Item;
import org.loversAPP.service.ItemService;
import org.loversAPP.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public FeedBack insertItem(String itemName , String itemFunction , Long price , MultipartFile itemImage, Integer itemType){
        FeedBack feedBack=null;
        String itemImagePath=getMessage(ControllerConstant.ItemImagePath);
        String imagePath= fileUpload.tacleUpload(itemImage,itemImagePath,request, MD5Utils.getMd5(itemName));
        int cos=itemService.insertItem(itemName,itemFunction,price,imagePath,itemType);
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
    @RequestMapping(value = "/getAllItemsPage",method = RequestMethod.GET)
    public String getItemsPage(ModelMap modelMap){
        List<Item> items=itemService.getAllItems();
        modelMap.addAttribute("items",items);
        return "manage";
    }
    @RequestMapping(value = "/AddItemPage",method = RequestMethod.GET)
    public String AddItemPage(){

        return "AddItem";
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
    @RequestMapping(value = "/deleteItemByID/{id}",method = RequestMethod.GET,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack deleteItemByID(@PathVariable("id") Integer id){
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
    @RequestMapping(value = "/insertPhoto",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertPhoto(){
        return null;
    }

    @RequestMapping(value = "/getItemsCountByUIDForEach",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<ItemCountWrapper> getItemsCountByUIDForEach(@RequestParam("userID") Integer userID){
        FeedBack feedBack;
        List<ItemCountWrapper>  itemCountWrappers= itemService.getItemsCountByUIDForEach(userID);
        if(itemCountWrappers!=null){
            feedBack=new FeedBack("success","200",itemCountWrappers);
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
}
