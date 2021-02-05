package com.example.livedataexample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.livedataexample.Adapter.SourceAdapter;

import com.example.livedataexample.R;
import com.example.livedataexample.models.Model;
import com.example.livedataexample.viewmodel.GopiViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private   GopiViewModel gopiViewModel;
    List<Model.Sourcedata> gopiraju;
    RecyclerView recyclerView;
    SourceAdapter sourceAdapter;

    Toolbar toolbar;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bar=findViewById(R.id.prograss);
        bar.setVisibility(View.VISIBLE);


        recyclerView =findViewById(R.id.rl);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
      recyclerView.setLayoutManager(linearLayoutManager);




        gopiViewModel=ViewModelProviders.of(this).get(GopiViewModel.class);
        gopirajusjdnf();

        gopiraju=new ArrayList<>();


    }

    private void gopirajusjdnf() {

        gopiViewModel.getLivedata().observe(this, new Observer<Model>() {
            @Override
            public void onChanged(Model model) {
                if (model!=null){

                gopiraju= model.getGopi();
                sourceAdapter=new SourceAdapter(MainActivity.this,gopiraju);
                    recyclerView.setHasFixedSize(true);
                    bar.setVisibility(View.GONE);
                    recyclerView.setAdapter(sourceAdapter);
                      }}
        });


       /* ApiInaterface gopi=Apiclient.getRetrofit().create(ApiInaterface.class);
        Call<Model>  raju=gopi.getinterface();
        raju.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response!=null){
                    Toast.makeText(MainActivity.this, "Gopiraju", Toast.LENGTH_SHORT).show();
                    Log.i("$$$$$$$$$$444",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });

        */


 }


}