package org.loversAPP.DTO;

import org.loversAPP.model.User;

/**
 * Created by Administrator on 2017/5/11.
 */
public class MathableUser extends User {

    private Double matchIndex;

    public Double getMatchIndex() {
        return matchIndex;
    }

    public void setMatchIndex(Double matchIndex) {
        this.matchIndex = matchIndex;
    }
}
