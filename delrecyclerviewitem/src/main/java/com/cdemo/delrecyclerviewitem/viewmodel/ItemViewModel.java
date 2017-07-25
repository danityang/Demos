package com.cdemo.delrecyclerviewitem.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.cdemo.delrecyclerviewitem.BR;

/**
 * Created by yangdi on 2017/7/3.
 */

public class ItemViewModel extends BaseObservable {

    private boolean isVisiable;
    private boolean isCkeched;
    private String title;

    public ItemViewModel(boolean isVisitable, boolean isCkeched, String title) {
        this.isVisiable = isVisitable;
        this.isCkeched = isCkeched;
        this.title = title;
    }

    @Bindable
    public boolean isVisitable() {
        return isVisiable;
    }

    public void setVisitable(boolean visiable) {
        isVisiable = visiable;
        notifyPropertyChanged(BR.visitable);
    }

    @Bindable
    public boolean isCkeched() {
        return isCkeched;
    }

    @Bindable
    public String getTitle() {
        return title;
    }


    public void setCkeched(boolean ckeched) {
        isCkeched = ckeched;
        notifyPropertyChanged(BR.ckeched);
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

}
