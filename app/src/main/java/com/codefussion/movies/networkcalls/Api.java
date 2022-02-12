package com.codefussion.movies.networkcalls;

import com.codefussion.movies.dataModel.ActorsDataModel;
import com.codefussion.movies.dataModel.ActorsMoviesDataModel;
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

    @GET("movie/{movie_type}")
    Call<NowPlaying> getNowPlayingMovies(
            @Path("movie_type") String movieType,
            @Query("api_key") String api_key,
            @Query("page") int pageno
    );

    @GET("movie/{movie_type}")
    Call<PopularMoviesDataModel> getPopularMovies(
            @Path("movie_type") String movieType,
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

    @GET("movie/{movie_type}")
    Call<TeluguMoviesDataModel> getTeluguNowPlayingMovies(
            @Path("movie_type") String movieType,
            @Query("api_key") String api_key,
            @Query("with_original_language") String language,
            @Query("page") int pageno
    );

    @GET("movie/{movie_type}")
    Call<HindiMoviesDataModel> getHindiPopularMovies(
            @Path("movie_type") String movieType,
            @Query("api_key") String api_key,
            @Query("with_original_language") String language,
            @Query("page") int pageno
    );

    @GET("movie/{movie_type}")
    Call<TamilMoviesDataModel> getTamilPopularMovies(
            @Path("movie_type") String movieType,
            @Query("api_key") String api_key,
            @Query("with_original_language") String language,
            @Query("page") int pageno
    );

    @GET("movie/{movie_type}")
    Call<KannadaMoviesDataModel> getKannadaPopularMovies(
            @Path("movie_type") String movieType,
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

    @GET("person/{actor_id}")
    Call<ActorsDataModel> getActorsDetails(
            @Path("actor_id") int id,
            @Query("api_key") String api_key
    );

    @GET("person/{actor_id}/movie_credits")
    Call<ActorsMoviesDataModel> getActorsMovies(
            @Path("actor_id") int id,
            @Query("api_key") String api_key
    );

}


