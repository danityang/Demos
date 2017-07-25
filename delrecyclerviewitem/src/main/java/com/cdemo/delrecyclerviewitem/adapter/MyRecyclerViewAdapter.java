package com.cdemo.delrecyclerviewitem.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdemo.delrecyclerviewitem.BR;
import com.cdemo.delrecyclerviewitem.R;
import com.cdemo.delrecyclerviewitem.viewmodel.ItemViewModel;

import java.util.HashSet;

/**
 * Created by yangdi on 2017/7/3.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MainViewHolder> {

    ObservableList<ItemViewModel> mDataList;
    HashSet<Integer> delList = new HashSet<Integer>();

    public MyRecyclerViewAdapter(ObservableList mDataList) {
        this.mDataList = mDataList;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.items, parent, false);
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final MainViewHolder holder, final int position) {
        holder.bindingData(mDataList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ItemViewModel itemViewModel = mDataList.get(position);
                if(delList.contains(position)){
                    delList.remove(position);
                    mDataList.get(position).setCkeched(false);
                }else{
                    delList.add(position);
                    mDataList.get(position).setCkeched(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    // 添加了待删除item的position
    public HashSet<Integer> getList() {
        return delList;
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;

        public MainViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindingData(ItemViewModel item) {
            binding.setVariable(BR.itemViewModel, item);
            binding.executePendingBindings();
        }

    }


}
