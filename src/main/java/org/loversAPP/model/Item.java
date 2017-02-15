package org.loversAPP.model;

import org.loversAPP.base.BaseEntity;

public class Item extends BaseEntity {
    private Integer id;

    private String itemname;

    private String itemfunction;

    private Long price;

    private String itemimage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getItemfunction() {
        return itemfunction;
    }

    public void setItemfunction(String itemfunction) {
        this.itemfunction = itemfunction == null ? null : itemfunction.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getItemimage() {
        return itemimage;
    }

    public void setItemimage(String itemimage) {
        this.itemimage = itemimage == null ? null : itemimage.trim();
    }
}