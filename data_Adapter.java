package com.example.lokie.bmi;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class data_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public String formula;
    public Image img;

    public data_Adapter(String formula, Image img, String weight) {
        this.formula = formula;
        this.img = img;
        this.weight = weight;
    }

    public String weight;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
