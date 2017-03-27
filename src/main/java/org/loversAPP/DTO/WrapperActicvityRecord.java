package org.loversAPP.DTO;

import org.loversAPP.model.Activityrecords;

/**
 * Created by Administrator on 2017/3/27.
 */
public class WrapperActicvityRecord  extends Activityrecords  {

    private String  loveAID;
    private String loveBID;
    private String  avatarA;
    private String  avatarB;
    private String nameA;
    private String nameB;
    private String backImageA;

    public String getLoveAID() {
        return loveAID;
    }

    public void setLoveAID(String loveAID) {
        this.loveAID = loveAID;
    }

    public String getLoveBID() {
        return loveBID;
    }

    public void setLoveBID(String loveBID) {
        this.loveBID = loveBID;
    }

    public String getAvatarA() {
        return avatarA;
    }

    public void setAvatarA(String avatarA) {
        this.avatarA = avatarA;
    }

    public String getAvatarB() {
        return avatarB;
    }

    public void setAvatarB(String avatarB) {
        this.avatarB = avatarB;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public String getBackImageA() {
        return backImageA;
    }

    public void setBackImageA(String backImageA) {
        this.backImageA = backImageA;
    }
}
