package com.codefussion.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codefussion.movies.Adapter.ActorsCastAdapter;
import com.codefussion.movies.dataModel.ActorsDataModel;
import com.codefussion.movies.dataModel.ActorsMoviesDataModel;
import com.codefussion.movies.dataModel.RecommedDataModel;
import com.codefussion.movies.networkcalls.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularActorsActivity extends AppCompatActivity {

    private int actorId;
    private static final String API_KEY = "434fcadef5103207fecca9176385a533";
    private ActorsDataModel actorsDataModel;
    private ActorsMoviesDataModel actorsMoviesDataModel;
    private ActorsCastAdapter actorsCastAdapter;

    TextView actorPhoto, actorName, biography, knownFor, gender, birthday, birthPlace;
    ImageView imageView;
    RecyclerView actors_cast_recyclerview;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_actors);
        actors_cast_recyclerview = findViewById(R.id.actors_cast_recyclerview);
        actorName = findViewById(R.id.actor_name);
        knownFor = findViewById(R.id.known_for);
        gender = findViewById(R.id.gender);
        birthday = findViewById(R.id.birthday);
        birthPlace = findViewById(R.id.birth_place);
        biography = findViewById(R.id.biography);
        imageView = findViewById(R.id.actor_photo);
        linearLayoutManager = new LinearLayoutManager(PopularActorsActivity.this, LinearLayoutManager.HORIZONTAL, false);
        actors_cast_recyclerview.setLayoutManager(linearLayoutManager);
        actors_cast_recyclerview.setHasFixedSize(true);
        Intent mIntent = getIntent();
        actorId = mIntent.getIntExtra("actor_ID", 0);
        if (actorId != 0) {
            actorsDetails();
            actorsMovies();
        }


    }

    private void actorsDetails(){
        RetrofitClient.getInstance()
                .getApi()
                .getActorsDetails(actorId,API_KEY)
                .enqueue(new Callback<ActorsDataModel>() {
                    @Override
                    public void onResponse(@NonNull Call<ActorsDataModel> call, @NonNull Response<ActorsDataModel> response) {
                        actorsDataModel = response.body();
                        Log.d("Act5566", actorsDataModel.toString());
                        System.out.println(actorsDataModel.toString());
                        assert actorsDataModel != null;

                        String name, genderdata, dob, biographyData, knownForDepartment, placeOfBirth;
                        knownForDepartment = actorsDataModel.getKnown_for_department();
                        placeOfBirth = actorsDataModel.getPlace_of_birth();
                        dob = actorsDataModel.getBirthday();
                        actorName.setText(actorsDataModel.getName());

                        if(actorsDataModel.getProfile_path() != null){
                            Glide.with(getApplicationContext())
                                    .load("http://image.tmdb.org/t/p/w342" + actorsDataModel.getProfile_path())
                                    .placeholder(R.drawable.movie_thumbnail)
                                    .centerCrop()
                                    .into(imageView);
                        }else{
                            Glide.with(getApplicationContext())
                                    .load(R.drawable.movie_thumbnail)
                                    .placeholder(R.drawable.movie_thumbnail)
                                    .centerCrop()
                                    .into(imageView);
                        }
                        if(knownForDepartment != null) {
                            knownFor.setText(actorsDataModel.getKnown_for_department());
                            Log.d("Act55", actorsDataModel.getKnown_for_department());
                        }else {
                            knownFor.setText(R.string.no_data);
                        }
                        if(placeOfBirth != null){
                            birthPlace.setText(actorsDataModel.getPlace_of_birth());
                            Log.d("Act56", actorsDataModel.getPlace_of_birth());
                        }else {
                            birthPlace.setText(R.string.no_data);
                        }
                        if(dob != null){
                            birthday.setText(actorsDataModel.getBirthday());
                            Log.d("Act5678", actorsDataModel.getBirthday());
                            Log.d("Act56", String.valueOf(actorsDataModel.getId()));
                        }else {
                            birthday.setText(R.string.no_data);
                        }

                        int genderId = actorsDataModel.getGender();
                        if(genderId == 1){
                            gender.setText(R.string.female);
                        }else if(genderId == 2){
                            gender.setText(R.string.male);
                        }else {
                            gender.setText(R.string.no_data);
                        }
                        Log.d("Act56783", actorsDataModel.getBiography());
                        if(actorsDataModel.getBiography() != null && !actorsDataModel.getBiography().isEmpty()){
                            biography.setText(actorsDataModel.getBiography());
                        }else{
                            Log.d("Act56783", "No Data44");
                            biography.setText(R.string.no_data);
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<ActorsDataModel> call, @NonNull Throwable t) {
                        Log.e("ACTORS_PAGE", "onFailure: " + t);
                    }
                });
    }

    private void actorsMovies(){
        Log.d("ACTORS_MOVIES", "Inside function");
        RetrofitClient.getInstance()
                .getApi()
                .getActorsMovies(actorId,API_KEY)
                .enqueue(new Callback<ActorsMoviesDataModel>() {
                    @Override
                    public void onResponse(@NonNull Call<ActorsMoviesDataModel> call, @NonNull Response<ActorsMoviesDataModel> response) {
                        Log.d("ACTORS_MOVIES1", "Inside response");
                        actorsMoviesDataModel = response.body();
                        actorsCastAdapter = new ActorsCastAdapter(PopularActorsActivity.this, actorsMoviesDataModel);
                        actors_cast_recyclerview.setAdapter(actorsCastAdapter);
                    }

                    @Override
                    public void onFailure(@NonNull Call<ActorsMoviesDataModel> call, @NonNull Throwable t) {
                        Log.e("ACTORS_MOVIES", "onFailure: " + t);
                    }
                });
    }
}