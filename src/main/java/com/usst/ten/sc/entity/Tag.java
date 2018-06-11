package com.usst.ten.sc.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Tag {
    @Id
    @GeneratedValue
    private String tid;
    private String tag;

    public Tag() {
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
