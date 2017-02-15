package org.loversAPP.model;

import org.loversAPP.base.BaseEntity;

public class Activityrecords extends BaseEntity {
    private Integer id;

    private String loverid;

    private Integer totalsteps;

    private Double area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoverid() {
        return loverid;
    }

    public void setLoverid(String loverid) {
        this.loverid = loverid == null ? null : loverid.trim();
    }

    public Integer getTotalsteps() {
        return totalsteps;
    }

    public void setTotalsteps(Integer totalsteps) {
        this.totalsteps = totalsteps;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Activityrecords{" +
                "id=" + id +
                ", loverid='" + loverid + '\'' +
                ", totalsteps=" + totalsteps +
                ", area=" + area +
                '}';
    }
}