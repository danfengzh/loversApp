package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

public class LoverCapsule extends BaseModel {
    private Integer id;

    private Integer receiverid;

    private Integer useritemid;

    private String openday;

    private String content;

    private String photo;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public Integer getUseritemid() {
        return useritemid;
    }

    public void setUseritemid(Integer useritemid) {
        this.useritemid = useritemid;
    }

    public String getOpenday() {
        return openday;
    }

    public void setOpenday(String openday) {
        this.openday = openday == null ? null : openday.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}