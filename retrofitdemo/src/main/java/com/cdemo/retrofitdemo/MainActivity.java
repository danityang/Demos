package com.cdemo.retrofitdemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String OAUrlLogin = "http://openapi.4008990000.net/";
    public static String GET_POSITION = "http://192.168.12.84:8084/api/attendance/query/";

    public String TAG = "Retrofit_Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {

        // 请求结果json拦截器
        Interceptor mLoggingInterceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                final Request request = chain.request();
                final okhttp3.Response response = chain.proceed(request);
                final ResponseBody responseBody = response.body();
                final long contentLength = responseBody.contentLength();
                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE); // Buffer the entire body.
                Buffer buffer = source.buffer();
                Charset charset = Charset.forName("UTF-8");
                MediaType contentType = responseBody.contentType();
                if (contentType != null) {
                    try {
                        charset = contentType.charset(charset);
                    } catch (UnsupportedCharsetException e) {
                        Log.i(TAG, "Couldn't decode the response body; charset is likely malformed.");
                        return response;
                    }
                }
                if (contentLength != 0) {
                    Log.i(TAG, "JSON_RESULT>>  \n" + buffer.clone().readString(charset));
                }
                return response;
            }
        };

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(35, TimeUnit.SECONDS)//设置超时 35秒
                .connectTimeout(35, TimeUnit.SECONDS)
                .writeTimeout(35, TimeUnit.SECONDS)
                .addInterceptor(mLoggingInterceptor)
                .retryOnConnectionFailure(true);
        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GET_POSITION)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        // 打印返回的json数据拦截器


        RequestServes requestServes = retrofit.create(RequestServes.class);

        // 传递参数
        final Call call = requestServes.getposition("24a0041afe6c07a00dc1c0a95dedbd5a");

        Map<String,String> map = new HashMap<String, String>();
        map.put("userId","24a0041afe6c07a00dc1c0a95dedbd5a");

        final Map<String, String> map2 = new HashMap<>();
        map2.put("username", "AABB");
        map2.put("password", "18982229217");
        map2.put("loginType", "01");
        map2.put("source", "00");
        map2.put("v", "90");
        map2.put("method", "appcms.user.login");
        map2.put("app_id", "1fec63ab941c7ca2");
        map2.put("format", "JSON");
        map2.put("sign_method", "MD5");
        map2.put("timestamp", System.currentTimeMillis()+"");

        final Call call2 = requestServes.getposition2(map);

        // 登录
        final Call call3 = requestServes.login(map2);

        Call clone = call.clone();

        clone.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.i(TAG, "onResponse: " + response.message().toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });


    }
}
