package com.codefussion.movies.networkcalls;

import com.codefussion.movies.dataModel.HindiMoviesDataModel;
import com.codefussion.movies.dataModel.KannadaMoviesDataModel;
import com.codefussion.movies.dataModel.NowPlaying;
import com.codefussion.movies.dataModel.TamilMoviesDataModel;
import com.codefussion.movies.dataModel.TeluguMoviesDataModel;

public interface OnClickListener {
    void onClick(NowPlaying.ResultsBean1 nowPlaying);
    void onTeluguMoviesClick(TeluguMoviesDataModel.ResultsBean1 telugumovies);
    void onHindiMovieClick(HindiMoviesDataModel.ResultsBean2 hindimovies);
    void onTamilMovieClick(TamilMoviesDataModel.ResultsBean3 tamilmovies);
    void onKannadaMovieClick(KannadaMoviesDataModel.ResultsBean4 kannadamovies);
    void onClickViewPager(int movieId, String movie_poster_value, String movie_title_value, String overview_value, String date_value);
}
