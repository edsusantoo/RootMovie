package com.rootkit.rootmovie.rootmovie.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rootkit.rootmovie.rootmovie.Adapter.RvAdapter;
import com.rootkit.rootmovie.rootmovie.Controller.ResultHeandle;
import com.rootkit.rootmovie.rootmovie.Controller.VolleyConnecting;
import com.rootkit.rootmovie.rootmovie.MainActivity;
import com.rootkit.rootmovie.rootmovie.R;

/**
 * Created by root on 11/15/16.
 */

public class FragmentUpComing extends android.support.v4.app.Fragment {

    private final String TAG = "MainActivity";

    //
    Context context;
    MainActivity activity;


    //

    VolleyConnecting volleyConnecting;


    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    RvAdapter rvAdapter;

    ItemObject.UpComingMovie upComingMovie;

    final static private String URLL = "https://api.themoviedb.org/3/movie/upcoming?api_key=50ec555cc1d67559ec5eb1bff307acce";


    public FragmentUpComing(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View rootView = inflater.inflate(R.layout.fragment_up_coming, container, false);

        layoutManager = new GridLayoutManager(this.getActivity(), 2);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_item_movie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        getUpComingMovie();

        return rootView;
    }

    private void getUpComingMovie() {
        volleyConnecting = new VolleyConnecting();
        volleyConnecting.getData(getActivity(), URLL, new ResultHeandle() {
            @Override
            public void resultData(String response) {

                Log.d(TAG, "Response " + response);

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                upComingMovie = gson.fromJson(response, ItemObject.UpComingMovie.class);


                rvAdapter = new RvAdapter(getActivity(), upComingMovie.upcoming);
                recyclerView.setAdapter(rvAdapter);




            }

            @Override
            public void errorResultData(String errorResponse) {

            }
        });
    }

}
