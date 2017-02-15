package org.loversAPP.model;

import org.loversAPP.base.BaseEntity;

public class DigHistory extends BaseEntity {
    private Integer id;

    private Integer userid;

    private Integer treasureid;

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

    public Integer getTreasureid() {
        return treasureid;
    }

    public void setTreasureid(Integer treasureid) {
        this.treasureid = treasureid;
    }

    @Override
    public String toString() {
        return "DigHistory{" +
                "id=" + id +
                ", userid=" + userid +
                ", treasureid=" + treasureid +
                '}';
    }
}