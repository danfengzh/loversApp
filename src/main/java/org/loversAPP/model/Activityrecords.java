package org.loversAPP.model;

import javax.persistence.*;
import org.loversAPP.base.BaseEntity;

@Table(name = "activityrecords")
public class Activityrecords extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "loverID")
    private String loverid;

    /**
     * 总步数
     */
    @Column(name = "totalSteps")
    private Integer totalsteps;

    /**
     * 领地面积
     */
    @Column(name = "Area")
    private Double area;

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
     * @return loverID
     */
    public String getLoverid() {
        return loverid;
    }

    /**
     * @param loverid
     */
    public void setLoverid(String loverid) {
        this.loverid = loverid == null ? null : loverid.trim();
    }

    /**
     * 获取总步数
     *
     * @return totalSteps - 总步数
     */
    public Integer getTotalsteps() {
        return totalsteps;
    }

    /**
     * 设置总步数
     *
     * @param totalsteps 总步数
     */
    public void setTotalsteps(Integer totalsteps) {
        this.totalsteps = totalsteps;
    }

    /**
     * 获取领地面积
     *
     * @return Area - 领地面积
     */
    public Double getArea() {
        return area;
    }

    /**
     * 设置领地面积
     *
     * @param area 领地面积
     */
    public void setArea(Double area) {
        this.area = area;
    }
}