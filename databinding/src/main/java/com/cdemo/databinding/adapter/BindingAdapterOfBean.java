package com.cdemo.databinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdemo.databinding.BR;
import com.cdemo.databinding.R;
import com.cdemo.databinding.bean.RecyclerBean;
import com.cdemo.databinding.interfac.ClickListener;

import java.util.List;

/**
 * Created by m on 2017/5/6.
 */

public class BindingAdapterOfBean extends RecyclerView.Adapter<BindingAdapterOfBean.BindingHolder> {

    List<RecyclerBean> list;
   public ClickListener clickListener;

    public BindingAdapterOfBean(List list) {
        this.list = list;
    }

    /**
     * @return 返回的是adapter的view
     */
    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.bean_item, parent, false);
        return new BindingHolder(binding);
    }
    /*
    * 数据绑定
    * */
    @Override
    public void onBindViewHolder(BindingHolder holder, final int position) {
        holder.bindData(list.get(position));
        holder.binding.getRoot().findViewById(R.id.item_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    // ViewHolder
    static class BindingHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;
         /**
         * @param binding   可以看作是这个hodler代表的布局的马甲，getRoot()方法会返回整个holder的最顶层的view
         * */
        public BindingHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(RecyclerBean rBean) {
            binding.setVariable(BR.bean, rBean);
            binding.executePendingBindings();
        }

    }
}
