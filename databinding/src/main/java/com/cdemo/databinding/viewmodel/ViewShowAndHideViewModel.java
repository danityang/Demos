package com.cdemo.databinding.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

import com.cdemo.databinding.databinding.ViewShowAndHideBinding;

/**
 * Created by yangdi on 2017/7/21.
 */

public class ViewShowAndHideViewModel extends BaseObservable{

    Context context;
    ViewShowAndHideBinding bind;

    public final ObservableBoolean showNoData = new ObservableBoolean();
    public final ObservableInt showPage = new ObservableInt();

    public ViewShowAndHideViewModel(Context context, ViewShowAndHideBinding bind) {
        this.context = context;
        this.bind = bind;

        showNoData.set(false);
//        bind.tvNodata.setVisibility(View.GONE);
    }





}
