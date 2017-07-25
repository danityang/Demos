package com.cdemo.retrofitdemo;

import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 加密方式，系统参数
 * Created by libo on 2016/8/3.
 */

public class ApiHelper {

    Map<String, String> resultmap;

    public String TAG = "ApiHelper";

    public String getSign(Map<String, String> parameters) {

        Map<String, String> map = new HashMap<>();

        //-------系统级参数--------
//        map.put("access_token", APP.mAccess_OA_Token);
        map.put("version", "1.0");
        map.put("sign_method", "MD5");
        map.put("app_id", "1fec63ab941c7ca2");
//        map.put("app_key", Constans.AppKey_Company);
        map.put("timestamp", System.currentTimeMillis() + "");
        map.put("format", "JSON");

        //--------业务级参数--------
        Iterator<Map.Entry<String, String>> it = parameters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            //当业务级参数值为空时，不参与排序
            if (next.getValue() != null ) {
                map.put(next.getKey(), next.getValue());
            }
        }

        //map 按照Ascoll码排序
        if (map.size() > 1) {
            resultmap = new TreeMap<>();
            resultmap.putAll(map);
        } else {
            resultmap = map;
        }

        Iterator iterator = resultmap.entrySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String value = entry.getValue() + "";
            stringBuilder.append(entry.getKey()).append("=").append(value).append("&");
        }
        String stringSorted = stringBuilder.substring(0, stringBuilder.length() - 1);
        //LogUtils.i("stringSorted -->" + stringSorted);
        Log.i(TAG, stringSorted);
        return MD5.md5(stringSorted);
    }

    public Map<String, String> getResultmap() {
        return resultmap;
    }
}
