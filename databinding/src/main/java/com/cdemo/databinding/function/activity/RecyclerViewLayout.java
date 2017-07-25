package com.cdemo.databinding.function.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.cdemo.databinding.adapter.BindingAdapter;
import com.cdemo.databinding.R;
import com.cdemo.databinding.databinding.RecyclerviewLayoutBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdi on 2017/7/3.
 */

public class RecyclerViewLayout extends BaseActivity {

    BindingAdapter adapter;
    List<String> list = new ArrayList<>();;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {

        RecyclerviewLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.recyclerview_layout);
        for (int i = 0; i < 10; i++) {
            list.add("item"+(i+1));
        }
        adapter = new BindingAdapter(list);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerview.setLayoutManager(manager);
        binding.recyclerview.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
