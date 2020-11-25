package com.example.viewpagerbanner.dataModel;

import java.util.List;

public class Movie_page {

    private Credits credits;
    private int vote_count;
    private double vote_average;
    private boolean video;
    private String title;
    private String tagline;
    private String status;
    private List<Spoken_languages> spoken_languages;
    private int runtime;
    private int revenue;
    private String release_date;
    private List<Production_countries> production_countries;
    private List<Production_companies> production_companies;
    private String poster_path;
    private double popularity;
    private String overview;
    private String original_title;
    private String original_language;
    private String imdb_id;
    private int id;
    private String homepage;
    private List<Genres> genres;
    private int budget;
    private String backdrop_path;
    private boolean adult;

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Spoken_languages> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<Spoken_languages> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<Production_countries> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<Production_countries> production_countries) {
        this.production_countries = production_countries;
    }

    public List<Production_companies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<Production_companies> production_companies) {
        this.production_companies = production_companies;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public static class Credits {
        private List<Crew> crew;
        private List<Cast> cast;

        public List<Crew> getCrew() {
            return crew;
        }

        public void setCrew(List<Crew> crew) {
            this.crew = crew;
        }

        public List<Cast> getCast() {
            return cast;
        }

        public void setCast(List<Cast> cast) {
            this.cast = cast;
        }
    }

    public static class Crew {
        private String job;
        private String department;
        private String credit_id;
        private String profile_path;
        private double popularity;
        private String original_name;
        private String name;
        private String known_for_department;
        private int id;
        private int gender;
        private boolean adult;

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getOriginal_name() {
            return original_name;
        }

        public void setOriginal_name(String original_name) {
            this.original_name = original_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKnown_for_department() {
            return known_for_department;
        }

        public void setKnown_for_department(String known_for_department) {
            this.known_for_department = known_for_department;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public boolean getAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }
    }

    public static class Cast {
        private int order;
        private String credit_id;
        private String character;
        private int cast_id;
        private String profile_path;
        private double popularity;
        private String original_name;
        private String name;
        private String known_for_department;
        private int id;
        private int gender;
        private boolean adult;

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public int getCast_id() {
            return cast_id;
        }

        public void setCast_id(int cast_id) {
            this.cast_id = cast_id;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getOriginal_name() {
            return original_name;
        }

        public void setOriginal_name(String original_name) {
            this.original_name = original_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKnown_for_department() {
            return known_for_department;
        }

        public void setKnown_for_department(String known_for_department) {
            this.known_for_department = known_for_department;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public boolean getAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }
    }

    public static class Spoken_languages {
        private String name;
        private String iso_639_1;
        private String english_name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public String getEnglish_name() {
            return english_name;
        }

        public void setEnglish_name(String english_name) {
            this.english_name = english_name;
        }
    }

    public static class Production_countries {
        private String name;
        private String iso_3166_1;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso_3166_1() {
            return iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }
    }

    public static class Production_companies {
        private String origin_country;
        private String name;
        private String logo_path;
        private int id;

        public String getOrigin_country() {
            return origin_country;
        }

        public void setOrigin_country(String origin_country) {
            this.origin_country = origin_country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo_path() {
            return logo_path;
        }

        public void setLogo_path(String logo_path) {
            this.logo_path = logo_path;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class Genres {
        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
