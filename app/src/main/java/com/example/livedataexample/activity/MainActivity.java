package com.example.livedataexample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.livedataexample.Adapter.SourceAdapter;

import com.example.livedataexample.R;
import com.example.livedataexample.databinding.ActivityMainBinding;
import com.example.livedataexample.models.Model;
import com.example.livedataexample.viewmodel.GopiViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private   GopiViewModel gopiViewModel;
    List<Model.Sourcedata> gopiraju;
    SourceAdapter sourceAdapter;
    ActivityMainBinding binding2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding2= DataBindingUtil.setContentView(this,R.layout.activity_main);


        setSupportActionBar(binding2.toolbar);


        binding2.prograss.setVisibility(View.VISIBLE);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
      binding2.rl.setLayoutManager(linearLayoutManager);




        gopiViewModel=ViewModelProviders.of(this).get(GopiViewModel.class);
        gopirajusjdnf();

        gopiraju=new ArrayList<>();



    }

    private void gopirajusjdnf() {

        gopiViewModel.getLivedata().observe(this, model ->  {
                if (model!=null){

                gopiraju= model.getGopi();
                sourceAdapter=new SourceAdapter(MainActivity.this,gopiraju);
                    binding2.rl.setHasFixedSize(true);
                  binding2.prograss.setVisibility(View.GONE);
                    binding2.rl.setAdapter(sourceAdapter);
                      }
        });




 }


}