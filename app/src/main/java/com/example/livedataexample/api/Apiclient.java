package com.example.livedataexample.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {

  public static String BaseApi ="https://newsapi.org/v2/";
    public static  Retrofit retrofit;
    public static  Retrofit getRetrofit(){
        retrofit=new Retrofit.Builder()
                .baseUrl(BaseApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
