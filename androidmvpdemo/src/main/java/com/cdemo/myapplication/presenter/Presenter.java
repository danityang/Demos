package com.cdemo.myapplication.presenter;

import android.os.Handler;

import com.cdemo.myapplication.data.DataMode;
import com.cdemo.myapplication.data.ILoginlistener;
import com.cdemo.myapplication.view.ILoginView;

/**
 * Created by yangdi on 2017/5/23.
 */

public class Presenter {

    DataMode dataMode;
    ILoginView iLoginView;
    ILoginlistener iLoginlistener;
    Handler mHandler = new Handler();


    public Presenter(ILoginView iLoginView) {
        this.dataMode = new DataMode();
        this.iLoginView = iLoginView;
    }



    public void doLogin(){

        iLoginView.showLoading();
        iLoginlistener = new ILoginlistener() {

            @Override
            public void loginSuccess() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.hideLoading();
                        iLoginView.loginSussecc();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.hideLoading();
                        iLoginView.loginFailed();
                    }
                });
            }
        };

        dataMode.setiLoginlistener(iLoginlistener);
        dataMode.loginLogic(iLoginView.getUserName(), iLoginView.getPassWord());

    }

    public void clearText(){
        iLoginView.clearUserName();
        iLoginView.clearPassWord();
    }
}
