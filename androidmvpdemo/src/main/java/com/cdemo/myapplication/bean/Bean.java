package com.cdemo.myapplication.bean;

/**
 * Created by yangdi on 2017/5/23.
 */

public class Bean {

    private String userName;
    private String passWord;

    public Bean(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
