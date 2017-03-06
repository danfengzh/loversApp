package org.loversAPP.DTO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/6.
 */
public class location implements Serializable {
    String longtitud;
    String latitud;

    public String getLongtitud() {
        return longtitud;
    }

    public void setLongtitud(String longtitud) {
        this.longtitud = longtitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public location(String longtitud, String latitud) {
        this.longtitud = longtitud;
        this.latitud = latitud;
    }
}
