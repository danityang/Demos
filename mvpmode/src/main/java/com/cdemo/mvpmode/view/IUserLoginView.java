package com.cdemo.mvpmode.view;

import com.cdemo.mvpmode.bean.User;

/**
 * Created by yangdi on 2017/5/22.
 */

public interface IUserLoginView {

    String getUserName();
    String getPassWord();
    void clearPassWord();
    void clearUserName();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
