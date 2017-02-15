package org.loversAPP.model;

import java.util.Date;
import javax.persistence.*;
import org.loversAPP.base.BaseEntity;

@Table(name = "lover_ship")
public class LoverShip extends BaseEntity {
    @Id
    @Column(name = "loverGirlID")
    private Integer lovergirlid;

    @Id
    @Column(name = "loverBoyID")
    private Integer loverboyid;

    /**
     * 成为情侣时间
     */
    @Column(name = "loveTime")
    private Date lovetime;

    /**
     * 0:表示过渡期，1表示已经是情侣2表示xxx
     */
    private String state;

    /**
     * 唯一标定一组情侣关系 方便在运动记录里面进行统计
     */
    @Column(name = "loverID")
    private String loverid;

    /**
     * 签到的天数
     */
    @Column(name = "checkinDays")
    private Integer checkindays;

    /**
     * @return loverGirlID
     */
    public Integer getLovergirlid() {
        return lovergirlid;
    }

    /**
     * @param lovergirlid
     */
    public void setLovergirlid(Integer lovergirlid) {
        this.lovergirlid = lovergirlid;
    }

    /**
     * @return loverBoyID
     */
    public Integer getLoverboyid() {
        return loverboyid;
    }

    /**
     * @param loverboyid
     */
    public void setLoverboyid(Integer loverboyid) {
        this.loverboyid = loverboyid;
    }

    /**
     * 获取成为情侣时间
     *
     * @return loveTime - 成为情侣时间
     */
    public Date getLovetime() {
        return lovetime;
    }

    /**
     * 设置成为情侣时间
     *
     * @param lovetime 成为情侣时间
     */
    public void setLovetime(Date lovetime) {
        this.lovetime = lovetime;
    }

    /**
     * 获取0:表示过渡期，1表示已经是情侣2表示xxx
     *
     * @return state - 0:表示过渡期，1表示已经是情侣2表示xxx
     */
    public String getState() {
        return state;
    }

    /**
     * 设置0:表示过渡期，1表示已经是情侣2表示xxx
     *
     * @param state 0:表示过渡期，1表示已经是情侣2表示xxx
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取唯一标定一组情侣关系 方便在运动记录里面进行统计
     *
     * @return loverID - 唯一标定一组情侣关系 方便在运动记录里面进行统计
     */
    public String getLoverid() {
        return loverid;
    }

    /**
     * 设置唯一标定一组情侣关系 方便在运动记录里面进行统计
     *
     * @param loverid 唯一标定一组情侣关系 方便在运动记录里面进行统计
     */
    public void setLoverid(String loverid) {
        this.loverid = loverid == null ? null : loverid.trim();
    }

    /**
     * 获取签到的天数
     *
     * @return checkinDays - 签到的天数
     */
    public Integer getCheckindays() {
        return checkindays;
    }

    /**
     * 设置签到的天数
     *
     * @param checkindays 签到的天数
     */
    public void setCheckindays(Integer checkindays) {
        this.checkindays = checkindays;
    }
}