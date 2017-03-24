package org.loversAPP.DTO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/21.
 */
public class ItemCountWrapper implements Serializable {


    private int itemID;

    private int count;

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
