package com.cdemo.databinding.function.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.cdemo.databinding.R;
import com.cdemo.databinding.bean.Info;
import com.cdemo.databinding.databinding.IncludeLayoutBinding;
import com.cdemo.databinding.interfac.IListener;

/**
 * Created by yangdi on 2017/6/29.
 */

public class IncludeLayout extends BaseActivity implements IListener {

    IncludeLayoutBinding includeLayoutBinding;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        includeLayoutBinding = DataBindingUtil.setContentView(this, R.layout.include_layout);
        includeLayoutBinding.setListener(this);
        includeLayoutBinding.setText("test text");

        includeLayoutBinding.layoutInput.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                includeLayoutBinding.setInfo(new Info(s.toString(), 22, "female"));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void clickListener(View v) {
        Toast.makeText(this, "Button Click!", Toast.LENGTH_LONG).show();
    }
}
