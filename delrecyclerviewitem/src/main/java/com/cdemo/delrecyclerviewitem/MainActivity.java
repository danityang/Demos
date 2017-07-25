package com.cdemo.delrecyclerviewitem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cdemo.delrecyclerviewitem.databinding.ActivityMainBinding;
import com.cdemo.delrecyclerviewitem.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainViewModel(MainActivity.this, binding);

    }


}
