package com.cdemo.retrofitdemo;

import retrofit2.Call;

/**
 * Created by yangdi on 2017/6/7.
 */

public class Main2 {

    class Person{
        String name;

    }

    public interface intf{
//        @GET("square)
        Call<Person> call();
    }


    public static void main(String args[]){

    }


}
