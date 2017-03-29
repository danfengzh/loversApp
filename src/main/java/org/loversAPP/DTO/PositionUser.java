package org.loversAPP.DTO;

        import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/27.
 */
public class PositionUser implements Serializable {
    private int id;


    private String avatar;
    private String sex;

    private  String longtitude;

    private String latitude;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
