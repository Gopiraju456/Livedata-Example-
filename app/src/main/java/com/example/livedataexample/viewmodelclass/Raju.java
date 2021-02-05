package com.example.livedataexample.viewmodelclass;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.livedataexample.api.ApiInaterface;
import com.example.livedataexample.api.Apiclient;
import com.example.livedataexample.models.Model;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Raju {
    ApiInaterface apiInaterface;
    public Raju(){
        apiInaterface=Apiclient.getRetrofit().create(ApiInaterface.class);
    }
    public LiveData<Model>  getvalues(){
        final MutableLiveData<Model>  data=new MutableLiveData<>();
        apiInaterface.getinterface().enqueue(new Callback<Model>() {
            @Override
            public void onResponse(@Nullable  Call<Model> call,@Nullable Response<Model> response) {
                if (response!=null){
                    data.setValue(response.body());

                    // Log.d("#################","data responce");
                }
            }

            @Override
            public void onFailure(@Nullable Call<Model> call,@Nullable Throwable t) {

                data.setValue(null);

              //   Log.d("#########","data not ");

            }
        });
    return  data;
    }


}
