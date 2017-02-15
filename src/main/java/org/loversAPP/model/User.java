package org.loversAPP.model;

import javax.persistence.*;
import org.loversAPP.base.BaseEntity;

@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userName")
    private String username;

    @Column(name = "passWord")
    private String password;

    private String avator;

    @Column(name = "wexID")
    private String wexid;

    private String qq;

    @Column(name = "phoneNumber")
    private String phonenumber;

    @Column(name = "loveIndex")
    private Integer loveindex;

    private Integer level;

    /**
     * 签名
     */
    private String signature;

    /**
     * 邀请码
     */
    @Column(name = "inviteCode")
    private String invitecode;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return passWord
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return avator
     */
    public String getAvator() {
        return avator;
    }

    /**
     * @param avator
     */
    public void setAvator(String avator) {
        this.avator = avator == null ? null : avator.trim();
    }

    /**
     * @return wexID
     */
    public String getWexid() {
        return wexid;
    }

    /**
     * @param wexid
     */
    public void setWexid(String wexid) {
        this.wexid = wexid == null ? null : wexid.trim();
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * @return phoneNumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    /**
     * @return loveIndex
     */
    public Integer getLoveindex() {
        return loveindex;
    }

    /**
     * @param loveindex
     */
    public void setLoveindex(Integer loveindex) {
        this.loveindex = loveindex;
    }

    /**
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取签名
     *
     * @return signature - 签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置签名
     *
     * @param signature 签名
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * 获取邀请码
     *
     * @return inviteCode - 邀请码
     */
    public String getInvitecode() {
        return invitecode;
    }

    /**
     * 设置邀请码
     *
     * @param invitecode 邀请码
     */
    public void setInvitecode(String invitecode) {
        this.invitecode = invitecode == null ? null : invitecode.trim();
    }
}