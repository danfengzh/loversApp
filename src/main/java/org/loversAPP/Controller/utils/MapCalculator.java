package org.loversAPP.Controller.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ppssyyy on 2017-03-23.
 * 地图计算类
 */
public class MapCalculator {
    private static double EARTH_RADIUS = 6378137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两个位置的经纬度，来计算两地的距离（单位为M）
     * 参数为String类型
     * @param lat1Str 用户A经度
     * @param lng1Str 用户A纬度
     * @param lat2Str 用户B经度
     * @param lng2Str 用户B纬度
     * @return
     */
    public static double getDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str) {
        if(StringUtils.isEmpty(lat1Str.trim())){lat1Str="0";}
        if(StringUtils.isEmpty(lng1Str.trim())){lng1Str="0";}
        if(StringUtils.isEmpty(lat2Str.trim())){lat2Str="0";}
        if(StringUtils.isEmpty(lng2Str.trim())){lng2Str="0";}
        Double lat1 = Double.parseDouble(lat1Str);
        Double lng1 = Double.parseDouble(lng1Str);
        Double lat2 = Double.parseDouble(lat2Str);
        Double lng2 = Double.parseDouble(lng2Str);

        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double difference = radLat1 - radLat2;
        double mdifference = rad(lng1) - rad(lng2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mdifference / 2), 2)));
        distance = distance * EARTH_RADIUS;
        return distance;
    }
   public static class Positon{
        private String longLatitude;
        private String latitude;

        public String getLongLatitude() {
            return longLatitude;
        }

        public void setLongLatitude(String longLatitude) {
            this.longLatitude = longLatitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }
    }

    /**
     *    根据中心点 center1 center2，以及半径radis来生成 指定数量count个 随机点的数量
     * @param center1
     * @param center2
     * @param count
     * @param radis
     * @return
     * if (m_origin != null) {
    int segNum = this.getNumSegs();
    for (int i = segNum - 1; i >= 0; i--)
    this.removeSeg(i);

    double[] xy = new double[2];
    for(double i = 0; i < Math.PI*2; i+=Math.PI*2/60) {
    xy[0] = m_origin.getX() + m_radius * Math.cos(i);
    xy[1] = m_origin.getY() + m_radius * Math.sin(i);
    try {
    this.addPoint(xy[0], xy[1], MrfPathIterator.MRF_SEG_LINETO);
    }
    catch (Exception e) {
    }
     */
    public static List<Positon> MakeRandomPositonAroundCircle(String center1,String center2,int count,int radis){
        List<Positon> positonList=new ArrayList<Positon>();
        if(StringUtils.isEmpty(center1)) center1="0";
        if(StringUtils.isEmpty(center2)) center2="0";
        double centr1=Double.parseDouble(center1);
        double centr2=Double.parseDouble(center2);
        for (int i = 0; i <count ; i++) {
            //生成 r--3r之间的随机数字
            int randowRadius=radis+new Random().nextInt(2*radis);
            Double x_random=0.0;
            Double y_random=0.0;
            if(i/2==0){
                 x_random=centr1+new Random().nextInt((int) (radis))*0.00001;
                 y_random=centr2+new Random().nextInt((int) (radis))*0.00001;
            }else {
                x_random=centr1-new Random().nextInt((int) (radis))*0.00001;
                y_random=centr2-new Random().nextInt((int) (radis))*0.00001;
            }

            Positon positon=new Positon();
            positon.setLatitude(x_random.toString());
            positon.setLongLatitude(y_random.toString());
            positonList.add(positon);
        }
        return positonList;
    }
    /**
     * 判断物体是否在圈子里
     * @param cLat 圈子经度
     * @param cLong 圈子纬度
     * @param radius 圈子半径
     * @param olat 物体经度
     * @param olong 物体纬度
     * @return
     */
    public static boolean isInCircle(String cLat,String cLong,int radius,String olat,String olong){
        if (radius!=0){
            double distance = 0;
            distance = getDistance(cLat,cLong,olat,olong);
            return distance > (double)radius?false:(distance == (double)radius?true:true);
        }else return false;
    }
    //生成

    public static void main(String [] args){
        List<Positon> positonList= MakeRandomPositonAroundCircle("50","50",10,200);
        System.out.println("v");
    }
}
