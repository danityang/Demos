package com.cdemo.myapplication.data;

/**
 * Created by yangdi on 2017/5/23.
 */

public class DataMode {

    private ILoginlistener iLoginlistener;

    public void setiLoginlistener(ILoginlistener iLoginlistener) {
        this.iLoginlistener = iLoginlistener;
    }

    public void loginLogic(final String userName, final String passWord) {

        new Thread() {

            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("yd".equals(userName) && "123".equals(passWord)) {

                    iLoginlistener.loginSuccess();

                } else {

                    iLoginlistener.loginFailed();
                }
            }
        }.start();

    }

}
