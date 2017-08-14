package com.cdemo.mvpmode.biz;

import com.cdemo.mvpmode.bean.User;

/**
 * Created by yangdi on 2017/5/22.
 * 在MVP模式中相当于M——Mode逻辑层
 */

public class UserBiz implements IUserBiz{

    // 通常是提交到网络，等待网络返回结果
    @Override
    public void login(final String username, final String userPassWord, final ILoginListener loginListener) {

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if("danityang".equals(username)&&"123".equals(userPassWord)){
                    User user = new User(username, userPassWord);
                    loginListener.loginSuccess(user);
                }else{
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
