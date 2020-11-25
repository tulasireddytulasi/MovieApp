package com.example.viewpagerbanner.networkcalls;

import com.example.viewpagerbanner.dataModel.HindiMoviesDataModel;
import com.example.viewpagerbanner.dataModel.KannadaMoviesDataModel;
import com.example.viewpagerbanner.dataModel.MoviePage1;
import com.example.viewpagerbanner.dataModel.MoviePageDataModel;
import com.example.viewpagerbanner.dataModel.Movie_Credits;
import com.example.viewpagerbanner.dataModel.NowPlaying;
import com.example.viewpagerbanner.dataModel.PopularMoviesDataModel;
import com.example.viewpagerbanner.dataModel.RecommedDataModel;
import com.example.viewpagerbanner.dataModel.StackApiRespnse;
import com.example.viewpagerbanner.dataModel.TamilMoviesDataModel;
import com.example.viewpagerbanner.dataModel.TeluguMoviesDataModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("movie/now_playing")
    Call<NowPlaying> getNowPlayingMovies(
            @Query("api_key") String api_key,
            @Query("page") int pageno
    );

    @GET("movie/popular")
    Call<PopularMoviesDataModel> getPopularMovies(
            @Query("api_key") String api_key,
            @Query("page") int pageno
    );

    @GET("movie/top_rated")
    Call<TeluguMoviesDataModel> getTopRatedMovies(
            @Query("api_key") String api_key,
            @Query("with_original_language") String language,
            @Query("page") int pageno
    );

    @GET("movie/up_coming")
    Call<PopularMoviesDataModel> getUpComingMovies(
            @Query("api_key") String api_key,
            @Query("page") int pageno
    );

    @GET("movie/now_playing")
    Call<TeluguMoviesDataModel> getTeluguNowPlayingMovies(
            @Query("api_key") String api_key,
            @Query("with_original_language") String language,
            @Query("page") int pageno
    );

    @GET("movie/now_playing")
    Call<HindiMoviesDataModel> getHindiPopularMovies(
            @Query("api_key") String api_key,
            @Query("with_original_language") String language,
            @Query("page") int pageno
    );

    @GET("movie/now_playing")
    Call<TamilMoviesDataModel> getTamilPopularMovies(
            @Query("api_key") String api_key,
            @Query("with_original_language") String language,
            @Query("page") int pageno
    );

    @GET("movie/now_playing")
    Call<KannadaMoviesDataModel> getKannadaPopularMovies(
            @Query("api_key") String api_key,
            @Query("with_original_language") String language,
            @Query("page") int pageno
    );

    @GET("movie/{movie_id}")
    Call<MoviePage1> getMovieDetails(
            @Path("movie_id") int id,
            @Query("api_key") String api_key,
            @Query("append_to_response") String credits
           // @Body MoviePageDataModel moviePageDataModel
    );

    @GET("movie/{movie_id}")
    Call<Movie_Credits> getMovieDetails2(
            @Path("movie_id") int id,
            @Query("api_key") String api_key,
            @Query("append_to_response") String credits
            // @Body MoviePageDataModel moviePageDataModel
    );

    @GET("movie/{movie_type}")
    Call<StackApiRespnse> getAll_Movies_List(
            @Path("movie_type") String movie,
            @Query("api_key") String api_key,
            @Query("with_original_language") String language,
            @Query("page") int pageno
    );


    @GET("movie/{movie_id}/recommendations")
    Call<RecommedDataModel> getRecommedMovies(
            @Path("movie_id") int id,
            @Query("api_key") String api_key
            // @Body MoviePageDataModel moviePageDataModel
    );

}


