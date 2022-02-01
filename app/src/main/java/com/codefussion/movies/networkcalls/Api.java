package com.codefussion.movies.networkcalls;

import com.codefussion.movies.dataModel.HindiMoviesDataModel;
import com.codefussion.movies.dataModel.KannadaMoviesDataModel;
import com.codefussion.movies.dataModel.MoviePage1;
import com.codefussion.movies.dataModel.Movie_Credits;
import com.codefussion.movies.dataModel.NowPlaying;
import com.codefussion.movies.dataModel.PopularMoviesDataModel;
import com.codefussion.movies.dataModel.RecommedDataModel;
import com.codefussion.movies.dataModel.StackApiRespnse;
import com.codefussion.movies.dataModel.TamilMoviesDataModel;
import com.codefussion.movies.dataModel.TeluguMoviesDataModel;
import retrofit2.Call;
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

    @GET("movie/popular")
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

    @GET("movie/popular")
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

