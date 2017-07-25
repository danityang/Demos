package com.cdemo.databinding.function.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangdi on 2017/6/29.
 */

public class CollectionLayout extends BaseActivity {

    String str[] = new String[]{"str0,str1,str2"};
    List list = new ArrayList();
    SparseArray<String> sparseArray = new SparseArray<>(2);
    Map<String, String> map = new HashMap<>();
    String key = "name";
    int index = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
