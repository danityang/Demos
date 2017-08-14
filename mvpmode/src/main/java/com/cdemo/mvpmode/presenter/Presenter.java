package com.cdemo.mvpmode.presenter;

import android.os.Handler;

import com.cdemo.mvpmode.bean.User;
import com.cdemo.mvpmode.biz.ILoginListener;
import com.cdemo.mvpmode.biz.IUserBiz;
import com.cdemo.mvpmode.biz.UserBiz;
import com.cdemo.mvpmode.view.IUserLoginView;

/**
 * Created by yangdi on 2017/5/22.
 */

public class Presenter {

    // 具体数据处理逻辑层
    private IUserBiz iUserBiz;
    // interface接口负责传递数据
    private IUserLoginView iUserLoginView;
    private Handler mHandler = new Handler();


    public Presenter(IUserLoginView iUserLoginView) {
        iUserBiz = new UserBiz();
        this.iUserLoginView = iUserLoginView;
    }

    public void login() {

        iUserLoginView.showLoading();

        // 调取逻辑层获取数据，在activity更新结果，通过interface接口传递数据
        iUserBiz.login(iUserLoginView.getUserName(), iUserLoginView.getPassWord(), new ILoginListener() {

            @Override
            public void loginSuccess(final User user) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toMainActivity(user);
                        iUserLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.showFailedError();
                        iUserLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {

        iUserLoginView.clearUserName();
        iUserLoginView.clearPassWord();
    }
}
