package com.cdemo.loadmorerecyclerview.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

/**
 * Created by yangdi on 2017/8/1.
 */

public class FooterEntity extends BaseObservable {

    public final ObservableField<String> loadingString = new ObservableField<>();
    public final ObservableField<String> noMoreString = new ObservableField<>();
    public final ObservableField<String> loadFailedString = new ObservableField<>();

    public final ObservableBoolean loadingVisiable = new ObservableBoolean(false);
    public final ObservableBoolean noMoreVisiable = new ObservableBoolean(false);
    public final ObservableBoolean loadFailedVisiable = new ObservableBoolean(false);


}
