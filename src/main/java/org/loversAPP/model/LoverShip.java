package org.loversAPP.model;

import java.util.Date;

public class LoverShip extends LoverShipKey {
    private Date lovetime;

    private String state;

    private String loverid;

    private Integer checkindays;

    public Date getLovetime() {
        return lovetime;
    }

    public void setLovetime(Date lovetime) {
        this.lovetime = lovetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getLoverid() {
        return loverid;
    }

    public void setLoverid(String loverid) {
        this.loverid = loverid == null ? null : loverid.trim();
    }

    public Integer getCheckindays() {
        return checkindays;
    }

    public void setCheckindays(Integer checkindays) {
        this.checkindays = checkindays;
    }
}