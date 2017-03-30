package org.loversAPP.Controller.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/11.
 * 文件上传处理工具类
 */
public class fileUpload {
    public  static String tacleUpload(MultipartFile file, String path, HttpServletRequest request,String flag)  {
        //得到实际的物理地址
        String commentRealPath=request.getSession().getServletContext().getRealPath(path);
        File savePath=new File(commentRealPath);
        if(!savePath.exists()){
            savePath.mkdirs();//得到文件的保存目录--实际物理保存目录
        }
        if(file!=null){
            if(file.getSize()!=0){

//                String fileExtendName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));//文件扩展名
                String logoImageName = commentRealPath + File.separator+flag;
                File FILE1 = new File(logoImageName);
                if (!file.isEmpty()) {
                    try {
                        file.transferTo(FILE1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return path+flag;
            }
            else
            {
                return null;
            }
        }
        else {
            return null;
        }

    }
    public  static String tacleUpload2(MultipartFile file, String path, HttpServletRequest request,String flag)  {
        //得到实际的物理地址
        String commentRealPath=request.getSession().getServletContext().getRealPath(path);
        File savePath=new File(commentRealPath);
        if(!savePath.exists()){
            savePath.mkdirs();//得到文件的保存目录--实际物理保存目录
        }
        if(file!=null){
            if(file.getSize()!=0){

                String fileExtendName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));//文件扩展名
                String logoImageName = commentRealPath + File.separator+flag+fileExtendName;
                File FILE1 = new File(logoImageName);
                if (!file.isEmpty()) {
                    try {
                        file.transferTo(FILE1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return path+flag+fileExtendName;
            }
            else
            {
                return null;
            }
        }
        else {
            return null;
        }

    }
}
