package com.example.viewpagerbanner.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.viewpagerbanner.R;
import com.example.viewpagerbanner.dataModel.MoviePage1;

public class CreditsAdater extends RecyclerView.Adapter<CreditsAdater.CreditViewHolder> {

    private Context context;
    private MoviePage1 moviePage1;
    public CreditsAdater(Context context, MoviePage1 moviePage1) {
        this.context = context;
        this.moviePage1 = moviePage1;
    }

    @NonNull
    @Override
    public CreditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        CreditsLayoutBinding creditsLayoutBinding = DataBindingUtil.inflate(
//                LayoutInflater.from(parent.getContext()),R.layout.credits_layout, parent, false);
//        CreditViewHolder creditViewHolder = new CreditViewHolder(creditsLayoutBinding);
//        return creditViewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.credit_layout, parent, false);
        return new CreditViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditViewHolder holder, int position) {
        MoviePage1 moviePage = moviePage1;

        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w342/"+moviePage.getCredits().getCrew().get(position).getProfile_path())
                .placeholder(R.drawable.poster1)
                .centerCrop()
                .into(holder.imageView);

        holder.name.setText(moviePage.getCredits().getCrew().get(position).getName());
        holder.department.setText(moviePage.getCredits().getCrew().get(position).getKnown_for_department());

    }



    @Override
    public int getItemCount() {
        return moviePage1.getCredits().getCrew().size();
    }



    public class CreditViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name, department ;
        public CreditViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            department = itemView.findViewById(R.id.department);
        }
    }
}
