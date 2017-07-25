package com.cdemo.delrecyclerviewitem.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.cdemo.delrecyclerviewitem.R;

import java.util.ArrayList;
import java.util.List;

import me.tatarka.bindingcollectionadapter.BaseItemViewSelector;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;

/**
 * Created by yangdi on 2017/7/3.
 */

public class ActivityMainViewModel {

    public static String TAG="ActivityMainViewModel";

    List<Integer> delList = new ArrayList<>();
    public final ObservableList<ItemViewModel> itemLists = new ObservableArrayList<ItemViewModel>();


    public final ItemViewSelector<ItemViewModel> itemView = new BaseItemViewSelector<ItemViewModel>() {

        @Override
        public void select(ItemView itemView, int position, ItemViewModel item) {
            itemView.set(com.cdemo.delrecyclerviewitem.BR.itemViewModel, R.layout.items);
        }


    };

    public void addItem() {

    }

    public void removeItem(int i) {
        /*Map<Integer,Integer> delMap = new HashMap();
        for (int j = 0; j < itemLists.size(); j++) {
            ItemViewModel item = itemLists.get(j);
            if(item.isCheckBoxChecked()){
                delMap.put(j,j);
                Log.i("itemPosition","j "+j);
            }
        }*/
        itemLists.remove(0);
    }

    public void editItem() {
        for (int i = 0; i < itemLists.size(); i++) {
            ItemViewModel item = itemLists.get(i);
            if (item.isCkeched()) {
                item.setCkeched(false);
            } else {
                item.setCkeched(true);
            }
        }
    }

}
