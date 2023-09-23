package com.webFramework.domain;

import java.util.Date;

public class UserDTO {
    private int userNo;
    private String userId;
    private String userPassword;
    private String userName;
    private String userGender;
    private String userCallNumber;
    private Date userSignDate;
    private String userAuthority;

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserCallNumber() {
        return userCallNumber;
    }

    public void setUserCallNumber(String userCallNumber) {
        this.userCallNumber = userCallNumber;
    }

    public Date getUserSignDate() {
        return userSignDate;
    }

    public void setUserSignDate(Date userSignDate) {
        this.userSignDate = userSignDate;
    }

    public String getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(String userAuthority) {
        this.userAuthority = userAuthority;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userNo=" + userNo +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userCallNumber='" + userCallNumber + '\'' +
                ", userSignDate=" + userSignDate +
                ", userAuthority='" + userAuthority + '\'' +
                '}';
    }
}
