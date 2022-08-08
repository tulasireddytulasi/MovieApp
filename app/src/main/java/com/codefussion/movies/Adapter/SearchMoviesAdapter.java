package com.codefussion.movies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codefussion.movies.R;
import com.codefussion.movies.dataModel.PopularMoviesDataModel;
import com.codefussion.movies.dataModel.TeluguMoviesDataModel;
import com.codefussion.movies.networkcalls.OnClickListener2;

import java.util.List;

public class SearchMoviesAdapter extends RecyclerView.Adapter<SearchMoviesAdapter.SearchMoviesViewHolder>{

    private Context context;
    private final List<PopularMoviesDataModel.ResultsBean> resultsBean1s;
    private final OnClickListener2 onClickListener;

    public SearchMoviesAdapter(Context context, List<PopularMoviesDataModel.ResultsBean> resultsBean1s, OnClickListener2 onClickListener){
        this.context =context;
        this.resultsBean1s = resultsBean1s;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public SearchMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_movies_layout, viewGroup, false);
        return new SearchMoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchMoviesViewHolder viewHolder, int i) {

        PopularMoviesDataModel.ResultsBean results = resultsBean1s.get(i);
        int movieId = (int) results.getId();
        String poster = results.getPoster_path();
        String name = results.getTitle();
        String overView = results.getOverview();
        String releaseDate = results.getRelease_date();
        viewHolder.movieName.setText(name);
        viewHolder.movieReleaseDate.setText(releaseDate);
        viewHolder.relativeLayout.setOnClickListener(view -> {
            onClickListener.onClick(movieId, poster, name, overView, releaseDate);
        });
        if(poster != null && !poster.isEmpty()){
            Glide.with(context)
                    .load("http://image.tmdb.org/t/p/w342/"+poster)
                    .placeholder(R.drawable.movie_thumbnail)
                    .centerCrop()
                    .into(viewHolder.imageView);
        } else {
            Glide.with(context)
                    .load(R.drawable.movie_thumbnail)
                    .placeholder(R.drawable.movie_thumbnail)
                    .centerCrop()
                    .into(viewHolder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return resultsBean1s.size();
    }

    public static class SearchMoviesViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView movieName;
        TextView movieReleaseDate;
        CardView cardView;

        public SearchMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.search_movie_linearlayout);
            imageView = itemView.findViewById(R.id.search_movie_img);
            movieName = itemView.findViewById(R.id.search_movie_title);
            cardView = itemView.findViewById(R.id.search_movie_card);
            movieReleaseDate = itemView.findViewById(R.id.search_movie_release_date);
        }

    }
}
