package org.loversAPP.DTO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/31.
 */
public class GoDieFeeBack implements Serializable {
    private int steps;

    private int itemID;

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
}
