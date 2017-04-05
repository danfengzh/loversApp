package org.loversAPP.DTO;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/4.
 */
public class LoverDogCount {
    private int id;
    private String loverID;

    private int  count;

    private Date insertTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getLoverID() {
        return loverID;
    }

    public void setLoverID(String loverID) {
        this.loverID = loverID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
