package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.Controller.utils.ControllerConstant;
import org.loversAPP.Controller.utils.fileUpload;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.LikeWithUser;
import org.loversAPP.DTO.ReplyWithUser;
import org.loversAPP.model.Moment;
import org.loversAPP.service.CommmentService;
import org.loversAPP.service.MomentService;
import org.loversAPP.utils.UniqueStringGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/Moment")
public class MomentController extends BaseController{
    @Autowired
    private MomentService momentService;
    @Autowired
    private CommmentService commmentService;
    @RequestMapping(value ="insertMoment",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack insertMoment(@RequestParam("userID")Integer userID,@RequestParam("momentType") Integer momentType ,
                                 @RequestParam("momentContent") String momentContent,
                                 @RequestParam(value = "momentImage",required = false) MultipartFile momentImage ){
        FeedBack feedBack;
        //对monnmentImage进行存储

        String savePath=getMessage(ControllerConstant.momentPath);
        String monentImagePATH=   fileUpload.tacleUpload(momentImage,savePath,request, UniqueStringGenerate.generateRandomStr(11));
        Moment moment=new Moment();
        moment.setUserid(userID);
        moment.setMomenttype(momentType);
        moment.setMomentcontent(momentContent);
        moment.setMomentimage(monentImagePATH);
        int cos= momentService.insertMoment(moment);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;

    }
    @RequestMapping(value ="deleteMomentByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack deleteMomentByID(@RequestParam("id")Integer id
    ){
        FeedBack feedBack;

        int cos= momentService.deleteMomentByID(id);
        if(cos>=0){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value ="getMommentByUID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack getMommentByUID(@RequestParam("userID")Integer userID
    ){
        FeedBack feedBack;

        List<Moment> moments= momentService.getMommentByUID(userID);
        if(moments!=null){
            feedBack=new FeedBack("success","200",moments);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value ="getMommentByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack getMommentByID(@RequestParam("id")Integer id
    ){
        FeedBack feedBack;

        Moment cos= momentService.getMommentByID(id);
        if(cos!=null){
            feedBack=new FeedBack("success","200",cos);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }

    /**
     *
     * @param id
     * @param commentID
     * @return
     */
    @RequestMapping(value ="updateCommentIDByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateCommentIDByID(Integer id,Integer commentID){
        FeedBack feedBack=null;
      int rs=   momentService.updateCommentIDByID(id,commentID);
      if(rs==1){
          feedBack=new FeedBack("success","200");
      }
      else {
          feedBack=new FeedBack("failure","500");
      }
      return feedBack;
    }

    @RequestMapping(value ="updateLikeNumByMID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateLikeNumByMID(Integer momentID ,Integer likeNum){
        FeedBack feedBack=null;
        int rs= commmentService .updateZanLikeNumByMID(momentID,likeNum);
        if(rs==1){
            feedBack=new FeedBack("success","200",likeNum);
        }
        else {
            feedBack=new FeedBack("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="updatePingLikeNumByMID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updatePingLikeNumByMID(Integer momentID ,Integer likeNum){
        FeedBack feedBack=null;
        int rs= commmentService .updatePingLikeNumByMID(momentID,likeNum);
        if(rs==1){
            feedBack=new FeedBack("success","200",likeNum);
        }
        else {
            feedBack=new FeedBack("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="deleteCommentByMID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> deleteCommentByMID(Integer momentID){
        FeedBack feedBack=null;
        int rs= commmentService .deleteCommentByMID(momentID);
        if(rs==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","500");
        }
        return feedBack;
    }

    /**
     *
     * @param momentID
     * @param userID
     * @return
     */
    @RequestMapping(value ="insertCommentLike",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> insertCommentLike(Integer momentID,Integer userID){
        FeedBack feedBack=null;
        int rs= commmentService .insertCommentLike(momentID,userID);
        if(rs==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","500");
        }
        return feedBack;
    }

    /**
     *
     * @param momentID
     * @param userID
     * @return
     */
    @RequestMapping(value ="deleteCommentLike",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> deleteCommentLike(Integer momentID,Integer userID){
        FeedBack feedBack=null;
        int rs= commmentService .deleteCommentLike(momentID,userID);
        if(rs==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","500");
        }
        return feedBack;
    }

    /**
     *
     * @param momentID
     * @return
     */
    @RequestMapping(value ="getLikesByCID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<LikeWithUser> getLikesByCID(Integer momentID){
        FeedBack feedBack=null;
        List<LikeWithUser> rs= commmentService .getLikesByCID(momentID);
        feedBack=new FeedBack("success","200",rs);
        return feedBack;
    }
    @RequestMapping(value ="insertCommentReply",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> insertCommentReply(Integer momentID,Integer userID,String replyContent){
        FeedBack feedBack=null;
        int rs= commmentService .insertCommentReply(momentID,userID,replyContent);
        if(rs==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","500");
        }
        return feedBack;
    }
    @RequestMapping(value ="deleteCommentReply",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> deleteCommentReply(Integer momentID,Integer userID){
        FeedBack feedBack=null;
        int rs= commmentService .deleteCommentReply(momentID,userID);
        if(rs==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","500");
        }
        return feedBack;
    }

    /**
     *
     * @param commentID
     * @return
     */
    @RequestMapping(value ="getRepliesByCID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<ReplyWithUser> getRepliesByCID(Integer commentID){
        FeedBack feedBack=null;
       List<ReplyWithUser> rs= commmentService .getRepliesByCID(commentID);
       feedBack=new FeedBack("success","200",rs);
        return feedBack;
    }
}
