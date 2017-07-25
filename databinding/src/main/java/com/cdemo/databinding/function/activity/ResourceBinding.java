package com.cdemo.databinding.function.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cdemo.databinding.R;

/**
 * Created by yangdi on 2017/7/25.
 */
public class ResourceBinding extends BaseActivity{


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(ResourceBinding.this, R.layout.resource_binding_activity);
    }
}
