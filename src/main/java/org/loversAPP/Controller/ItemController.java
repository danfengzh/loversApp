package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.Controller.utils.ControllerConstant;
import org.loversAPP.Controller.utils.fileUpload;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.ItemCountWrapper;
import org.loversAPP.DTO.UserItemCount;
import org.loversAPP.DTO.UserPhoto;
import org.loversAPP.Jpush.JpushClientUtil;
import org.loversAPP.SheduleTask.SheduleTaskForLoverCaspule;
import org.loversAPP.SheduleTask.SheduleTaskJobForText;
import org.loversAPP.SheduleTask.SheduleTaskJobForUserPhoto;
import org.loversAPP.SheduleTask.SheduleTaskforDoolePhoto;
import org.loversAPP.model.*;
import org.loversAPP.service.*;
import org.loversAPP.utils.MD5Utils;
import org.loversAPP.utils.UniqueStringGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private SheduleTaskJobForUserPhoto sheduleTaskJobForUserPhoto;
    @Autowired
    private SheduleTaskJobForText sheduleTaskJobForText;
    @Autowired
    private DoolePhotoService doolePhotoService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoverShipService loverShipService;
    @Autowired
    private messageService messageService;
    @Autowired
    @Qualifier("taskExecutor")
    private TaskExecutor taskExecutor;
    @Autowired
    private LoveCauleService loveCauleService;
    @Autowired
    private SheduleTaskforDoolePhoto sheduleTaskforDoolePhoto;
    @Autowired
    private SheduleTaskForLoverCaspule sheduleTaskForLoverCaspule;
    @Autowired
    private ItemCapsuleService itemCapsuleService;
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
        UserItem userItem=itemService.getSpeicUseritembY(userID,itemID);
        UserOneItem userOneItem=new UserOneItem();
        if(userItem==null)
        {
            itemService.insertUserItem( userID,itemID);
            userOneItem.setItemid(itemID);
            userOneItem.setUserid(userID);
        }
        else
        {
            //updateUserItemBindItemIDCount
            itemService.updateUserItemBindItemIDCount(userID,itemID,userItem.getCount()+1);
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
        int maxid= itemService.maxIDu(userID,itemID);
        itemService.deletUserOneItem(maxid);//删除  user_one_item
        //updateUserItemBindItemIDCount
        itemService.updateUserItemBindItemIDCount(userID,itemID,userItem.getCount()-1);
        userItem.setCount(userItem.getCount()-1);
        if(userItem.getCount()==0){
            itemService.deleteUserItemByID(userID,itemID);
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
        moment.setUserid(userID);
        moment.setMomentimage(MomeentPath);
        moment.setMomentdate(new Date());
        moment.setCommentid(-1);
        if(recordsID==-1){
            //表示插入到了圈子的外面9.recordsID=-1表示插入到圈子之外了，此时服务器开启一个月倒计时服务，满期后消除该数据)
//目前是一分钟 的进行检测
            sheduleTaskJobForUserPhoto.testInsert();
        }
        momentService.insertMoment(moment);
        return new FeedBack<String>("success","200");
    }
    @RequestMapping(value = "/insertText",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertText(int recordsID,int  itemID ,
                                       int userID ,String text, String longtitude ,String latitude){
        deleItem(itemID,userID);//删除指定的道具
        userTextService.insertText(recordsID,userID,text,longtitude,latitude);//完成text的插入
        Moment moment=new Moment();
        moment.setUserid(userID);
        moment.setMomenttype(11);
        moment.setMomentimage("");
        moment.setMomentdate(new Date());
        moment.setMomentcontent(text);
        moment.setCommentid(-1);
        if(recordsID==-1){
            //表示插入到了圈子的外面9.recordsID=-1表示插入到圈子之外了，此时服务器开启一个月倒计时服务，满期后消除该数据)
//目前是一分钟 的进行检测
            sheduleTaskJobForText.testText();
        }
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

    /**
     * 用户使用涂鸦工具对用户头像进行涂鸦
     * @return
     */
    @RequestMapping(value = "/doodlePhoto",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> doodlePhoto(int photoID,MultipartFile doodlePhoto ,int userID ,int userItemID ){
        //删除用户对应的道具 涂鸦笔
        deleItem(userItemID,userID);
        //涂鸦照片的保存路径
        String savePath=getMessage(ControllerConstant.DoolePhotoPath);
        String dooleImageUrl=fileUpload.tacleUpload(doodlePhoto,savePath,request,UniqueStringGenerate.generateRandomStr(8));
        UserPhoto userPhoto= userPhoService.getUserPhotoByPhotoID(photoID);//原来用户的照片信息
        final int  trueUserid=userPhoService.getUserIDbyPhoid(photoID);
        //完成涂鸦操作
        doolePhotoService.doodlePhoto(photoID,userPhoto.getPhoto(),userID,userItemID);
        //同时将用户的原有的url记录里面的照片路径替换
        userPhoService.updateUserPhoUrlByUserID(trueUserid,dooleImageUrl);
        //完成动态的生成
        Moment moment=new Moment();
        moment.setMomentimage(dooleImageUrl);
        moment.setMomenttype(16);
        moment.setMomentcontent("对"+userPhoto.getUserName()+"使用了道具：涂鸦笔");
        moment.setUserid(userID);
        momentService.insertMoment(moment);
        //根据userid来获取用户的单身状况----先根据PhoTOid来查

        final User dooleUser=userService.getUserByID(trueUserid);
        final User myAnotherHalf=loverShipService.getHalfByID(trueUserid);
        if(dooleUser.getStauts()==2){
            //不是单身用户
            //完成消息推送
            taskExecutor.execute(new Runnable() {
                public void run() {
                    //插入消息
                    messageService.insertMessage(-1,myAnotherHalf.getId(),"4",new Date(),"您的照片被涂鸦了");
                    JpushClientUtil.sendDynatic(String.valueOf(myAnotherHalf.getId()),String.valueOf(myAnotherHalf.getStauts()),"你们的照片被涂鸦了","你们的照片被涂鸦了",
                            "你们的照片被涂鸦了！","hips");
                }
            });
        }
        taskExecutor.execute(new Runnable() {
            public void run() {
                //最终都会向用户完成消息推送
                messageService.insertMessage(-1,trueUserid,"4",new Date(),"您的照片被涂鸦了");
                JpushClientUtil.sendDynatic(String.valueOf(trueUserid),String.valueOf(dooleUser.getStauts()),"你们的照片被涂鸦了","你们的照片被涂鸦了",
                        "你的照片被涂鸦了！","hips");
            }
        });
        //检测触发函数  ---是否涂鸦的照片已经到达时间
        taskExecutor.execute(new Runnable() {
            public void run() {
                //在线程池里面进行触发
                sheduleTaskforDoolePhoto.testifDoolePhotoOutDate();
            }
        });
        return new FeedBack<String>("success","200");
    }
    /**
     *
     * @param userID
     * @param receiverID
     * @param ItemID
     * @param openDay
     * @param content
     * @param photo
     * @return
     */
    @RequestMapping(value = "/insertCapsule",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public Map insertCapsule(final int userID, final int  receiverID, int  ItemID, Date openDay, String content,
                             @RequestParam(value = "photo",required = false) MultipartFile photo){
        final Map map=new HashMap();
      //  LoverCapsule  previousLoverCapule=loveCauleService.getLoverCasuleByRecID(receiverID);
//        if(previousLoverCapule!=null&&!previousLoverCapule.getState().equals("2")){
//            map.put("code","201");
//            map.put("msg","success");
//        }

            String savePath=getMessage(ControllerConstant.LoverCauplePath);
            Moment moment=new Moment();
            String phoUrl="";
            if(photo!=null){
                phoUrl=fileUpload.tacleUpload(photo,savePath,request,UniqueStringGenerate.generateRandomStr(12));
                moment.setMomentimage(phoUrl);
            }
            else {
                moment.setMomentimage("");
            }
            deleItem(ItemID,userID);
//            UserItem userItem=itemService.getSpeicUseritembY(receiverID,17);
//            UserOneItem userOneItem=new UserOneItem();
//            if(userItem==null)
//            {
//                itemService.insertUserItem( receiverID,17);
//                userOneItem.setItemid(17);
//                userOneItem.setUserid(receiverID);
//            }
//            else
//            {
//                //updateUserItemBindItemIDCount
//                itemService.updateUserItemBindItemIDCount(receiverID,17,userItem.getCount()+1);
//                userOneItem.setItemid(17);
//                userOneItem.setUserid(userItem.getUserId());
//            }
//            itemService.insertIntoUserOneItem(userOneItem);
            moment.setUserid(userID);
            moment.setMomenttype(12);
            moment.setMomentdate(new Date());
            moment.setCommentid(-1);
            moment.setMomentcontent("来自过去的消息去看你，亲爱的");
            momentService.insertMoment(moment);
            final LoverCapsule  loverCapsule=new LoverCapsule();
            loverCapsule.setUserid(userID);
            loverCapsule.setContent(content);
            loverCapsule.setOpenday(openDay);
           // loverCapsule.setOpenday(new Date());
            loverCapsule.setItemid(ItemID);
            loverCapsule.setReceiverid(receiverID);
            if(photo==null){
                loverCapsule.setPhoto("");
            }else {
                loverCapsule.setPhoto(phoUrl);
            }
            loveCauleService.insertCapsule(loverCapsule);

            //int  loverCaspuleID=loveCauleService.getLoverCasuleIDByUserAndItemID(userID,12);
//            ItemCapsule itemCapsule=new ItemCapsule();
//            itemCapsule.setItemID(17);
//            itemCapsule.setUserID(receiverID);
//            itemCapsule.setLove_capsule_id();
//            itemCapsuleService.insertItemCapsule()
            taskExecutor.execute(new Runnable() {
                public void run() {
                    messageService.insertMessage(userID,receiverID,"11",new Date(),"在遥远的未来你将会收到一条神秘消息");
                    //JpushClientUtil.sendDynatic(String.valueOf(receiverID),"1","owo","你的私信","在遥远的未来你将会收到一条神秘消息","tips");

                }
            });
            taskExecutor.execute(new Runnable() {
                public void run() {
                    //检测是否时间到达
                    sheduleTaskForLoverCaspule.ifopen();

                }

            });
//            map.put("code","202");
//            map.put("msg","success");
            // feedBack= new FeedBack<String>("success","200");
        map.put("code","200");
        map.put("msg","success");
        map.put("data",loverCapsule);
        return map;
    }
//    @RequestMapping(value = "/setStateByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
//    @ResponseBody
//    public FeedBack<String>  setStateByID(int receiverID){
//        FeedBack feedBack=null;
//        LoverCapsule  loverCapsule=loveCauleService.getLoverCasuleByRecID(receiverID);
//        if(loverCapsule.getState().equals("1")){
//            loveCauleService.setStateByID(loverCapsule.getId(),"2");
//            feedBack=new FeedBack("success","200");
//
//        }else {
//            feedBack=new FeedBack("success","201");
//        }
//        return feedBack;

    @RequestMapping(value = "/getCapsuleByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<LoverCapsule> getCapsuleByID(int recvierID){
        FeedBack feedBack;
        List<LoverCapsule> loverCapsule=loveCauleService.getAllCanOpenLoverCasules(recvierID);
        if(loverCapsule!=null){
            feedBack=new FeedBack("success","200",loverCapsule);
        }
        else {
            feedBack=new FeedBack("success","201",loverCapsule);
        }
        return feedBack;
    }
}
