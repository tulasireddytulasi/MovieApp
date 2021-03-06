package com.example.viewpagerbanner.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.viewpagerbanner.Movie_Page_Activity;
import com.example.viewpagerbanner.R;
import com.example.viewpagerbanner.dataModel.RecommedDataModel;

import java.util.List;

public class RecommedMoviesAdapter extends RecyclerView.Adapter<RecommedMoviesAdapter.MovieViewholder> {

    private Context context;
    private RecommedDataModel results;
    public RecommedMoviesAdapter(Context context, RecommedDataModel results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public RecommedMoviesAdapter.MovieViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommed_movies_layout, parent, false);
        return new MovieViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommedMoviesAdapter.MovieViewholder holder, final int position) {

        final RecommedDataModel results1 = results;

        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w342/"+results1.getResults().get(position).getPoster_path())
                .placeholder(R.drawable.poster1)
                .centerCrop()
                .into(holder.imageView);
        holder.name.setText(results1.getResults().get(position).getTitle());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Movie_Page_Activity.class);
                intent.putExtra("movie_ID", results1.getResults().get(position).getId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return results.getResults().size();
    }

    public class MovieViewholder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageView;
        TextView name;
        public MovieViewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
