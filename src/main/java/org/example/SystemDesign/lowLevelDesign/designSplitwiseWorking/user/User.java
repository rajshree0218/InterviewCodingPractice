package org.example.SystemDesign.lowLevelDesign.designSplitwiseWorking.user;

public class User {
    private String userId;
    private String userName;
    private String mobile;

    public User(String userId, String userName, String mobile) {
        this.userId = userId;
        this.userName = userName;
        this.mobile = mobile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
