package org.loversAPP.model;

import org.loversAPP.base.BaseEntity;

public class Treasure extends BaseEntity {
    private Integer id;

    private Integer userid;

    private Integer treasuretype;

    private String treasurename;

    private Integer treasurevalue;

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

    @Override
    public String toString() {
        return "Treasure{" +
                "id=" + id +
                ", userid=" + userid +
                ", treasuretype=" + treasuretype +
                ", treasurename='" + treasurename + '\'' +
                ", treasurevalue=" + treasurevalue +
                '}';
    }
}