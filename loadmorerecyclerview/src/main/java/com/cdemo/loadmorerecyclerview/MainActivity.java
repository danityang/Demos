package com.cdemo.loadmorerecyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cdemo.loadmorerecyclerview.adapter.CommonAdapter;
import com.cdemo.loadmorerecyclerview.adapter.RecyclerViewAdapter;
import com.cdemo.loadmorerecyclerview.databinding.ActivityMainBinding;
import com.cdemo.loadmorerecyclerview.idata.ItemClickListener;
import com.cdemo.loadmorerecyclerview.viewmodel.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerViewAdapter adapter;
    CommonAdapter commonAdapter;
    List<ItemEntity> mDataList;
    List<String> mStringList;
    volatile int page = 0;
    volatile int totalPage = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        adapter = new RecyclerViewAdapter();
        commonAdapter = new CommonAdapter();
        commonAdapter.setItemClickListener(this);
        adapter.setItemClickListener(this);
        binding.recyclerView.setAdapter(adapter);
//        binding.recyclerView.setAdapter(commonAdapter);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, 1));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        scrollListener(binding.recyclerView);
        initData();
    }


    private void initData() {
        mDataList = new ArrayList<>();
        mStringList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemEntity item = new ItemEntity();
            item.setItemString("ITEM"+i);
            mDataList.add(item);
        }
        adapter.setmDataList(mDataList);
        /*for (int i = 0; i < 10; i++) {
            mStringList.add("Item" + (i + 1));
        }

        commonAdapter.setmDataList(mStringList);*/
    }

    private int totalItemCount;
    private int lastVisibleItemPosition;
    private LinearLayoutManager linearLayoutManager;


    private void scrollListener(RecyclerView recyclerView) {

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        }

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                totalItemCount = recyclerView.getAdapter().getItemCount();
                lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();

                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItemPosition + 1 >= totalItemCount) {
                    if (page < totalPage) {
                        // loadmore
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                adapter.setSTATE(1);
                                loadMoreData();
//                                commonAdapter.setSTATE(1);
                                page++;
                            }
                        }, 2000);
                    } else {
                        // nomore
//                        commonAdapter.setSTATE(2);
                        adapter.setSTATE(2);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                /*int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();
                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                    if (page < totalPage) {
                        // loadmore
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loadMoreData();
                                page++;
//                                commonAdapter.setSTATE(1);
                                adapter.setSTATE(1);
                            }
                        }, 2000);
                    } else {
                        // nomore
//                        commonAdapter.setSTATE(2);
                        adapter.setSTATE(2);
                    }
                }*/
            }
        });
    }

    private void loadMoreData() {
       /* for (int i = 0; i < 10; i++) {
            mStringList.add("New Item" + (i + 1));
        }
        commonAdapter.setmDataList(mStringList);*/
        for (int i = 0; i < 10; i++) {
            ItemEntity item = new ItemEntity();
            item.setItemString("New Item"+i);
            mDataList.add(item);
        }
        adapter.setmDataList(mDataList);
    }

    @Override
    public void itemSelected(int position) {
        Toast.makeText(MainActivity.this,"position "+position,Toast.LENGTH_LONG).show();
    }
}
