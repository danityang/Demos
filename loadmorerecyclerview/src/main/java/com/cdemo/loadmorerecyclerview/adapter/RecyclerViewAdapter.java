package com.cdemo.loadmorerecyclerview.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdemo.loadmorerecyclerview.BR;
import com.cdemo.loadmorerecyclerview.R;
import com.cdemo.loadmorerecyclerview.idata.ItemClickListener;
import com.cdemo.loadmorerecyclerview.viewmodel.FooterEntity;
import com.cdemo.loadmorerecyclerview.viewmodel.ItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdi on 2017/8/1.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<ItemEntity> mDataList;
    List<FooterEntity> mFooterList = new ArrayList<>();
    volatile int ITEM = 0;
    volatile int FOOTER = 1;
    volatile int STATE = -1;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(List<ItemEntity> mDataList) {
        this.mDataList = mDataList;
    }

    public void setmDataList(List<ItemEntity> mDataList) {
        this.mDataList = mDataList;
//        mFooterList.add(new FooterEntity());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM) {
            return new ItemHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false));
        } else if (viewType == FOOTER) {
            return new FooterHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.loadmore_footer, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ItemHolder) {
            ((ItemHolder) holder).bindingData(mDataList.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.itemSelected(position);
                }
            });
        } else if (holder instanceof FooterHolder) {
            FooterEntity f = new FooterEntity();
            ((FooterHolder) holder).bindingData(f);
            if (STATE == 1) {// 正在加载
                f.loadingVisiable.set(true);
                f.noMoreVisiable.set(false);
            } else if(STATE == 2){// 没有更多
                f.noMoreVisiable.set(true);
                f.loadingVisiable.set(false);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return FOOTER;
        } else {
            return ITEM;
        }
    }

    public void setSTATE(int STATE) {
        this.STATE = STATE;
        notifyDataSetChanged();
    }
}


class ItemHolder extends RecyclerView.ViewHolder {

    ViewDataBinding binding;

    public ItemHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindingData(ItemEntity item) {
        binding.setVariable(BR.viewModel, item);
        binding.executePendingBindings();
    }

}


class FooterHolder extends RecyclerView.ViewHolder {

    ViewDataBinding binding;

    public FooterHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindingData(FooterEntity item) {
        binding.setVariable(BR.viewModel, item);
        binding.executePendingBindings();
    }

}