package com.cdemo.databinding.function.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cdemo.databinding.R;

/**
 * Created by yangdi on 2017/7/28.
 */

public class MultiLayoutRecyclerView extends BaseActivity{


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         ViewDataBinding binding = DataBindingUtil.setContentView(MultiLayoutRecyclerView.this, R.layout.multi_layout_recyclerview);
    }
}
