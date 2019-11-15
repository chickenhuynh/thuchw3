package com.example.thuchw3;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CatViewHolder extends RecyclerView.ViewHolder {
    LinearLayout catLinearLayout;
    TextView nameOfCat;

    public CatViewHolder(View view){
        super(view);
        nameOfCat =view.findViewById(R.id.nameOfCat);
        catLinearLayout = view.findViewById(R.id.catLinearLayout);
    }

    @Override
    public String toString() {
        return super.toString() + " '" + nameOfCat.getText() + "'";
    }

}
