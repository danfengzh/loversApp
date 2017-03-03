package org.loversAPP.DTO;

import org.loversAPP.model.TextRecords;
import org.loversAPP.model.User;

/**
 * Created by Administrator on 2017/3/3.
 */
public class FriendText extends User {
    private TextRecords textRecords;

    public TextRecords getTextRecords() {
        return textRecords;
    }

    public void setTextRecords(TextRecords textRecords) {
        this.textRecords = textRecords;
    }

    public FriendText(TextRecords textRecords) {
        this.textRecords = textRecords;
    }
}
