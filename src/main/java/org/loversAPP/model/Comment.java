package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

public class Comment extends BaseModel {
    private Integer id;

    private Integer momentid;

    private Integer userid;

    private Integer likenum;

    private Integer replynum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMomentid() {
        return momentid;
    }

    public void setMomentid(Integer momentid) {
        this.momentid = momentid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getReplynum() {
        return replynum;
    }

    public void setReplynum(Integer replynum) {
        this.replynum = replynum;
    }
}