package com.cdemo.databinding.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by yangdi on 2017/7/5.
 */

public class RecyclerBean extends BaseObservable {

    String itemContent;
    String itemIndex;

    public RecyclerBean(String itemContent, String itemIndex) {
        this.itemContent = itemContent;
        this.itemIndex = itemIndex;
    }
    @Bindable
    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
        notifyPropertyChanged(BR.itemContent);
    }

    @Bindable
    public String getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(String itemIndex) {
        this.itemIndex = itemIndex;
        notifyPropertyChanged(BR.itemIndex);
    }
}
