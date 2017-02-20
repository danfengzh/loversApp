package org.loversAPP.model;

import java.math.BigDecimal;
import org.loversAPP.base.BaseModel;

public class Activityrecords extends BaseModel {
    private Integer id;

    private String loverid;

    private Integer totalsteps;

    private Integer radius;

    private BigDecimal longtitude;

    private BigDecimal latitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoverid() {
        return loverid;
    }

    public void setLoverid(String loverid) {
        this.loverid = loverid == null ? null : loverid.trim();
    }

    public Integer getTotalsteps() {
        return totalsteps;
    }

    public void setTotalsteps(Integer totalsteps) {
        this.totalsteps = totalsteps;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public BigDecimal getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(BigDecimal longtitude) {
        this.longtitude = longtitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}