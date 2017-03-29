package org.loversAPP.model;

import org.loversAPP.base.BaseModel;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/28.
 */
public class SheduleTest extends BaseModel {
   private int id;
   private Date currentDate;

   private String content;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
