package com.codefussion.movies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codefussion.movies.R;
import com.codefussion.movies.dataModel.MoviePage1;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    private Context context;
    private MoviePage1 moviePage1;
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

        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w342/"+moviePage.getCredits().getCast().get(position).getProfile_path())
                .placeholder(R.drawable.movie_thumbnail)
                .centerCrop()
                .into(holder.imageView);

        holder.name.setText(moviePage.getCredits().getCast().get(position).getCharacter());
        holder.department.setText(moviePage.getCredits().getCast().get(position).getOriginal_name());
    }

    @Override
    public int getItemCount() {
        return moviePage1.getCredits().getCast().size();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name, department ;
        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            department = itemView.findViewById(R.id.department);
        }
    }
}
