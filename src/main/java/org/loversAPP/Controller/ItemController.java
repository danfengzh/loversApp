package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.Controller.utils.ControllerConstant;
import org.loversAPP.Controller.utils.fileUpload;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.ItemCountWrapper;
import org.loversAPP.DTO.UserItemCount;
import org.loversAPP.model.Item;
import org.loversAPP.model.Moment;
import org.loversAPP.model.UserItem;
import org.loversAPP.model.UserOneItem;
import org.loversAPP.service.ItemService;
import org.loversAPP.service.MomentService;
import org.loversAPP.service.UserPhoService;
import org.loversAPP.service.UserTextService;
import org.loversAPP.utils.MD5Utils;
import org.loversAPP.utils.UniqueStringGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private MomentService momentService;
    @Autowired
    private UserPhoService userPhoService;
    @Autowired
    private UserTextService userTextService;
    @RequestMapping(value = "/insertItem",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack insertItem(String itemName , String itemFunction ,
                               Long price , MultipartFile itemImage,
                               Integer itemType,
                               Integer itemlevel ,Integer itemprivilege){
        FeedBack feedBack=null;
        String itemImagePath=getMessage(ControllerConstant.ItemImagePath);
        String imagePath= fileUpload.tacleUpload(itemImage,itemImagePath,request, MD5Utils.getMd5(itemName));
        int cos=itemService.insertItem(itemName,itemFunction,price,imagePath,itemType,itemlevel,itemprivilege);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/insertUserItem",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack insertUserItem(@RequestParam("userID") Integer userID ,@RequestParam("itemID") Integer itemID){
        FeedBack feedBack=null;
        UserItem userItem=itemService.getUserItemByUsERid(userID);
        UserOneItem userOneItem=new UserOneItem();
        if(userItem==null)
        {
            itemService.insertUserItem( userID,itemID);
            userOneItem.setItemid(itemID);
            userOneItem.setUserid(userID);
        }
        else
        {
            itemService.updateUserItemCount(userID,userItem.getCount()+1);
            userOneItem.setItemid(userItem.getItemId());
            userOneItem.setUserid(userItem.getUserId());
        }
        itemService.insertIntoUserOneItem(userOneItem);
        feedBack=new FeedBack("success","200");
        return feedBack;
    }

    /**
     * 9.deleteUserItemByID（执行后删除一条user_one_item数据，并count-1更新user_item的道具数量（当count=0时删除一条user_item数据））
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteUserItemByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack deleteUserItemByID(@RequestParam("itemID") Integer itemID ,@RequestParam("userID") Integer userID){
        FeedBack feedBack=null;
        deleItem(itemID, userID);
        feedBack=new FeedBack("success","200");
//        if(cos>=1){
//            feedBack=new FeedBack("success","200");
//        }else {
//            feedBack=new FeedBack("failure","400");
//        }
        return feedBack;
    }

    private void deleItem(@RequestParam("itemID") Integer itemID, @RequestParam("userID") Integer userID) {
        UserItem userItem=itemService.getSpeicUseritembY(userID,itemID);
        int maxid= itemService.maxIDu(userID);
        itemService.deletUserOneItem(maxid);//删除  user_one_item
        itemService.updateUserItemCount(userID,userItem.getCount()-1);
        userItem.setCount(userItem.getCount()-1);
        if(userItem.getCount()==0){
            itemService.deleteUserItemByID(userID);
        }
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
        List<UserItemCount> items=itemService.getItemsByUID(userID);
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

    /**
     * 删除相机道具 同时插入图片
     * @param recordsID
     * @param userItemID
     * @param userID
     * @param photo
     * @param content
     * @param longtitude
     * @param latitude
     * @return
     */
    @RequestMapping(value = "/insertPhoto",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertPhoto(int recordsID ,int userItemID ,int userID ,MultipartFile photo ,
                                        String content ,String longtitude ,String latitude){
        String PhoUploadPath=getMessage(ControllerConstant.Photopath);
        String MomeentPath=fileUpload.tacleUpload(photo,PhoUploadPath,request, UniqueStringGenerate.generateRandomStr(8));
        userPhoService.insertPhoto(recordsID,userID,MomeentPath,content,longtitude,latitude);//完成照片记录的插入
        deleItem(userItemID,userID);
        //完成用户的动态的发表
        Moment moment=new Moment();
        moment.setMomentcontent(content);
        moment.setMomenttype(10);
        moment.setMomentimage(MomeentPath);
        moment.setMomentdate(new Date());
        moment.setCommentid(-1);
        momentService.insertMoment(moment);
        return new FeedBack<String>("success","200");
    }
    @RequestMapping(value = "/insertText",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertText(int recordsID,int  itemID ,
                                       int userID ,String text, String longtitude ,String latitude){
        deleItem(itemID,userID);
        userTextService.insertText(recordsID,userID,text,longtitude,latitude);//完成text的插入
        Moment moment=new Moment();
        moment.setMomenttype(11);
        moment.setMomentdate(new Date());
        moment.setMomentcontent(text);
        moment.setCommentid(-1);
        momentService.insertMoment(moment);
        return new FeedBack<String>("success","200");
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
    @RequestMapping(value = "/getItemsByPrivilege",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Item> getItemsByPrivilege(@RequestParam("itemPrivilege") int itemPrivilege){
        FeedBack feedBack=null;
        List<Item> items=  itemService.getItemsByPrivilege(itemPrivilege);
        if(items!=null){
            feedBack=new FeedBack("success","200",items);
        }
        else {
            feedBack=new FeedBack("failure","400",items);
        }
        return feedBack;
    }
}
