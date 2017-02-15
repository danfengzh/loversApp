package org.loversAPP.model;

import javax.persistence.*;
import org.loversAPP.base.BaseEntity;

@Table(name = "item")
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "itemName")
    private String itemname;

    @Column(name = "itemFunction")
    private String itemfunction;

    private Long price;

    @Column(name = "itemImage")
    private String itemimage;

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
     * @return itemName
     */
    public String getItemname() {
        return itemname;
    }

    /**
     * @param itemname
     */
    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    /**
     * @return itemFunction
     */
    public String getItemfunction() {
        return itemfunction;
    }

    /**
     * @param itemfunction
     */
    public void setItemfunction(String itemfunction) {
        this.itemfunction = itemfunction == null ? null : itemfunction.trim();
    }

    /**
     * @return price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return itemImage
     */
    public String getItemimage() {
        return itemimage;
    }

    /**
     * @param itemimage
     */
    public void setItemimage(String itemimage) {
        this.itemimage = itemimage == null ? null : itemimage.trim();
    }
}