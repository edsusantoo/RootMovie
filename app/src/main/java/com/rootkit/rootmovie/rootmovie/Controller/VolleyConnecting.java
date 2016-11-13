package com.rootkit.rootmovie.rootmovie.Controller;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by root on 11/13/16.
 */

public class VolleyConnecting {

    public void getData(Context context, String URL, final ResultHeandle resultHeandle){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                resultHeandle.resultData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resultHeandle.errorResultData(error.toString());
            }
        });
    }
}
