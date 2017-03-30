package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.Controller.utils.ControllerConstant;
import org.loversAPP.Controller.utils.fileUpload;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.MyVersion;
import org.loversAPP.model.Version;
import org.loversAPP.service.VsersionService;
import org.loversAPP.utils.UniqueStringGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by Administrator on 2017/3/29.
 */
@Controller
public class VersionController extends BaseController {
    @Autowired
    private VsersionService vsersionService;
    @RequestMapping(value ="getVersion",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<MyVersion>  getVersion(){
        FeedBack feedBack;
        MyVersion myVersion= vsersionService.getMyVersionByid();
        feedBack=new FeedBack("success","code",myVersion);
        return feedBack;
    }
    @RequestMapping("uploadAppPage")
    public String  uploadAppPage(){

        return "upLoad";
    }

    /**
     *
     * @param app
     * @return
     */
    @RequestMapping(value ="upLoadTacle",method = RequestMethod.POST,produces ="application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> upLoadTacle(@RequestParam("app") MultipartFile app, @RequestParam("versio") int versio,
                                        @RequestParam("name") String name){
        String savePath=getMessage(ControllerConstant.AppuploadPath);
        MyVersion previousVersion=vsersionService.getMyVersionByid();
        //删除就的版本
        if(previousVersion.getUrl()!=null){
            File previousApp=new File(request.getSession().getServletContext().getRealPath(File.separator)+File.separator+previousVersion.getUrl());
            if(previousApp!=null&&previousApp.exists()){
                previousApp.delete();
            }
        }
        String downLoadPath= fileUpload.tacleUpload2(app,savePath,request, UniqueStringGenerate.generateRandomStr(6));
        //完成app的上传
        Version version=new Version();
        version.setVersion(versio);
        version.setName(name);
        version.setUrl(downLoadPath);
        vsersionService.updateVersion(version);
        return new FeedBack<String>("success","200");
    }
}
