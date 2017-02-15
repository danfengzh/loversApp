package org.loversAPP.DTO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/15.
 */
public class FeedBack<T> implements Serializable {
    public final static int OK = 1, FAILED = 0, EMPUTY = -1;
    public final static String OK_STR = "成功", FAILED_STR = "失败", EMPUTY_STR = "数据为空";

    private String msg;
    private String code;
    private T  data;

    public FeedBack(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public FeedBack() {
    }

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

    public Object getData() {
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
