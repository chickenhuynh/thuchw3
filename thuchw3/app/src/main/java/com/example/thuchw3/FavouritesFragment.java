package com.example.thuchw3;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FavouritesFragment extends Fragment {


    RecyclerView recyclerView;

    RecyclerView.LayoutManager layoutManager;
    FavouriteCatAdapter favouriteCatAdapter;

    public FavouritesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);

        recyclerView = view.findViewById(R.id.favouriteRecycler);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        favouriteCatAdapter = new FavouriteCatAdapter(FavouriteCatDatabase.getFavouriteCats());
        recyclerView.setAdapter(favouriteCatAdapter);

        return view;


    }

}
