package org.loversAPP.DTO;

import org.loversAPP.base.BaseModel;

/**
 * Created by Administrator on 2017/4/5.
 */
public class StepToday extends BaseModel {

    private int status;
    private int userID;
    private String date;
    private int stepsToday;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStepsToday() {
        return stepsToday;
    }

    public void setStepsToday(int stepsToday) {
        this.stepsToday = stepsToday;
    }
}
