package org.loversAPP.DTO;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/27.
 */
public class UserDistance implements Serializable ,Comparable {
    private int userID;

    private String avatar;

    private String sex;

    private double distance;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDistance that = (UserDistance) o;
        return getUserID() == that.getUserID() &&
                Double.compare(that.getDistance(), getDistance()) == 0 &&
                Objects.equal(getAvatar(), that.getAvatar()) &&
                Objects.equal(getSex(), that.getSex());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUserID(), getAvatar(), getSex(), getDistance());
    }

    public int compareTo(Object o) {
        //this  >  o
        return (int) (this.getDistance()-((UserDistance)o).getDistance());
    }
}
