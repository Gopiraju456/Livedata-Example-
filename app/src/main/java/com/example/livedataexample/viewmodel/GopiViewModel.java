package com.example.livedataexample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.livedataexample.models.Model;
import com.example.livedataexample.viewmodelclass.Raju;


public class GopiViewModel extends ViewModel {
    public Raju raju;

    public GopiViewModel() {
        raju=new Raju();
    }
  public LiveData<Model> getLivedata(){
        return raju.getvalues();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}

