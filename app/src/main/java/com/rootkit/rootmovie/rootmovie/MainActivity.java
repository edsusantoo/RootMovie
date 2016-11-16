package com.rootkit.rootmovie.rootmovie;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rootkit.rootmovie.rootmovie.Adapter.RvAdapter;
import com.rootkit.rootmovie.rootmovie.Controller.MovieURL;
import com.rootkit.rootmovie.rootmovie.Controller.ResultHeandle;
import com.rootkit.rootmovie.rootmovie.Controller.VolleyConnecting;
import com.rootkit.rootmovie.rootmovie.Fragment.FragmentPopular;
import com.rootkit.rootmovie.rootmovie.Fragment.FragmentTopRate;
import com.rootkit.rootmovie.rootmovie.Fragment.FragmentUpComing;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;


public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(@IdRes int menuItemId) {
                switch(menuItemId){
                    case R.id.up_coming:
                        FragmentUpComing fragmentUpComing = new FragmentUpComing();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragmentUpComing).commit();
                        break;
                    case R.id.pupular:
                        FragmentPopular fragmentPopular = new FragmentPopular();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragmentPopular).commit();
                        break;
                    case R.id.movie:
                        FragmentTopRate fragmentTopRate = new FragmentTopRate();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragmentTopRate).commit();
                        break;

                }
            }
        });

        bottomBar.setActiveTabColor("#C2185B");

        //








    }


}
