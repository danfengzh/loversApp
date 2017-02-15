package org.loversAPP.DTO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/15.
 */
public class FeedBack<T> implements Serializable {

    private String msg;
    private String code;
    private T data;

    public FeedBack(String msg, String code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
