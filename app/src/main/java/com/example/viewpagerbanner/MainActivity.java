package com.example.viewpagerbanner;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.viewpagerbanner.Adapter.HindiMoviesAdapter;
import com.example.viewpagerbanner.Adapter.KannadaMoviesAdapter;
import com.example.viewpagerbanner.Adapter.RecyclerviewAdapter1;
import com.example.viewpagerbanner.Adapter.TamilMoviesAdapter;
import com.example.viewpagerbanner.Adapter.TeluguMoviesAdapter;
import com.example.viewpagerbanner.Transformation.Gallery;
import com.example.viewpagerbanner.Transformation.Gallery1;
import com.example.viewpagerbanner.Transformation.ZoomOutPageTransformer;
import com.example.viewpagerbanner.networkcalls.OnClickListener;
import com.example.viewpagerbanner.networkcalls.RetrofitClient;
import com.example.viewpagerbanner.Transformation.ParallexTransformation;
import com.example.viewpagerbanner.dataModel.HindiMoviesDataModel;
import com.example.viewpagerbanner.dataModel.KannadaMoviesDataModel;
import com.example.viewpagerbanner.dataModel.NowPlaying;
import com.example.viewpagerbanner.dataModel.PopularMoviesDataModel;
import com.example.viewpagerbanner.dataModel.TamilMoviesDataModel;
import com.example.viewpagerbanner.dataModel.TeluguMoviesDataModel;
import com.example.viewpagerbanner.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
    private LinearLayoutManager linearLayoutManager,linearLayoutManager2,linearLayoutManager3,linearLayoutManager4,linearLayoutManager5;
    private static final String API_KEY = "434fcadef5103207fecca9176385a533";
    private static final String telugu = "te";
    private static final String english = "en";
    private static final String hindi = "hi";
    private static final String tamil = "ta";
    private static final String kannada = "kn";
    private static final int PAGE_NO = 1;
    private PopularMoviesDataModel data;
    private Timer timer,timers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.coordinator.setVisibility(View.INVISIBLE);
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
        linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager2 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager3 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager4 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager5 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
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
        activityMainBinding.viewpager.setPageTransformer(true, new Gallery1());

        NextActivity();
