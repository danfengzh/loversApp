package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.Controller.utils.ControllerConstant;
import org.loversAPP.Controller.utils.fileUpload;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.model.Moment;
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
}
