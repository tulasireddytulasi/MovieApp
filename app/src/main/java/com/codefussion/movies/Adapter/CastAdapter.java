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
import com.codefussion.movies.PopularActorsActivity;
import com.codefussion.movies.R;
import com.codefussion.movies.dataModel.MoviePage1;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    private final Context context;
    private final MoviePage1 moviePage1;
    public CastAdapter(Context context, MoviePage1 moviePage1) {
        this.context = context;
        this.moviePage1 = moviePage1;
    }

    @NonNull
    @Override
    public CastAdapter.CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_layout, parent, false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastAdapter.CastViewHolder holder, int position) {

        MoviePage1 moviePage = moviePage1;
        String poster = moviePage.getCredits().getCast().get(position).getProfile_path();
        Log.d("ACTORS_MOVIES6", String.valueOf(moviePage.getCredits().getCast().get(position).getId()));
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

        holder.name.setText(String.valueOf(moviePage.getCredits().getCast().get(position).getCharacter()));
        holder.department.setText(moviePage.getCredits().getCast().get(position).getOriginal_name());

        holder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, PopularActorsActivity.class);
            intent.putExtra("actor_ID", moviePage.getCredits().getCast().get(position).getId());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return moviePage1.getCredits().getCast().size();
    }

    public static class CastViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name, department ;
        CardView cardView;
        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            department = itemView.findViewById(R.id.department);
            cardView = itemView.findViewById(R.id.cast_card);
        }
    }
}
