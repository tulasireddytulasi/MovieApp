package com.example.viewpagerbanner;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.viewpagerbanner.dataModel.PopularMoviesDataModel;

public class ViewPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private PopularMoviesDataModel data;
    Context context;


    ViewPagerAdapter(Context context, PopularMoviesDataModel data){
        this.context = context;
        this.data = data;
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
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Movie_Page_Activity.class);
                int id = (int) data.getResults().get(position).getId();
                intent.putExtra("movie_ID", id);
                context.startActivity(intent);
            }
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

