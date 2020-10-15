package com.example.viewpagerbanner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.example.viewpagerbanner.dataModel.MoviePage1;
import com.example.viewpagerbanner.dataModel.MoviePageDataModel;
import com.example.viewpagerbanner.databinding.ActivityMoviePageBinding;
import com.example.viewpagerbanner.networkcalls.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Movie_Page_Activity extends AppCompatActivity {

    private ActivityMoviePageBinding activityMoviePageBinding;
    private int movie_id;
    private TextView runtime;
    private static final String API_KEY = "434fcadef5103207fecca9176385a533";
    private MoviePage1 moviePage1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMoviePageBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie__page);
        runtime = findViewById(R.id.runtime);
        Intent mIntent = getIntent();
        movie_id = mIntent.getIntExtra("movie_ID",0);
        movieDetails();
    }

    private void movieDetails() {
        RetrofitClient.getInstance()
                .getApi()
                .getMovieDetails(movie_id, API_KEY)
                .enqueue(new Callback<MoviePage1>() {
                    @Override
                    public void onResponse(Call<MoviePage1> call, Response<MoviePage1> response) {
                        if (response.body() != null){
                            moviePage1 = response.body();
                            Glide.with(getApplicationContext())
                             .load("http://image.tmdb.org/t/p/w780"+moviePage1.getBackdrop_path())
                                    .placeholder(R.drawable.poster)
                             .into(activityMoviePageBinding.backdrop);
                            Glide.with(getApplicationContext())
                             .load("http://image.tmdb.org/t/p/w342"+moviePage1.getPoster_path())
                                    .placeholder(R.drawable.poster)
                                    .centerCrop()
                                    .into(activityMoviePageBinding.posterImg);
                            activityMoviePageBinding.movietitle.setText(moviePage1.getTitle());
                            int t = moviePage1.getRuntime();
                            int hours = t / 60;
                            int minutes = t % 60;
                            activityMoviePageBinding.runtime.setText(hours+"h "+minutes+"min");
                            activityMoviePageBinding.movieRating.setText(String.valueOf(moviePage1.getVote_average()));
                            activityMoviePageBinding.releaseDate.setText("Release Date: "+moviePage1.getRelease_date());
                            Integer revenue = Math.round(moviePage1.getRevenue())/1000000;
                            activityMoviePageBinding.movieRevenue.setText("Revenue: "+revenue);
                            Integer budget = Math.round(moviePage1.getBudget())/1000000;
                            activityMoviePageBinding.movieBudget.setText("Budget: "+budget);
                            activityMoviePageBinding.overview.setText(moviePage1.getOverview());
                        }else{
                            Toast.makeText(getApplicationContext(),"No Data", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<MoviePage1> call, Throwable t) {
                        Log.e("MOVIE_PAGE", "onFailure: "+t);
                    }
                });
    }

}