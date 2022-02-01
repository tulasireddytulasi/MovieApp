package com.codefussion.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codefussion.movies.Adapter.CastAdapter;
import com.codefussion.movies.Adapter.RecommedMoviesAdapter;
import com.codefussion.movies.dataModel.MoviePage1;
import com.codefussion.movies.dataModel.RecommedDataModel;
import com.codefussion.movies.networkcalls.RetrofitClient;


import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Movie_Page_Activity extends AppCompatActivity {

    private int movie_id;
    private TextView runtime, title, overview, movierating, genere;
    private static final String API_KEY = "434fcadef5103207fecca9176385a533";
    private MoviePage1 moviePage1;
    private RecommedDataModel recommed;
    private CastAdapter castAdapter;
    private RecommedMoviesAdapter recommedMoviesAdapter;
    private Context context;
    private String genre;
    private LinearLayoutManager linearLayoutManager1, linearLayoutManager2;
    private RecyclerView recyclerViewcast, recyclerView_recommed;
    private Button download, watchlist, share;
    private ImageView backdrop, poster;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__page);
        relativeLayout = findViewById(R.id.recommeded_rl);
        backdrop = findViewById(R.id.backdrop);
        poster = findViewById(R.id.posterImg);
        runtime = findViewById(R.id.runtime);
        title = findViewById(R.id.movietitle);
        overview = findViewById(R.id.overview);
        movierating = findViewById(R.id.movie_rating);
        genere = findViewById(R.id.movie_genres);
        context = getApplicationContext();
        recyclerViewcast = findViewById(R.id.recyclerview_cast);
        recyclerView_recommed = findViewById(R.id.recyclerview_recommed);
        download = findViewById(R.id.download);
        watchlist = findViewById(R.id.watch_list);
        share = findViewById(R.id.share);
        genre = "";
        // linearLayoutManager = new LinearLayoutManager(Movie_Page_Activity.this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager1 = new LinearLayoutManager(Movie_Page_Activity.this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager2 = new LinearLayoutManager(Movie_Page_Activity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewcast.setLayoutManager(linearLayoutManager1);
        recyclerViewcast.setHasFixedSize(true);
        recyclerView_recommed.setLayoutManager(linearLayoutManager2);
        recyclerView_recommed.setHasFixedSize(true);

        Intent mIntent = getIntent();
        movie_id = mIntent.getIntExtra("movie_ID", 0);
        if (movie_id != 0) {
            movieDetails();
            RecommedMovies();
        }

        buttons();
    }

    private void buttons() {
        download.setOnClickListener(v -> Toasty.info(context, "This Feature is not available right now...", Toast.LENGTH_SHORT, true).show());

        watchlist.setOnClickListener(v -> Toasty.info(context, "This Feature is not available right now...", Toast.LENGTH_SHORT, true).show());

        share.setOnClickListener(v -> Toasty.info(context, "This Feature is not available right now...", Toast.LENGTH_SHORT, true).show());
    }

    private void movieDetails() {

        RetrofitClient.getInstance()
                .getApi()
                .getMovieDetails(movie_id, API_KEY, "credits")
                .enqueue(new Callback<MoviePage1>() {
                    @Override
                    public void onResponse(@NonNull Call<MoviePage1> call, @NonNull Response<MoviePage1> response) {
                        if (response.body() != null) {
                            try {
                                moviePage1 = response.body();
                                Log.d("direct", moviePage1.getCredits().getCast().get(0).getName());
                                Glide.with(getApplicationContext())
                                        .load("http://image.tmdb.org/t/p/w780" + moviePage1.getBackdrop_path())
                                        .placeholder(R.drawable.movie_thumbnail)
                                        .into(backdrop);
                                Glide.with(getApplicationContext())
                                        .load("http://image.tmdb.org/t/p/w342" + moviePage1.getPoster_path())
                                        .placeholder(R.drawable.movie_thumbnail)
                                        .centerCrop()
                                        .into(poster);
                                title.setText(moviePage1.getTitle());
                                int t = moviePage1.getRuntime();
                                int hours = t / 60;
                                int minutes = t % 60;
                                runtime.setText(hours + "h " + minutes + "min");
                                movierating.setText(String.valueOf(moviePage1.getVote_average()));
//                            activityMoviePageBinding.releaseDate.setText("Release Date: "+moviePage1.getRelease_date());
//                            Integer revenue = Math.round(moviePage1.getRevenue())/1000000;
//                            activityMoviePageBinding.movieRevenue.setText("Revenue: "+revenue);
//                            Integer budget = Math.round(moviePage1.getBudget())/1000000;
//                            activityMoviePageBinding.movieBudget.setText("Budget: "+budget);
                                overview.setText(moviePage1.getOverview());

//                            String dd = moviePage1.getGenres().get(0).getName();
                                // Toast.makeText(context, movie_id, Toast.LENGTH_LONG).show();

                                try {
                                    int size = moviePage1.getGenres().size();
                                    Log.d("recommed", String.valueOf(size));
                                    if (moviePage1.getGenres().size() != 0) {
                                        for (int i = 0; i < moviePage1.getGenres().size(); i++) {
                                            genre = genre.concat(moviePage1.getGenres().get(i).getName() + " | ");
                                            Log.d("genre", moviePage1.getGenres().get(i).getName());
                                            Log.d("genere5", genre);
                                            genere.setText(genre);
                                            if (i == moviePage1.getGenres().size() - 1) {
                                                genre = genre.substring(0, genre.length() - 2);
                                                genere.setText(genre);
                                            }
                                        }
                                    } else {
                                        genere.setText(R.string.drama);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                castAdapter = new CastAdapter(context, moviePage1);
                                recyclerViewcast.setAdapter(castAdapter);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<MoviePage1> call, @NonNull Throwable t) {
                        Log.e("MOVIE_PAGE", "onFailure: " + t);
                    }
                });


    }

    private void RecommedMovies() {

        RetrofitClient.getInstance()
                .getApi()
                .getRecommedMovies(movie_id, API_KEY)
                .enqueue(new Callback<RecommedDataModel>() {
                    @Override
                    public void onResponse(@NonNull Call<RecommedDataModel> call, @NonNull Response<RecommedDataModel> response) {
                        assert response.body() != null;
                        if (response.body().getResults().size() != 0) {
                            // Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                            relativeLayout.setVisibility(View.VISIBLE);
                            Log.d("recommed 5666", response.body().getResults().toString());
                            recommed = response.body();
                            recommedMoviesAdapter = new RecommedMoviesAdapter(context, recommed);
                            recyclerView_recommed.setAdapter(recommedMoviesAdapter);
                        } else {
                            Log.d("recommed 5", response.body().getResults().toString());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<RecommedDataModel> call, @NonNull Throwable t) {
                        Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


}