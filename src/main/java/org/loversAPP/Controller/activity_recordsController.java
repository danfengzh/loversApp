package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.location;
import org.loversAPP.model.Activityrecords;
import org.loversAPP.service.ActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */
@Controller
@RequestMapping("/ActivityRecords")
public class activity_recordsController extends BaseController {
    @Autowired
    private ActivityRecordService activityRecordService;
    @RequestMapping(value = "/insertRecord",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> insertRecord(String loverID ,String longtitude ,String latitude){
        FeedBack feedBack=null;
        int count= activityRecordService.insertRecord(loverID,longtitude,latitude);
        if(count==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getIDByLoverID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> getIDByLoverID(String loverID){
        FeedBack feedBack=null;
        int count= activityRecordService.getIDByLoverID(loverID);
        if(count!=1){
            feedBack=new FeedBack("success","200",count);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getRecordByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Activityrecords> getRecordByID(@RequestParam("id") Integer id){
        FeedBack feedBack=null;
        Activityrecords activityrecords= activityRecordService.getRecordByID(id);
        if(activityrecords!=null){
            feedBack=new FeedBack("success","200",activityrecords);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/updateTotalStepsByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateTotalStepsByID(@RequestParam("id") Integer id,@RequestParam("totalSteps") Integer totalSteps){
        FeedBack feedBack=null;
        Integer count= activityRecordService.updateTotalStepsByID(id,totalSteps);
        if(count==1){
            feedBack=new FeedBack("success","200",totalSteps);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/updateRadiusByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateRadiusByID(@RequestParam("id") Integer id,@RequestParam("radius") Integer radius){
        FeedBack feedBack=null;
        Integer count= activityRecordService.updateRadiusByID(id,radius);
        if(count==1){
            feedBack=new FeedBack("success","200",radius);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/getAllRecords",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Activityrecords> getAllRecords(){
        FeedBack feedBack=null;
        List<Activityrecords> activityrecordss= activityRecordService.getAllRecords();
        if(activityrecordss!=null){
            feedBack=new FeedBack("success","200",activityrecordss);
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value = "/deleteRecordByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack deleteRecordByID(@RequestParam("id") Integer id){
        FeedBack feedBack=null;
        int cos= activityRecordService.deleteRecordByID(id);
        if(cos==1){
            feedBack=new FeedBack("success","200");
        }
        else {
            feedBack=new FeedBack("failure","400");
        }
        return feedBack;
    }
    @RequestMapping(value ="updateLocationByID",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack updateLocationByID(@RequestParam("id") Integer id, @RequestParam("longtitude") String longtitude , @RequestParam("latitude") String latitude){
        FeedBack feedBack;
        Integer cout=activityRecordService.updateLocationByID(id,longtitude,latitude);
        if(cout==1){
            feedBack=new FeedBack<>("success","200",new location(longtitude,latitude));
        }
        else {
            feedBack=new FeedBack<>("failure","500");
        }
        return feedBack;
    }

}
