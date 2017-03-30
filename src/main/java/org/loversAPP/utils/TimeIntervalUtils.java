package org.loversAPP.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/29.
 */
public class TimeIntervalUtils {

    /**
     * 毫秒时间转格式时间
     * @param timeMillis
     * @param format
     * @return
     */
    public static String timeMillis2FormatTime(String timeMillis,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        long time = Long.parseLong(timeMillis);
        calendar.setTimeInMillis(time);
        return sdf.format(calendar.getTime());
    }
    /**
     * 根据时间间隔计算未来时间
     * @param formatCurrentTime
     * @param deltaTime
     * @return
     */
    public static String calFutureTime(String formatCurrentTime,long deltaTime){
        String formatFutureTime = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long millionSeconds = sdf.parse(formatCurrentTime).getTime();//毫秒
            long futureMillionSeconds = millionSeconds+deltaTime;
            formatCurrentTime = timeMillis2FormatTime(futureMillionSeconds+"","yyyy-MM-dd HH:mm:ss");
        }catch (ParseException e){
            e.printStackTrace();
        }
        return  formatCurrentTime;
    }

    /**
     *  public static void main(String[] args) throws ParseException {
     String str = "201104141302";
     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");

     long millionSeconds = sdf.parse(str).getTime();//毫秒
     System.out.println(millionSeconds);

     * @param currentDate
     * @param deltaTime  TRUE 超时了
     * @return
     */
    public static boolean isOutDate(Date currentDate,long deltaTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curremDateStr=sdf.format(currentDate);
        long currentLongTime=currentDate.getTime();
        long nowTime=System.currentTimeMillis();
        String fultureTimeStr=calFutureTime(curremDateStr,deltaTime);
        try {
            long futuretime=sdf.parse(fultureTimeStr).getTime();
            return futuretime-nowTime<=0;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void  main(String [] args){
        Date currentDate=new Date();
        String currentDateStr=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
        //过上3分钟
        long deltaTime=3*60*1000;
        String nextStr=calFutureTime(currentDateStr,deltaTime);
        System.out.println("**************"+nextStr);
    }
}
