package org.loversAPP.Controller.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/23.
 *   自定义日期转换工具类
 */
public class DateConvert implements  Converter<String, Date>
{
    public Date convert(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return   simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String [] args){

        Date ss= new DateConvert().convert("2017-04-02 02:15:54");
        System.out.println("***********");
    }
}
