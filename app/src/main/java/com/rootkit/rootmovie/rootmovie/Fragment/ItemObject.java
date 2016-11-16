package com.rootkit.rootmovie.rootmovie.Fragment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 11/13/16.
 */

public class ItemObject {

    public class UpComingMovie{
        @SerializedName("results")
        List<upcoming> upcoming;

        public class upcoming {

            @SerializedName("poster_path")
            private String poster_path;

            public String getPoster_path(){
                return poster_path;
            }


            @SerializedName("title")
            private String title;

            public String getTitle(){
                return title;
            }

        }

    }
}
