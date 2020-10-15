package com.example.viewpagerbanner.dataModel;

import androidx.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.viewpagerbanner.R;

import java.util.List;

public class TamilMoviesDataModel {

    /**
     * page : 1
     * total_results : 19830
     * total_pages : 992
     * results : [{"vote_count":982,"id":429617,"video":false,"vote_average":7.8,"title":"Spider-Man: Far from Home","popularity":462.096,"poster_path":"/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg","original_language":"en","original_title":"Spider-Man: Far from Home","genre_ids":[28,12,878],"backdrop_path":"/dihW2yTsvQlust7mSuAqJDtqW7k.jpg","adult":false,"overview":"Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.","release_date":"2019-06-28"},{"vote_count":1124,"id":301528,"video":false,"vote_average":7.8,"title":"Toy Story 4","popularity":208.041,"poster_path":"/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg","original_language":"en","original_title":"Toy Story 4","genre_ids":[12,16,35,10751],"backdrop_path":"/m67smI1IIMmYzCl9axvKNULVKLr.jpg","adult":false,"overview":"Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.","release_date":"2019-06-19"},{"vote_count":2329,"id":399579,"video":false,"vote_average":6.7,"title":"Alita: Battle Angel","popularity":206.119,"poster_path":"/xRWht48C2V8XNfzvPehyClOvDni.jpg","original_language":"en","original_title":"Alita: Battle Angel","genre_ids":[28,878,53,12],"backdrop_path":"/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg","adult":false,"overview":"When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.","release_date":"2019-01-31"},{"vote_count":1391,"id":458156,"video":false,"vote_average":7.1,"title":"John Wick: Chapter 3 \u2013 Parabellum","popularity":153.118,"poster_path":"/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg","original_language":"en","original_title":"John Wick: Chapter 3 \u2013 Parabellum","genre_ids":[80,28,53],"backdrop_path":"/vVpEOvdxVBP2aV166j5Xlvb5Cdc.jpg","adult":false,"overview":"Super-assassin John Wick returns with a $14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin\u2019s guild, the High Table, John Wick is excommunicado, but the world\u2019s most ruthless hit men and women await his every turn.","release_date":"2019-05-15"},{"vote_count":2307,"id":287947,"video":false,"vote_average":7.1,"title":"Shazam!","popularity":133.368,"poster_path":"/xnopI5Xtky18MPhK40cZAGAOVeV.jpg","original_language":"en","original_title":"Shazam!","genre_ids":[28,35,14],"backdrop_path":"/bi4jh0Kt0uuZGsGJoUUfqmbrjQg.jpg","adult":false,"overview":"A boy is given the ability to become an adult superhero in times of need with a single magic word.","release_date":"2019-03-23"},{"vote_count":554,"id":456740,"video":false,"vote_average":5,"title":"Hellboy","popularity":130.287,"poster_path":"/bk8LyaMqUtaQ9hUShuvFznQYQKR.jpg","original_language":"en","original_title":"Hellboy","genre_ids":[28,12,14,27,878],"backdrop_path":"/hMbP23EkGk6tjEjRZQXhnVAl5fW.jpg","adult":false,"overview":"Hellboy comes to England, where he must defeat Nimue, Merlin's consort and the Blood Queen. But their battle will bring about the end of the world, a fate he desperately tries to turn away.","release_date":"2019-04-10"},{"vote_count":289,"id":486131,"video":false,"vote_average":6.3,"title":"Shaft","popularity":113.081,"poster_path":"/kfZqwGuvEBAysAbCsa0QLKoSYR.jpg","original_language":"en","original_title":"Shaft","genre_ids":[28,80,35],"backdrop_path":"/103d4ObBCWbB6PtOOjZ7C1FSpVl.jpg","adult":false,"overview":"JJ, aka John Shaft Jr., may be a cyber security expert with a degree from MIT, but to uncover the truth behind his best friend\u2019s untimely death, he needs an education only his dad can provide. Absent throughout JJ\u2019s youth, the legendary locked-and-loaded John Shaft agrees to help his progeny navigate Harlem\u2019s heroin-infested underbelly.","release_date":"2019-06-14"},{"vote_count":6205,"id":299537,"video":false,"vote_average":7,"title":"Captain Marvel","popularity":106.175,"poster_path":"/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg","original_language":"en","original_title":"Captain Marvel","genre_ids":[28,12,878],"backdrop_path":"/w2PMyoyLU22YvrGK3smVM9fW1jj.jpg","adult":false,"overview":"The story follows Carol Danvers as she becomes one of the universe\u2019s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all-new adventure from a previously unseen period in the history of the Marvel Cinematic Universe.","release_date":"2019-03-06"},{"vote_count":212,"id":521029,"video":false,"vote_average":6.2,"title":"Annabelle Comes Home","popularity":102.402,"poster_path":"/qWsHMrbg9DsBY3bCMk9jyYCRVRs.jpg","original_language":"en","original_title":"Annabelle Comes Home","genre_ids":[27],"backdrop_path":"/dBt0DoFfbhOI4ypUfRj1uTq623M.jpg","adult":false,"overview":"Determined to keep Annabelle from wreaking more havoc, demonologists Ed and Lorraine Warren bring the possessed doll to the locked artifacts room in their home, placing her \u201csafely\u201d behind sacred glass and enlisting a priest\u2019s holy blessing. But an unholy night of horror awaits as Annabelle awakens the evil spirits in the room, who all set their sights on a new target\u2014the Warrens' ten-year-old daughter, Judy, and her friends.","release_date":"2019-06-26"},{"vote_count":14295,"id":299536,"video":false,"vote_average":8.3,"title":"Avengers: Infinity War","popularity":102.225,"poster_path":"/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg","original_language":"en","original_title":"Avengers: Infinity War","genre_ids":[12,28,14],"backdrop_path":"/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg","adult":false,"overview":"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.","release_date":"2018-04-25"},{"vote_count":2121,"id":420817,"video":false,"vote_average":7.1,"title":"Aladdin","popularity":95.942,"poster_path":"/3iYQTLGoy7QnjcUYRJy4YrAgGvp.jpg","original_language":"en","original_title":"Aladdin","genre_ids":[12,14,10749,35,10751],"backdrop_path":"/v4yVTbbl8dE1UP2dWu5CLyaXOku.jpg","adult":false,"overview":"A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.","release_date":"2019-05-22"},{"vote_count":7,"id":420818,"video":false,"vote_average":4.2,"title":"The Lion King","popularity":94.717,"poster_path":"/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg","original_language":"en","original_title":"The Lion King","genre_ids":[12,16,10751,18],"backdrop_path":"/1TUg5pO1VZ4B0Q1amk3OlXvlpXV.jpg","adult":false,"overview":"Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother\u2014and former heir to the throne\u2014has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.","release_date":"2019-07-12"},{"vote_count":7543,"id":299534,"video":false,"vote_average":8.4,"title":"Avengers: Endgame","popularity":94.546,"poster_path":"/or06FN3Dka5tukK1e9sl16pB3iy.jpg","original_language":"en","original_title":"Avengers: Endgame","genre_ids":[12,878,28],"backdrop_path":"/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg","adult":false,"overview":"After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.","release_date":"2019-04-24"},{"vote_count":7683,"id":920,"video":false,"vote_average":6.7,"title":"Cars","popularity":94.35,"poster_path":"/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg","original_language":"en","original_title":"Cars","genre_ids":[16,12,35,10751],"backdrop_path":"/a1MlbLBk5Sy6YvMbSuKfwGlDVlb.jpg","adult":false,"overview":"Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.","release_date":"2006-06-08"},{"vote_count":19,"id":566555,"video":false,"vote_average":5.2,"title":"Detective Conan: The Fist of Blue Sapphire","popularity":89.812,"poster_path":"/86Y6qM8zTn3PFVfCm9J98Ph7JEB.jpg","original_language":"ja","original_title":"名探偵コナン 紺青の拳（フィスト）","genre_ids":[16,28,18,9648,35],"backdrop_path":"/wf6VDSi4aFCZfuD8sX8JAKLfJ5m.jpg","adult":false,"overview":"23rd movie in the \"Detective Conan\" franchise.","release_date":"2019-04-12"},{"vote_count":1144,"id":320288,"video":false,"vote_average":6.3,"title":"Dark Phoenix","popularity":83.856,"poster_path":"/kZv92eTc0Gg3mKxqjjDAM73z9cy.jpg","original_language":"en","original_title":"Dark Phoenix","genre_ids":[878,28],"backdrop_path":"/phxiKFDvPeQj4AbkvJLmuZEieDU.jpg","adult":false,"overview":"The X-Men face their most formidable and powerful foe when one of their own, Jean Grey, starts to spiral out of control. During a rescue mission in outer space, Jean is nearly killed when she's hit by a mysterious cosmic force. Once she returns home, this force not only makes her infinitely more powerful, but far more unstable. The X-Men must now band together to save her soul and battle aliens that want to use Grey's new abilities to rule the galaxy.","release_date":"2019-06-05"},{"vote_count":6,"id":553100,"video":false,"vote_average":7.3,"title":"Wild and Free","popularity":77.756,"poster_path":"/jLGNqaymD0ygyhafhv5fM3nXcge.jpg","original_language":"tl","original_title":"Wild and Free","genre_ids":[18],"backdrop_path":"/9v4nPAyVvtGONV5NtPkDHA9bczS.jpg","adult":false,"overview":"Ellie and Jake fall in love, but struggle with their relationship when they discover an unexpected connection between their pasts.","release_date":"2018-10-10"},{"vote_count":1484,"id":329996,"video":false,"vote_average":6.5,"title":"Dumbo","popularity":76.963,"poster_path":"/A7XkpLfNH0El2yyDLc4b0KLAKvE.jpg","original_language":"en","original_title":"Dumbo","genre_ids":[12,10751,14],"backdrop_path":"/5tFt6iuGnKapHl5tw0X0cKcnuVo.jpg","adult":false,"overview":"A young elephant, whose oversized ears enable him to fly, helps save a struggling circus, but when the circus plans a new venture, Dumbo and his friends discover dark secrets beneath its shiny veneer.","release_date":"2019-03-27"},{"vote_count":937,"id":157433,"video":false,"vote_average":5.8,"title":"Pet Sematary","popularity":73.852,"poster_path":"/7SPhr7Qj39vbnfF9O2qHRYaKHAL.jpg","original_language":"en","original_title":"Pet Sematary","genre_ids":[53,9648,27],"backdrop_path":"/n2aX63BmW7zIKgKJ58e6rKlSsdi.jpg","adult":false,"overview":"Dr. Louis Creed and his wife, Rachel, relocate from Boston to rural Maine with their two young children. The couple soon discover a mysterious burial ground hidden deep in the woods near their new home. When tragedy strikes, Louis turns to his neighbour Jud Crandall, setting off a perilous chain reaction that unleashes an unspeakable evil with horrific consequences.","release_date":"2019-04-04"},{"vote_count":11832,"id":315635,"video":false,"vote_average":7.4,"title":"Spider-Man: Homecoming","popularity":72.735,"poster_path":"/kY2c7wKgOfQjvbqe7yVzLTYkxJO.jpg","original_language":"en","original_title":"Spider-Man: Homecoming","genre_ids":[28,12,878,18],"backdrop_path":"/vc8bCGjdVp0UbMNLzHnHSLRbBWQ.jpg","adult":false,"overview":"Following the events of Captain America: Civil War, Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in Queens, New York City, with fighting crime as his superhero alter ego Spider-Man as a new threat, the Vulture, emerges.","release_date":"2017-07-05"}]
     */

    private int page;
    private long total_results;
    private long total_pages;
    private List<ResultsBean3> results;

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

    public List<ResultsBean3> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean3> results) {
        this.results = results;
    }

    public static class ResultsBean3 {
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
         * overview : Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.
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

        @BindingAdapter({"imageUrlThree"})
        public static void setProfileImage(ImageView imageView, String poster_path){
            Glide.with(imageView.getContext())
                    .load(poster_path)
                    .placeholder(R.drawable.poster)
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



