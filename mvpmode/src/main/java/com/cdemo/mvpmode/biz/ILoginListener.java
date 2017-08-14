package com.cdemo.mvpmode.biz;

import com.cdemo.mvpmode.bean.User;

/**
 * Created by yangdi on 2017/5/22.
 */

public interface ILoginListener {

     void loginSuccess(User user);
     void loginFailed();
}
