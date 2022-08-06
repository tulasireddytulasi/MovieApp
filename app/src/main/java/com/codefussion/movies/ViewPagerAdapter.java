package com.codefussion.movies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.codefussion.movies.dataModel.PopularMoviesDataModel;
import com.codefussion.movies.networkcalls.OnClickListener;

public class ViewPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private PopularMoviesDataModel data;
    Context context;
    private OnClickListener onClickListener;


    ViewPagerAdapter(Context context, PopularMoviesDataModel data, OnClickListener onClickListener){
        this.context = context;
        this.data = data;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getCount() {
        return data.getResults().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);
        ImageView imageView = view.findViewById(R.id.image);

        TextView titlename = view.findViewById(R.id.title);

        Glide.with(context).load("http://image.tmdb.org/t/p/w780"+data.getResults().get(position).getBackdrop_path())
                .apply(new RequestOptions().centerCrop())
                .into(imageView);
        imageView.setOnClickListener(v -> {
            int id = (int) data.getResults().get(position).getId();
            String movie_title_value = data.getResults().get(position).getTitle();
            String overview_value = data.getResults().get(position).getOverview();
            String movie_poster_value = data.getResults().get(position).getPoster_path();
            String date_value = data.getResults().get(position).getRelease_date();
            onClickListener.onClickViewPager(id, movie_poster_value, movie_title_value, overview_value, date_value);
        });
        titlename.setText(data.getResults().get(position).getTitle());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

