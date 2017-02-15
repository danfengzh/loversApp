package org.loversAPP.model;

import javax.persistence.*;
import org.loversAPP.base.BaseEntity;

@Table(name = "dig_history")
public class DigHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Id
    @Column(name = "userID")
    private Integer userid;

    @Id
    @Column(name = "treasureID")
    private Integer treasureid;

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
     * @return userID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return treasureID
     */
    public Integer getTreasureid() {
        return treasureid;
    }

    /**
     * @param treasureid
     */
    public void setTreasureid(Integer treasureid) {
        this.treasureid = treasureid;
    }
}