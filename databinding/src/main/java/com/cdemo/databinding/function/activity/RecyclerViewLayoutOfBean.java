package com.cdemo.databinding.function.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.cdemo.databinding.R;
import com.cdemo.databinding.adapter.BindingAdapterOfBean;
import com.cdemo.databinding.bean.RecyclerBean;
import com.cdemo.databinding.databinding.RecyclerviewLayoutBeanBinding;
import com.cdemo.databinding.interfac.ClickListener;

/**
 * Created by yangdi on 2017/7/3.
 */

public class RecyclerViewLayoutOfBean extends BaseActivity implements ClickListener{

    BindingAdapterOfBean adapter;
    ObservableList<RecyclerBean> observableList = new ObservableArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {

        RecyclerviewLayoutBeanBinding binding = DataBindingUtil.setContentView(this, R.layout.recyclerview_layout_bean);

        observableList.add(new RecyclerBean("ITEM1","1"));
        observableList.add(new RecyclerBean("ITEM2","2"));
        adapter = new BindingAdapterOfBean(observableList);
        adapter.clickListener = this;
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerview.setLayoutManager(manager);
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(RecyclerViewLayoutOfBean.this, 1));

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int postion) {
        Toast.makeText(RecyclerViewLayoutOfBean.this, "Click "+ postion, Toast.LENGTH_LONG).show();
        observableList.remove(observableList.get(postion));
        adapter.notifyDataSetChanged();
    }
}
