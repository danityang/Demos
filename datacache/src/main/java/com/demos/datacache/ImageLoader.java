package com.demos.datacache;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ListView;

/**
 * Created by yangdi on 2017/5/15.
 */
public class ImageLoader {

    private LruCache<String,Bitmap> cache;
    private ListView listView;

}
