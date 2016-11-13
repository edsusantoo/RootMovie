package com.rootkit.rootmovie.rootmovie.Controller;

/**
 * Created by root on 11/13/16.
 */

public class MovieURL {

    final static private String BASE_URL = "https://api.themoviedb.org/3/movie/upcoming?api_key=";
    final static private String API_KEY = "50ec555cc1d67559ec5eb1bff307acce";

    public static String getUpComingMovie(){
        return BASE_URL+API_KEY;
    }
}
