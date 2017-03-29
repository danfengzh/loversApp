package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

public class Item extends BaseModel {
    private Integer id;

    private String itemname;

    private String itemfunction;

    private Long itemprice;

    private String itemimage;

    private Integer itemtype;

    private Integer itemLevel;

    private Integer itemPrivilege;

    public Integer getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(Integer itemLevel) {
        this.itemLevel = itemLevel;
    }

    public Integer getItemPrivilege() {
        return itemPrivilege;
    }

    public void setItemPrivilege(Integer itemPrivilege) {
        this.itemPrivilege = itemPrivilege;
    }

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

    public Long getItemprice() {
        return itemprice;
    }

    public void setItemprice(Long itemprice) {
        this.itemprice = itemprice;
    }

    public String getItemimage() {
        return itemimage;
    }

    public void setItemimage(String itemimage) {
        this.itemimage = itemimage == null ? null : itemimage.trim();
    }

    public Integer getItemtype() {
        return itemtype;
    }

    public void setItemtype(Integer itemtype) {
        this.itemtype = itemtype;
    }
}