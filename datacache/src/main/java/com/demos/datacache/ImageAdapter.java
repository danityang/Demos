package com.demos.datacache;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by yangdi on 2017/5/15.
 */

public class ImageAdapter extends BaseAdapter implements AbsListView.OnScrollListener{

    String imglist[];
    Context context;
    ImageLoader imageLoader;

    public ImageAdapter(Context context, String imglist[]) {
        this.imglist = imglist;
        this.context=context;

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public int getCount() {
        return imglist.length;
    }

    @Override
    public Object getItem(int position) {
        return imglist[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView = (ImageView) convertView.findViewById(R.id.img);
        viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }


    class ViewHolder{
        ImageView imageView;
    }
}
