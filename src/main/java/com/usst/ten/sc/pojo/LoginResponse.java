package com.usst.ten.sc.pojo;

import com.usst.ten.sc.entity.Activity;
import com.usst.ten.sc.entity.User;

import java.util.List;

public class LoginResponse {
    private String token; // 用于管理session
    private String errorMessage;
    private User user;
    private List<Activity> joinedActivities;

    public LoginResponse(String token, String errorMessage, User user, List<Activity> joinedActivities) {
        this.token = token;
        this.errorMessage = errorMessage;
        this.user = user;
        this.joinedActivities = joinedActivities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Activity> getJoinedActivities() {
        return joinedActivities;
    }

    public void setJoinedActivities(List<Activity> joinedActivities) {
        this.joinedActivities = joinedActivities;
    }
}
