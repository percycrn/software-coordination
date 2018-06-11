package com.usst.ten.sc.entity;

import javax.persistence.Id;
import java.util.Date;

//申请表实体类， 用来存储用户的申请信息
public class Application {

    @Id
    private String uid;
    private String tag;
    private String state;
    private Date applyTime;

    public Application() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
}
