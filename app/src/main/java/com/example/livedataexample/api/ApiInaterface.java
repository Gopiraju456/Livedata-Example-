package com.example.livedataexample.api;

import com.example.livedataexample.models.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInaterface {

    @GET("sources?apiKey=c6b66ad2d4fd4cafb451ee8292e1ba25")
    Call<Model>  getinterface();
}
//https://newsapi.org/v2/sources?apiKey=c6b66ad2d4fd4cafb451ee8292e1ba25