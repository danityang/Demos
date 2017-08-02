package com.cdemo.loadmorerecyclerview.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.cdemo.loadmorerecyclerview.BR;

/**
 * Created by yangdi on 2017/8/1.
 */

public class ItemEntity extends BaseObservable{

    private String itemString;

    @Bindable
    public String getItemString() {
        return itemString;
    }

    public void setItemString(String itemString) {
        this.itemString = itemString;
        notifyPropertyChanged(BR.itemString);
    }
}
