package com.cdemo.mvpmode.bean;

/**
 * Created by yangdi on 2017/5/22.
 */

public class User {

    private String userName;
    private String uesrAge;
    private String userPassWord;

    public User(String userName, String userPassWord) {
        this.userName = userName;
        this.uesrAge = uesrAge;
        this.userPassWord = userPassWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUesrAge(String uesrAge) {
        this.uesrAge = uesrAge;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getUesrAge() {
        return uesrAge;
    }

    public String getUserPassWord() {
        return userPassWord;
    }
}
