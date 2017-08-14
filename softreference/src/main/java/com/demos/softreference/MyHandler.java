package com.demos.softreference;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.SoftReference;

/**
 * Created by yangdi on 2017/5/12.
 */

public class MyHandler extends Handler {

    SoftReference<Activity> sf;

    public MyHandler(Activity activity){
        sf = new SoftReference<Activity>(activity);
    }


    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if(msg.what==0x11){
            MainActivity activity = (MainActivity) sf.get();
            activity.textView.setText("dianji2");
        }
    }

    // 其他例子
    public void siplme(){
        String str = "zifu";
        SoftReference<String> sf = new SoftReference<String>(str);
        String str2 = sf.get();

    }
}
