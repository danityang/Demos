package com.cdemo.loadmorerecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cdemo.loadmorerecyclerview.R;
import com.cdemo.loadmorerecyclerview.idata.ItemClickListener;

import java.util.List;

/**
 * Created by yangdi on 2017/8/1.
 */

public class CommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> mDataList;
    int ITEM = 0;
    int FOOTER = 1;
    int STATE = 0;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setmDataList(List<String> mDataList) {
        this.mDataList = mDataList;
    }

    public void setSTATE(int STATE) {
        this.STATE = STATE;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM) {
            return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.common_item, parent, false));
        } else {
            return new LoadMoreFooterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.common_loadmore_footer, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ItemHolder) {
            ((ItemHolder) holder).textView.setText(mDataList.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.itemSelected(position);
                }
            });
        } else {
            switch (STATE) {
                case 1:// loading more
                    ((LoadMoreFooterHolder) holder).loadMoreTextView.setVisibility(View.VISIBLE);
                    ((LoadMoreFooterHolder) holder).noMoreTextView.setVisibility(View.GONE);
                    break;
                case 2:// no more
                    ((LoadMoreFooterHolder) holder).loadMoreTextView.setVisibility(View.GONE);
                    ((LoadMoreFooterHolder) holder).noMoreTextView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if ((position + 1) == getItemCount()) {
            return FOOTER;
        } else {
            return ITEM;
        }
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ItemHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_text);
        }
    }


    class LoadMoreFooterHolder extends RecyclerView.ViewHolder {

        TextView loadMoreTextView;
        TextView noMoreTextView;

        public LoadMoreFooterHolder(View itemView) {
            super(itemView);
            loadMoreTextView = (TextView) itemView.findViewById(R.id.loadmore_text);
            noMoreTextView = (TextView) itemView.findViewById(R.id.nomore_text);
        }
    }
}
