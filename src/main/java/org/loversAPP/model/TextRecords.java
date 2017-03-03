package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

import java.util.Date;

public class TextRecords extends BaseModel {
    private Integer id;

    private Integer recordsid;

    private Integer userid;

    private String text;

    private Date publishdate;

    private String longtitude;

    private String latitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecordsid() {
        return recordsid;
    }

    public void setRecordsid(Integer recordsid) {
        this.recordsid = recordsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
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
}