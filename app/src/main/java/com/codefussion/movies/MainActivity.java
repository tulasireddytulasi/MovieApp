package com.codefussion.movies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.airbnb.lottie.LottieDrawable;
import com.codefussion.movies.Adapter.HindiMoviesAdapter;
import com.codefussion.movies.Adapter.KannadaMoviesAdapter;
import com.codefussion.movies.Adapter.RecyclerviewAdapter1;
import com.codefussion.movies.Adapter.TamilMoviesAdapter;
import com.codefussion.movies.Adapter.TeluguMoviesAdapter;
import com.codefussion.movies.Transformation.Gallery1;
import com.codefussion.movies.networkcalls.OnClickListener;
import com.codefussion.movies.networkcalls.RetrofitClient;
import com.codefussion.movies.dataModel.HindiMoviesDataModel;
import com.codefussion.movies.dataModel.KannadaMoviesDataModel;
import com.codefussion.movies.dataModel.NowPlaying;
import com.codefussion.movies.dataModel.PopularMoviesDataModel;
import com.codefussion.movies.dataModel.TamilMoviesDataModel;
import com.codefussion.movies.dataModel.TeluguMoviesDataModel;
import com.codefussion.movies.databinding.ActivityMainBinding;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    public static String movie_type = null;
    public static String language = null;
    private ActivityMainBinding activityMainBinding;
    private List<NowPlaying.ResultsBean1> nowplayingdata;
    private List<TeluguMoviesDataModel.ResultsBean1> topRatedmodel;
    private List<HindiMoviesDataModel.ResultsBean2> hindimodel;
    private List<TamilMoviesDataModel.ResultsBean3> tamilmodel;
    private List<KannadaMoviesDataModel.ResultsBean4> kannadamodel;
    private RecyclerviewAdapter1 adapter1;
    private TeluguMoviesAdapter topRatedMoviesAdapter;
    private HindiMoviesAdapter hindiMoviesAdapter;
    private TamilMoviesAdapter tamilMoviesAdapter;
    private KannadaMoviesAdapter kannadaMoviesAdapter;
    private static final String API_KEY = "434fcadef5103207fecca9176385a533";
    private static final String telugu = "te";
    private static final String english = "en";
    private static final String hindi = "hi";
    private static final String tamil = "ta";
    private static final String kannada = "kn";
    private static final int PAGE_NO = 1;
    private PopularMoviesDataModel data;
    private Timer timer,timers;
    private AppCompatButton button;
    private ShimmerFrameLayout shimmerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.mainPageShimmer.startShimmer();
