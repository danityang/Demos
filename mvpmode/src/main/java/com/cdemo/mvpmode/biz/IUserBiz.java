package com.cdemo.mvpmode.biz;

/**
 * Created by yangdi on 2017/5/22.
 */

public interface IUserBiz {

    public void login(String username, String userPassWord, ILoginListener iLoginListener);
}
