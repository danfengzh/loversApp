package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

public class Treasure extends BaseModel {
    private Integer id;

    private Integer userid;

    private Integer treasuretype;

    private String treasurename;

    private Integer treasurevalue;

    private String longtitude;

    private String latitude;

    private Integer treasurecode;

    private String money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTreasuretype() {
        return treasuretype;
    }

    public void setTreasuretype(Integer treasuretype) {
        this.treasuretype = treasuretype;
    }

    public String getTreasurename() {
        return treasurename;
    }

    public void setTreasurename(String treasurename) {
        this.treasurename = treasurename == null ? null : treasurename.trim();
    }

    public Integer getTreasurevalue() {
        return treasurevalue;
    }

    public void setTreasurevalue(Integer treasurevalue) {
        this.treasurevalue = treasurevalue;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude == null ? null : longtitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Integer getTreasurecode() {
        return treasurecode;
    }

    public void setTreasurecode(Integer treasurecode) {
        this.treasurecode = treasurecode;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }
}