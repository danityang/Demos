package com.cdemo.databinding.viewmodel;

import android.databinding.BindingConversion;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

/**
 * Created by yangdi on 2017/7/25.
 */

public class Converters {

    @BindingConversion
    public static ColorDrawable converterStrintToDrawable(String str){
        int color = Color.parseColor(str);
        return new ColorDrawable(color);
    }
}
