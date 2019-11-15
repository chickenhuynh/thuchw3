package com.example.thuchw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.thuchw3.APIClasses.Cat;
import com.example.thuchw3.APIClasses.TheCatAPI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class DetailActivity extends AppCompatActivity {

    Context context;

    TextView nameOfCat;
    ImageView catImage;
    ImageButton starBtn;
    TextView description;
    TextView origin;
    TextView temper;
    TextView lifespan;
    TextView dogFriendliness;
    TextView weight;
    TextView wikipediaLink;

    Cat currentCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        context = this;

        nameOfCat = findViewById(R.id.nameOfCat);
        catImage = findViewById(R.id.catImage);
        starBtn = findViewById(R.id.starBtn);
        description = findViewById(R.id.catDescription);
        origin = findViewById(R.id.origin);
        temper = findViewById(R.id.temper);
        lifespan = findViewById(R.id.lifeSpan);
        dogFriendliness = findViewById(R.id.dogF);
        weight = findViewById(R.id.weight);
        wikipediaLink = findViewById(R.id.wikipediaLink);

        Intent intent = getIntent();
        final String intentDetails = intent.getStringExtra("catID");


        String apikey = "0b0d6904-43bd-4a77-92e0-eab63b678d6e";
        String url = "https://api.thecatapi.com/v1/images/search?api_key="+apikey+"&breed_id="+intentDetails;
        final RequestQueue requestQueue = Volley.newRequestQueue(this);


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);


                Gson gson = new Gson();
                Type collectionType = new TypeToken<Collection<TheCatAPI>>(){}.getType();
                ArrayList<TheCatAPI> catAPI =gson.fromJson(response, collectionType);
                requestQueue.stop();


                TheCatAPI currentApi = catAPI.get(0);
                currentCat = currentApi.getCatBreeds().get(0);

                nameOfCat.setText(currentCat.getName());
                Glide.with(context).load(currentApi.getUrl()).into(catImage);
                description.setText(currentCat.getDescription());
                origin.setText("Origin: "+currentCat.getOrigin());
                lifespan.setText("Lifespan: "+currentCat.getLifeSpan());
                weight.setText("Weight: "+currentCat.getWeight().getMetric());
                temper.setText("Temp: \n"+currentCat.getTemp());
                dogFriendliness.setText("Dog Friendliness: "+currentCat.getDogfriendliness());
                wikipediaLink.setText("Wikipedia Link: \n"+currentCat.getWikipediaUrl());


                if (FavouriteCatDatabase.favouriteCatsMap.containsKey(intentDetails)){
                    starBtn.setImageResource(R.drawable.star_pressed);
                    starBtn.setTag(true);
                } else {
                    starBtn.setImageResource(R.drawable.star_unpressed);
                    starBtn.setTag(false);
                }


            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("There is a Volley Error");
            }
        };


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);
    }


    public void onToggleStar(View view){
        if (starBtn.getTag().equals(true)){
            FavouriteCatDatabase.removeFromFavourite(currentCat);
            starBtn.setTag(false);
            starBtn.setImageResource(R.drawable.star_unpressed);
        } else {
            FavouriteCatDatabase.addToFavourites(currentCat);
            starBtn.setTag(true);
            starBtn.setImageResource(R.drawable.star_pressed);
        }

    }
}
