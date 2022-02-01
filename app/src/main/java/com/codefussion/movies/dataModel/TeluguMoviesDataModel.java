package com.codefussion.movies.dataModel;

import androidx.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codefussion.movies.R;

import java.util.List;

public class TeluguMoviesDataModel {

    private int page;
    private long total_results;
    private long total_pages;
    private List<ResultsBean1> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal_results() {
        return total_results;
    }

    public void setTotal_results(long total_results) {
        this.total_results = total_results;
    }

    public long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(long total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultsBean1> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean1> results) {
        this.results = results;
    }

    public static class ResultsBean1 {
        /**
         * vote_count : 982
         * id : 429617
         * video : false
         * vote_average : 7.8
         * title : Spider-Man: Far from Home
         * popularity : 462.096
         * poster_path : /rjbNpRMoVvqHmhmksbokcyCr7wn.jpg
         * original_language : en
         * original_title : Spider-Man: Far from Home
         * genre_ids : [28,12,878]
         * backdrop_path : /dihW2yTsvQlust7mSuAqJDtqW7k.jpg
         * adult : false
         * overview : Peter Parker and his friends go on a summer trip to Europe.
         * However, they will hardly be able to rest - Peter
         * will have to agree to help Nick Fury uncover the mystery of
         * creatures that cause natural disasters and destruction
         * throughout the continent.
         * release_date : 2019-06-28
         */

        private int vote_count;
        private long id;
        private boolean video;
        private double vote_average;
        private String title;
        private double popularity;
        private String poster_path;
        private String original_language;
        private String original_title;
        private String backdrop_path;
        private boolean adult;
        private String overview;
        private String release_date;
        private List<Integer> genre_ids;

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return  "http://image.tmdb.org/t/p/w342/"+poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        @BindingAdapter({"imageUrlOne"})
        public static void setProfileImage(ImageView imageView, String poster_path){
            Glide.with(imageView.getContext())
                    .load(poster_path)
                    .placeholder(R.drawable.movie_thumbnail)
                    .centerCrop()
                    .into(imageView);
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}



