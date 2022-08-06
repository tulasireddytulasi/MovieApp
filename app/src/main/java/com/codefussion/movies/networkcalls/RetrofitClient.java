package com.codefussion.movies.networkcalls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static RetrofitClient minstance;
    private final Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(minstance == null){
            minstance = new RetrofitClient();
        }
        return minstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}

