package com.cdemo.delrecyclerviewitem.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.cdemo.delrecyclerviewitem.adapter.MyRecyclerViewAdapter;
import com.cdemo.delrecyclerviewitem.databinding.ActivityMainBinding;
import com.cdemo.delrecyclerviewitem.model.IEditAbleListener;
import com.cdemo.delrecyclerviewitem.model.Listener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yangdi on 2017/7/3.
 */
public class MainViewModel extends BaseObservable implements IEditAbleListener, Listener {


    private boolean isDelBtnVisiable;

    @Bindable
    public boolean isDelBtnVisiable() {
        return isDelBtnVisiable;
    }

    public void setDelBtnVisiable(boolean delBtnVisiable) {
        isDelBtnVisiable = delBtnVisiable;
        notifyPropertyChanged(BR.delBtnVisiable);
    }

    Context context;
    ObservableList<ItemViewModel> mDataList = new ObservableArrayList<>();
    MyRecyclerViewAdapter myRecyclerViewAdapter;

    public MainViewModel(Context context, ActivityMainBinding binding) {
        this.context = context;
        addData();
        binding.setEditListener(this);
        binding.setListener(this);
        binding.setMainViewModel(this);
        binding.mainRecyclerview.setLayoutManager(new LinearLayoutManager(context, 1, false));
        binding.mainRecyclerview.setItemAnimator(new DefaultItemAnimator());
        binding.mainRecyclerview.addItemDecoration(new DividerItemDecoration(context, 1));
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(mDataList);
        binding.mainRecyclerview.setAdapter(myRecyclerViewAdapter);


    }

    private void addData() {
        for (int i = 0; i <= 6; i++) {
            mDataList.add(new ItemViewModel(false, false, "ITEM" + i));
        }
    }

    @Override
    public void editable(View view) {
        if(isDelBtnVisiable())
            setDelBtnVisiable(false);
        else
            setDelBtnVisiable(true);

        for (int i = 0; i < mDataList.size(); i++) {
            if (mDataList.get(i).isVisitable()) {
                mDataList.get(i).setVisitable(false);
            } else {
                mDataList.get(i).setVisitable(true);
            }
        }
    }

    @Override
    public void removeItem(View v) {
        HashSet<Integer> list = myRecyclerViewAdapter.getList();
        List<ItemViewModel> delItem = new ArrayList<>();
        for (Integer i : list) {
            delItem.add(mDataList.get(i));
        }
        for (ItemViewModel item : delItem) {
            mDataList.remove(item);
        }
        myRecyclerViewAdapter.notifyDataSetChanged();
        list.clear();
    }
}
