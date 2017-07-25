package com.cdemo.databinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cdemo.databinding.BR;
import com.cdemo.databinding.R;

import java.util.List;

/**
 * Created by m on 2017/5/6.
 */

public class BindingAdapter extends RecyclerView.Adapter<BindingAdapter.BindingHolder> {

    List<String> list;

    public BindingAdapter(List list) {
        this.list = list;
    }

    /**
     * @return 返回的是adapter的view
     */
    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.view_item, parent, false);
        return new BindingHolder(binding);
    }
    /*
    * 数据绑定
    * */
    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class BindingHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;
         /**
         * @param binding   可以看作是这个hodler代表的布局的马甲，getRoot()方法会返回整个holder的最顶层的view
         * */
        public BindingHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(String rBean) {
            binding.setVariable(BR.string, rBean);
            binding.executePendingBindings();
        }

    }
}
