package org.loversAPP.DTO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/16.
 */
public class FriendIDs implements Serializable {
    private Integer loverBoyID;
    private Integer loverGirlID;

    public Integer getLoverBoyID() {
        return loverBoyID;
    }

    public void setLoverBoyID(Integer loverBoyID) {
        this.loverBoyID = loverBoyID;
    }

    public Integer getLoverGirlID() {
        return loverGirlID;
    }

    public void setLoverGirlID(Integer loverGirlID) {
        this.loverGirlID = loverGirlID;
    }
}
