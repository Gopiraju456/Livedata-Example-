package com.example.livedataexample.Adapter;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.livedataexample.R;
import com.example.livedataexample.databinding.GopimodellayoutBinding;
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
        GopimodellayoutBinding bindingAdapter=GopimodellayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new SourceViewModel(bindingAdapter);

        /*        LayoutInflater ll=LayoutInflater.from(parent.getContext());
        View view=ll.inflate(R.layout.gopimodellayout,parent,false);

        return new SourceViewModel(view);

 */

    }

    @Override
    public void onBindViewHolder(@NonNull SourceViewModel holder, int position) {
        Model.Sourcedata soures=model.get(position);
        holder.gopimodellayoutBinding.setSourcedata(soures);

        holder.itemView.setOnClickListener(view -> {
                String  s=model.get(position).getCategory();
                goldraju(s);
            }
        );
        /*  holder.tv2.setText(model.get(position).getName());
        holder.tv3.setText(model.get(position).getDescription());
        holder.tv3.append(model.get(position).getLanguage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=model.get(position).getCategory();

                goldraju(s);
            }
        });

       */
    }

    private void goldraju(String url){
        Uri uri = Uri.parse(url);
        CustomTabsIntent.Builder intent_bulder = new CustomTabsIntent.Builder();
        intent_bulder.setShowTitle(true);
       // intent_bulder.setToolbarColor(ContextCompat.getColor(context, R.color.colorAccent));
      //  intent_bulder.setSecondaryToolbarColor(ContextCompat.getColor(context, R.color.design_default_color_primary_dark));
        intent_bulder.setExitAnimations(context, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        CustomTabsIntent customTabsIntent = intent_bulder.build();
        customTabsIntent.intent.setPackage("com.android.chrome");
        customTabsIntent.launchUrl(context, uri);
    }
    @Override
    public int getItemCount() {
        return model.size();
    }
    class SourceViewModel extends RecyclerView.ViewHolder{
        GopimodellayoutBinding gopimodellayoutBinding;

        public SourceViewModel(@NonNull GopimodellayoutBinding itemView) {
            super(itemView.getRoot());
           this. gopimodellayoutBinding= itemView;

            /*   tv2=itemView.findViewById(R.id.tv2);
            tv3=itemView.findViewById(R.id.tv3);

          */
        }
    }
}
