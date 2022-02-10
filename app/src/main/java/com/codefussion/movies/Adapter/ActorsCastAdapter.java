package com.codefussion.movies.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codefussion.movies.Movie_Page_Activity;
import com.codefussion.movies.PopularActorsActivity;
import com.codefussion.movies.R;
import com.codefussion.movies.dataModel.ActorsMoviesDataModel;

import java.util.LinkedList;
import java.util.List;

public class ActorsCastAdapter extends RecyclerView.Adapter<ActorsCastAdapter.ActorsCastViewHolder> {

    private final Context context;
    private final ActorsMoviesDataModel actorsMoviesDataModel;
    List<ActorsMoviesDataModel.Cast> cast = new LinkedList<>();

    public ActorsCastAdapter(Context context, ActorsMoviesDataModel actorsMoviesDataModel) {
        this.context = context;
        this.actorsMoviesDataModel = actorsMoviesDataModel;
    }

    @NonNull
    @Override
    public ActorsCastAdapter.ActorsCastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout, parent, false);
        return new ActorsCastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorsCastAdapter.ActorsCastViewHolder holder, int position) {
        Log.d("ACTORS_MOVIES2", "Inside adapter");
        cast = actorsMoviesDataModel.getCast();
        String poster = cast.get(position).getPoster_path();
        String name = cast.get(position).getTitle();

        holder.movieName.setText(name);
        if(poster != null && !poster.isEmpty()){
            Glide.with(context)
                    .load("http://image.tmdb.org/t/p/w342/"+poster)
                    .placeholder(R.drawable.movie_thumbnail)
                    .centerCrop()
                    .into(holder.imageView);
        } else {
            Glide.with(context)
                    .load(R.drawable.movie_thumbnail)
                    .placeholder(R.drawable.movie_thumbnail)
                    .centerCrop()
                    .into(holder.imageView);
        }
        holder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, Movie_Page_Activity.class);
            intent.putExtra("movie_ID", cast.get(position).getId());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return actorsMoviesDataModel.getCast().size();
    }

    public static class ActorsCastViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView movieName;
        CardView cardView;
        public ActorsCastViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.movie_img);
            movieName = itemView.findViewById(R.id.movie_name);
            cardView = itemView.findViewById(R.id.movie_card);
        }
    }
}
