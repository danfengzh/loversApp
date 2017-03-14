package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

public class FinishStatus extends BaseModel {
    private Integer id;

    private Integer userid;

    private Integer finishstatus;

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

    public Integer getFinishstatus() {
        return finishstatus;
    }

    public void setFinishstatus(Integer finishstatus) {
        this.finishstatus = finishstatus;
    }
}