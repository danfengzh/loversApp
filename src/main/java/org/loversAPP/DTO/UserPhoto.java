package org.loversAPP.DTO;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/13.
 */
public class UserPhoto implements Serializable {
    private Integer  id;
    private String userName;
    private String avatar;
    private String photo;
    private String content;
    private Date publishDate;
    private String longtitude;
    private String latitude;
    private Integer isMe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsMe() {
        return isMe;
    }

    public void setIsMe(Integer isMe) {
        this.isMe = isMe;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(StringUtils.isNotEmpty(userName)){this.setIsMe(0);}
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
