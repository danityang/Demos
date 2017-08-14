package com.cdemo.myapplication.view;

/**
 * Created by yangdi on 2017/5/23.
 */

public interface ILoginView {

    String getUserName();
    String getPassWord();
    void clearUserName();
    void clearPassWord();
    void showLoading();
    void hideLoading();
    void loginSussecc();
    void loginFailed();
}