//        final Handler handlers = new Handler();
//        final Runnable runnables = new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(getApplicationContext(), Movie_Page_Activity.class);
//                startActivity(intent);
//            }
//        };
//        timers = new Timer();
//        timers.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handlers.post(runnables);
//            }
//        },5000);

        ToolBars();
        PopularMovies();
        InTheaters();
        TeluguNowPlayingMovies();
        HindiPopularMovies();
        TamilPopularMovies();
        KannadaPopularMovies();

    }

    private void NextActivity() {
        activityMainBinding.englishMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie_type = "popular";
                language = english;
                Intent intent2 = new Intent(MainActivity.this, All_Movies_List.class);
                startActivity(intent2);
            }
        });

        activityMainBinding.teleguMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie_type = "popular";
                language = telugu;
                Intent intent2 = new Intent(MainActivity.this, All_Movies_List.class);
                startActivity(intent2);
            }
        });

        activityMainBinding.hindiMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie_type = "popular";
                language = hindi;
                Intent intent2 = new Intent(MainActivity.this, All_Movies_List.class);
                startActivity(intent2);
            }
        });

        activityMainBinding.tamilMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie_type = "popular";
                language = tamil;
                Intent intent2 = new Intent(MainActivity.this, All_Movies_List.class);
                startActivity(intent2);
            }
        });

        activityMainBinding.kannadaMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie_type = "popular";
                language = kannada;
                Intent intent2 = new Intent(MainActivity.this, All_Movies_List.class);
                startActivity(intent2);
            }
        });
    }

    private void ToolBars() {
        activityMainBinding.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1: Toast.makeText(getApplicationContext(),"Search Bar",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar,menu);
        return true;
    }

    private void InTheaters() {
        RetrofitClient.getInstance()
                .getApi()
                .getNowPlayingMovies(API_KEY,PAGE_NO)
                .enqueue(new Callback<NowPlaying>() {
                    @Override
                    public void onResponse(Call<NowPlaying> call, Response<NowPlaying> response) {
                        if (response.body() != null) {
                            activityMainBinding.coordinator.setVisibility(View.VISIBLE);
                            nowplayingdata = response.body().getResults();
                            adapter1 = new RecyclerviewAdapter1(MainActivity.this, nowplayingdata, MainActivity.this);
                            activityMainBinding.recyclerview1.setAdapter(adapter1);
                        }
                    }
                    @Override
                    public void onFailure(Call<NowPlaying> call, Throwable t) {
                    }
                });
    }

    private void PopularMovies() {
        RetrofitClient.getInstance()
                .getApi()
                .getPopularMovies(API_KEY,PAGE_NO)
                .enqueue(new Callback<PopularMoviesDataModel>() {
                    @Override
                    public void onResponse(Call<PopularMoviesDataModel> call, Response<PopularMoviesDataModel> response) {
                        if (response.body() != null) {
                            data = response.body();
                            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, data);
                            activityMainBinding.viewpager.setAdapter(viewPagerAdapter);
                           // activityMainBinding.shimmer.stopShimmer();
                        }
                    }

                    @Override
                    public void onFailure(Call<PopularMoviesDataModel> call, Throwable t) {
                    }
                });
    }

    private void TeluguNowPlayingMovies() {
        RetrofitClient.getInstance()
                .getApi()
                .getTeluguNowPlayingMovies(API_KEY, telugu, PAGE_NO)
                .enqueue(new Callback<TeluguMoviesDataModel>() {
                    @Override
                    public void onResponse(Call<TeluguMoviesDataModel> call, Response<TeluguMoviesDataModel> response) {
                        if (response.body() != null) {
                            topRatedmodel = response.body().getResults();
                            topRatedMoviesAdapter = new TeluguMoviesAdapter(MainActivity.this, topRatedmodel, MainActivity.this);
                            activityMainBinding.recyclerview2.setAdapter(topRatedMoviesAdapter);
                        }else {
                            Toast.makeText(getApplicationContext(), "Not Workinng", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<TeluguMoviesDataModel> call, Throwable t) {

                    }
                });
    }

    private void HindiPopularMovies() {
        RetrofitClient.getInstance()
                .getApi()
                .getHindiPopularMovies(API_KEY, hindi, PAGE_NO)
                .enqueue(new Callback<HindiMoviesDataModel>() {
                    @Override
                    public void onResponse(Call<HindiMoviesDataModel> call, Response<HindiMoviesDataModel> response) {
                        if (response.body() != null) {
                            hindimodel = response.body().getResults();
                            hindiMoviesAdapter = new HindiMoviesAdapter(MainActivity.this, hindimodel, MainActivity.this);
                            activityMainBinding.recyclerview3.setAdapter(hindiMoviesAdapter);
                        }else {
                            Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<HindiMoviesDataModel> call, Throwable t) {

                    }
                });
    }

    private void TamilPopularMovies(){
        RetrofitClient.getInstance()
                .getApi()
                .getTamilPopularMovies(API_KEY, tamil, PAGE_NO)
                .enqueue(new Callback<TamilMoviesDataModel>() {
                    @Override
                    public void onResponse(Call<TamilMoviesDataModel> call, Response<TamilMoviesDataModel> response) {
                        if (response.body() != null) {
                            tamilmodel = response.body().getResults();
                            tamilMoviesAdapter = new TamilMoviesAdapter(MainActivity.this, tamilmodel, MainActivity.this);
                            activityMainBinding.recyclerview4.setAdapter(tamilMoviesAdapter);
                        }else {
                            Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<TamilMoviesDataModel> call, Throwable t) {

                    }
                });
    }

    private void KannadaPopularMovies(){
        RetrofitClient.getInstance()
                .getApi()
                .getKannadaPopularMovies(API_KEY, kannada, PAGE_NO)
                .enqueue(new Callback<KannadaMoviesDataModel>() {
                    @Override
                    public void onResponse(Call<KannadaMoviesDataModel> call, Response<KannadaMoviesDataModel> response) {
                        if (response.body() != null) {
                            kannadamodel = response.body().getResults();
                            kannadaMoviesAdapter = new KannadaMoviesAdapter(MainActivity.this, kannadamodel, MainActivity.this);
                            activityMainBinding.recyclerview5.setAdapter(kannadaMoviesAdapter);
                        }else {
                            Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<KannadaMoviesDataModel> call, Throwable t) {

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
    public void onTeluguMoviesClick(TeluguMoviesDataModel.ResultsBean1 telugumovies) {
        Intent intent = new Intent(MainActivity.this, Movie_Page_Activity.class);
        int id = (int) telugumovies.getId();
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


