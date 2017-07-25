package com.cdemo.databinding.function.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.cdemo.databinding.R;
import com.cdemo.databinding.bean.Info;
import com.cdemo.databinding.databinding.BasicSampleBinding;

/**
 * Created by yangdi on 2017/6/29.
 */

public class BasicSample extends BaseActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BasicSampleBinding basicSampleBinding = DataBindingUtil.setContentView(this, R.layout.basic_sample);
        Info info = new Info("danityang",25,"male");
        basicSampleBinding.setInfo(info);
    }
}
