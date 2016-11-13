package com.rootkit.rootmovie.rootmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rootkit.rootmovie.rootmovie.Adapter.RvAdapter;
import com.rootkit.rootmovie.rootmovie.Controller.MovieURL;
import com.rootkit.rootmovie.rootmovie.Controller.ResultHeandle;
import com.rootkit.rootmovie.rootmovie.Controller.VolleyConnecting;


public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    VolleyConnecting volleyConnecting;
    MovieURL movieURL;


    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    RvAdapter rvAdapter;

    ItemObject.UpComingMovie upComingMovie;

    final static private String URLL = "https://api.themoviedb.org/3/movie/upcoming?api_key=50ec555cc1d67559ec5eb1bff307acce";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layoutManager = new GridLayoutManager(getApplicationContext(), 2);

        recyclerView = (RecyclerView)findViewById(R.id.rv_item_movie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        getUpComingMovie();



    }

    private void getUpComingMovie() {
        volleyConnecting = new VolleyConnecting();
        volleyConnecting.getData(getApplicationContext(), URLL, new ResultHeandle() {
            @Override
            public void resultData(String response) {

                Log.d(TAG, "Response " + response);

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                upComingMovie = gson.fromJson(response, ItemObject.UpComingMovie.class);


                rvAdapter = new RvAdapter(MainActivity.this, upComingMovie.upcoming);
                recyclerView.setAdapter(rvAdapter);




            }

            @Override
            public void errorResultData(String errorResponse) {

            }
        });
    }
}
