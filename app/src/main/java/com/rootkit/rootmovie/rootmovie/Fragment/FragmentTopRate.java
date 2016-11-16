package com.rootkit.rootmovie.rootmovie.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rootkit.rootmovie.rootmovie.R;

/**
 * Created by root on 11/15/16.
 */

public class FragmentTopRate extends android.support.v4.app.Fragment {

    public FragmentTopRate(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View rootView = inflater.inflate(R.layout.fragment_top_rate, container, false);
        return rootView;
    }

}
