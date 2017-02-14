package org.loversAPP.model;

public class Activityrecords {
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
}