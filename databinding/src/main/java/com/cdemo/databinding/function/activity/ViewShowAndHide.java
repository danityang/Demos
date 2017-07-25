package com.cdemo.databinding.function.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cdemo.databinding.R;
import com.cdemo.databinding.databinding.ViewShowAndHideBinding;
import com.cdemo.databinding.viewmodel.ViewShowAndHideViewModel;

/**
 * Created by yangdi on 2017/7/21.
 */

public class ViewShowAndHide extends BaseActivity {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {

        ViewShowAndHideBinding bind = DataBindingUtil.setContentView(ViewShowAndHide.this, R.layout.view_show_and_hide);
        new ViewShowAndHideViewModel(ViewShowAndHide.this, bind);
//        showNoData.set(View.VISIBLE);
//        showPage.set(View.GONE);
    }
}
