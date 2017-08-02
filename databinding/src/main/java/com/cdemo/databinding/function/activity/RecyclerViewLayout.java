package com.cdemo.databinding.function.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    List<String> list = new ArrayList<>();
    RecyclerviewLayoutBinding binding;
    LinearLayoutManager linearLayoutManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {

        binding = DataBindingUtil.setContentView(this, R.layout.recyclerview_layout);
        for (int i = 0; i < 20; i++) {
            list.add("item" + (i + 1));
        }
        adapter = new BindingAdapter(list);

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(getApplicationContext(), 1));

        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.addOnScrollListener(scrollListener);

        adapter.notifyDataSetChanged();

        linearLayoutManager = (LinearLayoutManager) binding.recyclerview.getLayoutManager();
    }

    int itemCount = 0;
    int lastVisibleItemPosition;

    RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {


        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            itemCount = linearLayoutManager.getItemCount();
            lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();

            if(itemCount < lastVisibleItemPosition + 5){
                for (int i = 0; i < 10; i++) {
                    list.add("itemAdd" + (i + 1));
                }
                adapter.notifyDataSetChanged();
            }
        }
    };

}