//        final Handler handler = new Handler();
//        final Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//              activityMainBinding.coordinator.setVisibility(View.VISIBLE);
//            }
//        };
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                 handler.post(runnable);
//            }
//        },2000);

        setSupportActionBar(activityMainBinding.toolbar);
        topRatedmodel = new ArrayList<>();
        hindimodel = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        activityMainBinding.recyclerview1.setLayoutManager(linearLayoutManager);
        activityMainBinding.recyclerview1.setHasFixedSize(true);
        activityMainBinding.recyclerview2.setLayoutManager(linearLayoutManager2);
        activityMainBinding.recyclerview2.setHasFixedSize(true);
        activityMainBinding.recyclerview3.setLayoutManager(linearLayoutManager3);
        activityMainBinding.recyclerview3.setHasFixedSize(true);
        activityMainBinding.recyclerview4.setLayoutManager(linearLayoutManager4);
        activityMainBinding.recyclerview4.setHasFixedSize(true);
        activityMainBinding.recyclerview5.setLayoutManager(linearLayoutManager5);
        activityMainBinding.recyclerview5.setHasFixedSize(true);

        activityMainBinding.viewpager.setPadding(0, 0, 70, 0);
        //activityMainBinding.viewpager.setPageTransformer(true, new Gallery1());

        try {
            if(isConnected()){
               // Toasty.success(MainActivity.this, "Internet Alive", Toast.LENGTH_SHORT).show();
                ToolBars();
                getMovies("popular");
                NextActivity();
            }else {
                activityMainBinding.lottieNoInternet.setVisibility(View.VISIBLE);
                activityMainBinding.noInternetText.setVisibility(View.VISIBLE);
                activityMainBinding.lottieNoInternet.setAnimation(R.raw.no_internet_animation);
                activityMainBinding.lottieNoInternet.setRepeatCount(LottieDrawable.INFINITE);
                activityMainBinding.lottieNoInternet.setSpeed((float) 1.0);
                activityMainBinding.lottieNoInternet.playAnimation();
                activityMainBinding.mainPageShimmer.stopShimmer();
                activityMainBinding.mainPageShimmer.setVisibility(View.GONE);
                activityMainBinding.mainLinearlayout.setVisibility(View.GONE);
                Toasty.error(MainActivity.this, "Internet Dead", Toast.LENGTH_SHORT).show();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        activityMainBinding.chipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.chip1: getMovies("popular");
                    break;
                case R.id.chip2: getMovies("top_rated");
                    break;
                case R.id.chip3: getMovies("now_playing");
                    break;
                case R.id.chip4: getMovies("up_coming");
                    break;
                default: getMovies("popular");
                    break;
            }
        });

    }

    public void getMovies(String movie_type){
        PopularMovies(movie_type);
        InTheaters(movie_type);
        TeluguNowPlayingMovies(movie_type);
        HindiPopularMovies(movie_type);
        TamilPopularMovies(movie_type);
        KannadaPopularMovies(movie_type);
    }

    public boolean isConnected() throws InterruptedException, IOException {
        String command = "ping -c 1 google.com";
        return Runtime.getRuntime().exec(command).waitFor() == 0;
    }
    private void NextActivity() {
        activityMainBinding.englishMovies.setOnClickListener(v -> {
            movie_type = "popular";
            language = english;
            Intent intent2 = new Intent(MainActivity.this, All_Movies_List.class);
            startActivity(intent2);
        });

        activityMainBinding.teleguMovies.setOnClickListener(v -> {
            movie_type = "popular";
            language = telugu;
            Intent intent2 = new Intent(MainActivity.this, All_Movies_List.class);
            startActivity(intent2);
        });

        activityMainBinding.hindiMovies.setOnClickListener(v -> {
            movie_type = "popular";
            language = hindi;
            Intent intent2 = new Intent(MainActivity.this, All_Movies_List.class);
            startActivity(intent2);
        });

        activityMainBinding.tamilMovies.setOnClickListener(v -> {
            movie_type = "popular";
            language = tamil;
            Intent intent2 = new Intent(MainActivity.this, All_Movies_List.class);
            startActivity(intent2);
        });

        activityMainBinding.kannadaMovies.setOnClickListener(v -> {
            movie_type = "popular";
            language = kannada;
            Intent intent2 = new Intent(MainActivity.this, All_Movies_List.class);
            startActivity(intent2);
        });
    }

    private void ToolBars() {
        activityMainBinding.toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.item1) {
                Toast.makeText(getApplicationContext(), "Search Bar", Toast.LENGTH_SHORT).show();
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar,menu);
        return true;
    }

    private void InTheaters(String movie_type) {
        RetrofitClient.getInstance()
                .getApi()
                .getNowPlayingMovies(movie_type, API_KEY, PAGE_NO)
                .enqueue(new Callback<NowPlaying>() {
                    @Override
                    public void onResponse(@NotNull Call<NowPlaying> call, @NotNull Response<NowPlaying> response) {
                        if (response.body() != null) {
                            nowplayingdata = response.body().getResults();
                            adapter1 = new RecyclerviewAdapter1(MainActivity.this, nowplayingdata, MainActivity.this);
                            activityMainBinding.recyclerview1.setAdapter(adapter1);
                        }
                    }
                    @Override
                    public void onFailure(@NotNull Call<NowPlaying> call, @NotNull Throwable t) {
                    }
                });
    }

    private void PopularMovies(String movie_type) {
        RetrofitClient.getInstance()
                .getApi()
                .getPopularMovies(movie_type, API_KEY,PAGE_NO)
                .enqueue(new Callback<PopularMoviesDataModel>() {
                    @Override
                    public void onResponse(@NotNull Call<PopularMoviesDataModel> call, @NotNull Response<PopularMoviesDataModel> response) {

                        if (response.body() != null) {
                            activityMainBinding.mainPageShimmer.stopShimmer();
                            activityMainBinding.mainPageShimmer.setVisibility(View.GONE);
                            activityMainBinding.mainLinearlayout.setVisibility(View.VISIBLE);
                            data = response.body();
                            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, data);
                            activityMainBinding.viewpager.setAdapter(viewPagerAdapter);
                           // activityMainBinding.shimmer.stopShimmer();
                        }else {
                            activityMainBinding.mainPageShimmer.stopShimmer();
                            activityMainBinding.mainPageShimmer.setVisibility(View.GONE);
                            activityMainBinding.mainLinearlayout.setVisibility(View.VISIBLE);
                            Log.d("English Movies", "No " + movie_type + " movies..");
                           // Toasty.info(MainActivity.this, "No " + movie_type + " movies..", Toast.LENGTH_SHORT, true).show();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<PopularMoviesDataModel> call, @NotNull Throwable t) {
                    }
                });
    }

    private void TeluguNowPlayingMovies(String movie_type) {

        RetrofitClient.getInstance()
                .getApi()
                .getTeluguNowPlayingMovies(movie_type,API_KEY, telugu, PAGE_NO)
                .enqueue(new Callback<TeluguMoviesDataModel>() {
                    @Override
                    public void onResponse(@NotNull Call<TeluguMoviesDataModel> call, @NotNull Response<TeluguMoviesDataModel> response) {
                        if (response.body() != null) {
                            topRatedmodel = response.body().getResults();
                            topRatedMoviesAdapter = new TeluguMoviesAdapter(MainActivity.this, topRatedmodel, MainActivity.this);
                            activityMainBinding.recyclerview2.setAdapter(topRatedMoviesAdapter);
                        }else {
                            Log.d("Telugu Movies", "No " + movie_type + " movies..");
                           // Toasty.info(MainActivity.this, "No " + movie_type + " movies..", Toast.LENGTH_SHORT, true).show();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<TeluguMoviesDataModel> call, @NotNull Throwable t) {

                        Log.e("Telugu Movies Error:", t.toString());
                    }
                });
    }

    private void HindiPopularMovies(String movie_type) {
        RetrofitClient.getInstance()
                .getApi()
                .getHindiPopularMovies(movie_type, API_KEY, hindi, PAGE_NO)
                .enqueue(new Callback<HindiMoviesDataModel>() {
                    @Override
                    public void onResponse(@NotNull Call<HindiMoviesDataModel> call, @NotNull Response<HindiMoviesDataModel> response) {
                        if (response.body() != null) {
                            hindimodel = response.body().getResults();
                            hindiMoviesAdapter = new HindiMoviesAdapter(MainActivity.this, hindimodel, MainActivity.this);
                            activityMainBinding.recyclerview3.setAdapter(hindiMoviesAdapter);
                        }else {
                            Log.d("Hindi Movies", "No " + movie_type + " movies..");
                           // Toasty.info(getApplicationContext(), "No " + movie_type + " movies..", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(@NotNull Call<HindiMoviesDataModel> call, @NotNull Throwable t) {

                    }
                });
    }

    private void TamilPopularMovies(String movie_type){
        RetrofitClient.getInstance()
                .getApi()
                .getTamilPopularMovies(movie_type, API_KEY, tamil, PAGE_NO)
                .enqueue(new Callback<TamilMoviesDataModel>() {
                    @Override
                    public void onResponse(@NotNull Call<TamilMoviesDataModel> call, @NotNull Response<TamilMoviesDataModel> response) {
                        if (response.body() != null) {
                            tamilmodel = response.body().getResults();
                            tamilMoviesAdapter = new TamilMoviesAdapter(MainActivity.this, tamilmodel, MainActivity.this);
                            activityMainBinding.recyclerview4.setAdapter(tamilMoviesAdapter);
                        }else {
                            Log.d("Tamil Movies", "No " + movie_type + " movies..");
                          //  Toasty.info(getApplicationContext(), "No " + movie_type + " movies..", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(@NotNull Call<TamilMoviesDataModel> call, @NotNull Throwable t) {

                    }
                });
    }

    private void KannadaPopularMovies(String movie_type){
        RetrofitClient.getInstance()
                .getApi()
                .getKannadaPopularMovies(movie_type, API_KEY, kannada, PAGE_NO)
                .enqueue(new Callback<KannadaMoviesDataModel>() {
                    @Override
                    public void onResponse(@NotNull Call<KannadaMoviesDataModel> call, @NotNull Response<KannadaMoviesDataModel> response) {
                        if (response.body() != null) {
                            Log.d("Kannada Movies",movie_type + " movies.." + response.code());
                            kannadamodel = response.body().getResults();
                            kannadaMoviesAdapter = new KannadaMoviesAdapter(MainActivity.this, kannadamodel, MainActivity.this);
                            activityMainBinding.recyclerview5.setAdapter(kannadaMoviesAdapter);
                            activityMainBinding.noData5.setVisibility(View.GONE);
                        }else {
                            Log.d("Kannada Movies", "No " + movie_type + " movies..");
                            activityMainBinding.noData5.setVisibility(View.GONE);
                          //  Toasty.info(getApplicationContext(), "No " + movie_type + " movies..", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(@NotNull Call<KannadaMoviesDataModel> call, @NotNull Throwable t) {

                    }
                });
    }

    @Override
    public void onClick(NowPlaying.ResultsBean1 nowPlaying) {
        Intent intent = new Intent(MainActivity.this, Movie_Page_Activity.class);
        int id = (int) nowPlaying.getId();
        if (id != 0){
            intent.putExtra("movie_ID", id);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "No Data of this Movie", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onTeluguMoviesClick(TeluguMoviesDataModel.ResultsBean1 teluguMovies) {
        Intent intent = new Intent(MainActivity.this, Movie_Page_Activity.class);
        int id = (int) teluguMovies.getId();
        Toast.makeText(MainActivity.this, String.valueOf(id), Toast.LENGTH_SHORT).show();
        if (id != 0){
            intent.putExtra("movie_ID", id);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "No Data of this Movie", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHindiMovieClick(HindiMoviesDataModel.ResultsBean2 hindimovies) {
        Intent intent = new Intent(MainActivity.this, Movie_Page_Activity.class);
        int id = (int) hindimovies.getId();
        if (id != 0){
            intent.putExtra("movie_ID", id);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "No Data of this Movie", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onTamilMovieClick(TamilMoviesDataModel.ResultsBean3 tamilmovies) {
        Intent intent = new Intent(MainActivity.this, Movie_Page_Activity.class);
        int id = (int) tamilmovies.getId();
        Toast.makeText(MainActivity.this, String.valueOf(id), Toast.LENGTH_SHORT).show();
        if (id != 0){
            intent.putExtra("movie_ID", id);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "No Data of this Movie", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onKannadaMovieClick(KannadaMoviesDataModel.ResultsBean4 kannadamovies) {
        Intent intent = new Intent(MainActivity.this, Movie_Page_Activity.class);
        int id = (int) kannadamovies.getId();
        if (id != 0){
            intent.putExtra("movie_ID", id);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "No Data of this Movie", Toast.LENGTH_SHORT).show();
        }
    }

}


