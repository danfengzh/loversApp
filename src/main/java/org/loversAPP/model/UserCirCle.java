package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

/**
 * Created by Administrator on 2017/4/3.
 */
public class UserCirCle extends BaseModel {

    private Integer userID;

    private String latitude;

    private String longtitude;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }
}
