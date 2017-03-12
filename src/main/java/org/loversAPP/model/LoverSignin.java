package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

public class LoverSignin extends BaseModel {
    private Integer userid;

    private Integer halfid;

    private String signintime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getHalfid() {
        return halfid;
    }

    public void setHalfid(Integer halfid) {
        this.halfid = halfid;
    }

    public String getSignintime() {
        return signintime;
    }

    public void setSignintime(String signintime) {
        this.signintime = signintime == null ? null : signintime.trim();
    }
}