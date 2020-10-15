package com.example.viewpagerbanner.networkcalls;

import android.widget.ImageView;

import com.example.viewpagerbanner.dataModel.HindiMoviesDataModel;
import com.example.viewpagerbanner.dataModel.KannadaMoviesDataModel;
import com.example.viewpagerbanner.dataModel.NowPlaying;
import com.example.viewpagerbanner.dataModel.TamilMoviesDataModel;
import com.example.viewpagerbanner.dataModel.TeluguMoviesDataModel;

public interface OnClickListener {
    void onClick(NowPlaying.ResultsBean1 nowPlaying);
    void onTeluguMoviesClick(TeluguMoviesDataModel.ResultsBean1 telugumovies);
    void onHindiMovieClick(HindiMoviesDataModel.ResultsBean2 hindimovies);
    void onTamilMovieClick(TamilMoviesDataModel.ResultsBean3 tamilmovies);
    void onKannadaMovieClick(KannadaMoviesDataModel.ResultsBean4 kannadamovies);
}
