package org.loversAPP.model;

import javax.persistence.*;
import org.loversAPP.base.BaseEntity;

@Table(name = "treasure")
public class Treasure extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     *  归属人,0表示还没有被任何人得到
     */
    @Id
    @Column(name = "userID")
    private Integer userid;

    /**
     * 宝藏类型
     */
    @Id
    @Column(name = "treasureType")
    private Integer treasuretype;

    @Column(name = "treasureName")
    private String treasurename;

    /**
     * 宝藏价值
     */
    @Column(name = "treasureValue")
    private Integer treasurevalue;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 归属人,0表示还没有被任何人得到
     *
     * @return userID -  归属人,0表示还没有被任何人得到
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 归属人,0表示还没有被任何人得到
     *
     * @param userid  归属人,0表示还没有被任何人得到
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取宝藏类型
     *
     * @return treasureType - 宝藏类型
     */
    public Integer getTreasuretype() {
        return treasuretype;
    }

    /**
     * 设置宝藏类型
     *
     * @param treasuretype 宝藏类型
     */
    public void setTreasuretype(Integer treasuretype) {
        this.treasuretype = treasuretype;
    }

    /**
     * @return treasureName
     */
    public String getTreasurename() {
        return treasurename;
    }

    /**
     * @param treasurename
     */
    public void setTreasurename(String treasurename) {
        this.treasurename = treasurename == null ? null : treasurename.trim();
    }

    /**
     * 获取宝藏价值
     *
     * @return treasureValue - 宝藏价值
     */
    public Integer getTreasurevalue() {
        return treasurevalue;
    }

    /**
     * 设置宝藏价值
     *
     * @param treasurevalue 宝藏价值
     */
    public void setTreasurevalue(Integer treasurevalue) {
        this.treasurevalue = treasurevalue;
    }
}