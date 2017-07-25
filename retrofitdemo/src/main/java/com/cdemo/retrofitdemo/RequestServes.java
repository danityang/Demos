package com.cdemo.retrofitdemo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yangdi on 2017/6/7.
 */

public interface RequestServes {

    @GET("book/search")
    Call getSearchBooks(@Query("q") String name,
                        @Query("tag") String tag,
                        @Query("start") int start,
                        @Query("count") int cuont);


    @GET("position")
    Call<Person> getposition(@Query("userId") String userid);

    @POST("position")
    @FormUrlEncoded
    Call<Person> getposition2(@FieldMap Map<String, String>  map);

    @POST("gateway")
    @FormUrlEncoded
    Call<Person> login(@FieldMap Map<String, String>  map);

}
