package com.example.livedataexample.Adapter;

import android.content.Context;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.livedataexample.R;
import com.example.livedataexample.models.Model;

import java.util.List;

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.SourceViewModel>{

    Context context;
    List<Model.Sourcedata> model;

    public SourceAdapter(Context context, List<Model.Sourcedata> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public SourceViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ll=LayoutInflater.from(parent.getContext());
        View view=ll.inflate(R.layout.gopimodellayout,parent,false);

        return new SourceViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SourceViewModel holder, int position) {
        holder.tv2.setText(model.get(position).getName());
        holder.tv3.setText(model.get(position).getDescription());
        holder.tv3.append(model.get(position).getLanguage());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    class SourceViewModel extends RecyclerView.ViewHolder{

        TextView tv2,tv3;

        public SourceViewModel(@NonNull View itemView) {
            super(itemView);
            tv2=itemView.findViewById(R.id.tv2);
            tv3=itemView.findViewById(R.id.tv3);
        }
    }
}
