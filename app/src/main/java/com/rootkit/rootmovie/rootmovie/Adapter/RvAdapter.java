package com.rootkit.rootmovie.rootmovie.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rootkit.rootmovie.rootmovie.ItemObject;
import com.rootkit.rootmovie.rootmovie.R;

import java.util.List;

/**
 * Created by root on 11/13/16.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.LisHolder>  {

    Context context;
    List<ItemObject.UpComingMovie.upcoming> upComingMovies;

    public RvAdapter(Context context, List<ItemObject.UpComingMovie.upcoming> upComingMovies) {
        this.context = context;
        this.upComingMovies = upComingMovies;
    }

    @Override
    public LisHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_movie, null);
        LisHolder lisHolder = new LisHolder(view);
        return lisHolder;
    }

    @Override
    public void onBindViewHolder(LisHolder holder, int position) {

        holder.txtJudulUpComingMovie.setText(upComingMovies.get(position).getTitle());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w185"+
                        upComingMovies.get(position).getPoster_path())
                .centerCrop()
                .placeholder(R.drawable.notfound)
                .crossFade()
                .into(holder.imageUpComingMovie);

    }

    @Override
    public int getItemCount() {
        return upComingMovies.size();
    }

    class LisHolder extends RecyclerView.ViewHolder{

        ImageView imageUpComingMovie;
        TextView txtJudulUpComingMovie;


        public LisHolder(View itemView) {
            super(itemView);
            imageUpComingMovie = (ImageView) itemView.findViewById(R.id.img_cardview_movie);
            txtJudulUpComingMovie = (TextView) itemView.findViewById(R.id.txt_judul_movie_cardview);

        }
    }

}
