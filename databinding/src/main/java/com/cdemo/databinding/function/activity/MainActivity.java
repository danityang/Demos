package com.cdemo.databinding.function.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cdemo.databinding.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void basicSampleClick(View v){
        startActivity(new Intent(MainActivity.this, BasicSample.class));
    }

    public void includeLayoutClick(View v){
        startActivity(new Intent(MainActivity.this, IncludeLayout.class));
    }

    public void collectionClick(View v){
        startActivity(new Intent(MainActivity.this, RecyclerViewScroll.class));
    }

    public void recyclerViewClick(View v){
        startActivity(new Intent(MainActivity.this, RecyclerViewWithDataBinding.class));
    }

    public void viewShowAndHideClick(View v){
        startActivity(new Intent(MainActivity.this, ViewShowAndHide.class));
    }

    public void resourceBinding(View v){
        startActivity(new Intent(MainActivity.this, ResourceBinding.class));
    }

    public void dataBindingCustom_s(View v){
        startActivity(new Intent(MainActivity.this, CustomBindingAdapter.class));
    }

    public void multiLayoutRecyclerView(View v){
        startActivity(new Intent(MainActivity.this, MultiLayoutRecyclerView.class));
    }


}
