package com.codefussion.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codefussion.movies.Adapter.SearchMoviesAdapter;
import com.codefussion.movies.dataModel.PopularMoviesDataModel;
import com.codefussion.movies.networkcalls.OnClickListener2;
import com.codefussion.movies.networkcalls.RetrofitClient;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesSearch extends AppCompatActivity implements OnClickListener2 {

    private List<PopularMoviesDataModel.ResultsBean> searchMoviesModel;
    private SearchMoviesAdapter searchMoviesAdapter;
    private RecyclerView recyclerView;
    private EditText searchView;
    private static final String API_KEY = "434fcadef5103207fecca9176385a533";
    private BottomSheetDialog bottomSheetDialog;
    private TextView movie_title;
    private TextView movie_release_date;
    private TextView overview;
    private ImageView movie_poster;
    private RelativeLayout infoCard;
    private RelativeLayout movieInfo;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_search);
        searchView = findViewById(R.id.search_view);
        // Set soft input mode
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        showKeyBoard(searchView);
        bottomSheetDialog = new BottomSheetDialog(this, R.style.BottomSheetStyle);
        setBottomSheetContent();
        recyclerView = findViewById(R.id.search_movies_recyclerview);
        searchView.setFocusable(true);
        searchMoviesModel = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MoviesSearch.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        String movieType = "popular";
        PopularMovies(movieType);
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("Search Movie", String.valueOf(editable));
                TeluguNowPlayingMovies(String.valueOf(editable));
            }
        });

        /// Keyboard closes when clicking on search button in keyboard
        searchView.setOnEditorActionListener((textView, i, keyEvent) -> {
            if(i == EditorInfo.IME_ACTION_SEARCH){
                hideKeyBoard(searchView);
                return  true;
            }
            return false;
        });

        /// Keyboard closes when scrolling
        recyclerView.setOnTouchListener((view, motionEvent) -> {
            hideKeyBoard(searchView);
            return false;
        });

        bottomSheetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private void showKeyBoard(EditText editText){
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.showSoftInput(editText.getRootView(), InputMethodManager.SHOW_IMPLICIT);
        editText.requestFocus();
    }

    private void hideKeyBoard(EditText editText){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        editText.clearFocus();
    }

    private void setBottomSheetContent() {
        View view = getLayoutInflater().inflate(R.layout.movie_bottom_sheet, null, false);
        bottomSheetDialog.setContentView(view);
        CircleImageView closeDialog = view.findViewById(R.id.close_dialog);
        movie_title = view.findViewById(R.id.movie_title);
        movie_release_date = view.findViewById(R.id.movie_year);
        overview = view.findViewById(R.id.movie_overview);
        movie_poster = view.findViewById(R.id.movie_poster);
        infoCard = view.findViewById(R.id.info_card);
        movieInfo = view.findViewById(R.id.movie_info);
        closeDialog.setOnClickListener(view1 -> bottomSheetDialog.dismiss());
    }

    private void PopularMovies(String movie_type) {
        RetrofitClient.getInstance()
                .getApi()
                .getPopularMovies(movie_type, API_KEY, 1)
                .enqueue(new Callback<PopularMoviesDataModel>() {
                    @Override
                    public void onResponse(@NotNull Call<PopularMoviesDataModel> call, @NotNull Response<PopularMoviesDataModel> response) {

                        if (response.body() != null) {
                            searchMoviesModel = response.body().getResults();
                            searchMoviesAdapter = new SearchMoviesAdapter(MoviesSearch.this, searchMoviesModel, MoviesSearch.this);
                            recyclerView.setAdapter(searchMoviesAdapter);
                        } else {
                            Log.d("Search Movies", "No " + movie_type + " movies..");
                            // Toasty.info(MainActivity.this, "No " + movie_type + " movies..", Toast.LENGTH_SHORT, true).show();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<PopularMoviesDataModel> call, @NotNull Throwable t) {
                        Log.e("Search Movies Error:", t.toString());
                    }
                });
    }

    private void TeluguNowPlayingMovies(String queryText) {
        RetrofitClient.getInstance()
                .getApi()
                .getSearchMovies(API_KEY, queryText, 1)
                .enqueue(new Callback<PopularMoviesDataModel>() {
                    @Override
                    public void onResponse(@NotNull Call<PopularMoviesDataModel> call, @NotNull Response<PopularMoviesDataModel> response) {
                        if (response.body() != null) {
                            searchMoviesModel = response.body().getResults();
                            searchMoviesAdapter = new SearchMoviesAdapter(MoviesSearch.this, searchMoviesModel, MoviesSearch.this);
                            recyclerView.setAdapter(searchMoviesAdapter);
                        } else {
                            Log.d("Search Movies", "No " + queryText + " movies..");
                            // Toasty.info(MainActivity.this, "No " + movie_type + " movies..", Toast.LENGTH_SHORT, true).show();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<PopularMoviesDataModel> call, @NotNull Throwable t) {
                        Log.e("Search Movies Error:", t.toString());
                    }
                });
    }

    @Override
    public void onClick(int movieId, String movie_poster_value, String movie_title_value, String overview_value, String date_value) {
        openDialog(movieId, movie_poster_value, movie_title_value, overview_value, date_value);
    }

    void openDialog(int movie_id, String movie_poster_value, String movie_title_value, String overview_value, String date_value) {
        Intent intent = new Intent(MoviesSearch.this, Movie_Page_Activity.class);
        movie_title.setText(movie_title_value);
        overview.setText(overview_value);
        movie_release_date.setText(date_value);
        if(movie_poster_value != null && movie_poster_value.length() != 0){
            Glide.with(getApplicationContext())
                    .load( "http://image.tmdb.org/t/p/w342" + movie_poster_value)
                    .placeholder(R.drawable.movie_thumbnail)
                    .centerCrop()
                    .into(movie_poster);
        }else{
            Glide.with(getApplicationContext())
                    .load(R.drawable.movie_thumbnail)
                    .placeholder(R.drawable.movie_thumbnail)
                    .centerCrop()
                    .into(movie_poster);
        }

        if (movie_id != 0) {
            if (bottomSheetDialog.isShowing()) {
                bottomSheetDialog.dismiss();
            }
            bottomSheetDialog.show();
            movieInfo.setOnClickListener(view -> {
                bottomSheetDialog.dismiss();
                intent.putExtra("movie_ID", movie_id);
                startActivity(intent);
            });

            infoCard.setOnClickListener(view -> {
                bottomSheetDialog.dismiss();
                intent.putExtra("movie_ID", movie_id);
                startActivity(intent);
            });
        } else {
            Toast.makeText(MoviesSearch.this, "No Data of this Movie", Toast.LENGTH_SHORT).show();
        }
    }

}