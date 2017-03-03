package org.loversAPP.DTO;

import org.loversAPP.model.PhotoRecords;
import org.loversAPP.model.User;

/**
 * Created by Administrator on 2017/3/3.
 */
public class FriendPhoto extends User {

    private PhotoRecords photoRecords;

    public PhotoRecords getPhotoRecords() {
        return photoRecords;
    }

    public void setPhotoRecords(PhotoRecords photoRecords) {
        this.photoRecords = photoRecords;
    }

    public FriendPhoto(PhotoRecords photoRecords) {
        this.photoRecords = photoRecords;
    }
}
