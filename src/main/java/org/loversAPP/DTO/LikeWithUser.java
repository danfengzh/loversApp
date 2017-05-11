package org.loversAPP.DTO;

import org.apache.commons.lang3.time.DateUtils;
import org.loversAPP.Controller.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;

import static org.apache.commons.lang3.time.DateUtils.*;

/**
 * Created by Administrator on 2017/5/11.
 */
public class LikeWithUser implements Serializable {
    private Integer userID;

    private String avatar;

    private Date likeDate;

    private String likeDateStr;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        if(likeDate!=null) this.setLikeDateStr(DateUtil.fomatDate(likeDate));
        this.likeDate = likeDate;
    }

    public String getLikeDateStr() {
        return likeDateStr;
    }

    public void setLikeDateStr(String likeDateStr) {
        this.likeDateStr = likeDateStr;
    }
}
