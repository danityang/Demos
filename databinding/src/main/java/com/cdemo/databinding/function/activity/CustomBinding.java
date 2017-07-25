package com.cdemo.databinding.function.activity;

import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cdemo.databinding.R;
import com.cdemo.databinding.databinding.CustomBindingActivityBinding;

/**
 * Created by yangdi on 2017/7/24.
 */

public class CustomBinding extends BaseActivity {

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomBindingActivityBinding binding = DataBindingUtil.setContentView(CustomBinding.this, R.layout.custom_binding_activity);
        Resources rec = getResources();
        binding.setImgResource(R.mipmap.ic_launcher);
        binding.setHeight((float) 500);
    }

    @BindingAdapter("imgRes")
    public static void setImg(ImageView img, int resource){
        img.setImageResource(resource);
    }

    @BindingAdapter("height")
    public static void setHeight(ImageView img, float height){
        ViewGroup.LayoutParams params = img.getLayoutParams();
        params.height = (int) height;
        img.setLayoutParams(params);
    }

}
