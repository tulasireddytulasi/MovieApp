package com.codefussion.movies.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codefussion.movies.Movie_Page_Activity;
import com.codefussion.movies.R;
import com.codefussion.movies.dataModel.StackApiRespnse;

import java.util.List;

public class RecyclerviewAdapter extends PagedListAdapter<StackApiRespnse.ResultsBean, RecyclerviewAdapter.MyViewHolder> {

    private Context context;

    public RecyclerviewAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerviewlayout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final StackApiRespnse.ResultsBean resultsBean = getItem(position);
        if (resultsBean != null) {

            Glide.with(context)
                    .load("http://image.tmdb.org/t/p/w342" + resultsBean.getPoster_path())
                    .placeholder(R.drawable.movie_thumbnail)
                    .centerCrop()
                    .into(holder.imageView);

          //  holder.title.setText(resultsBean.getTitle());
            double rating1 = resultsBean.getVote_average() / 2;
            int rating = (int) rating1;
            Log.d("rating 55:", String.valueOf(rating));
           // holder.ratingBar.setRating((float) rating);

            StringBuilder genre = new StringBuilder();
            String movieGenre = "";
            List<Integer> genre_id = resultsBean.getGenre_ids();
            for(int i = 0; i < genre_id.size(); i++){
                switch (genre_id.get(i)){
                    case 28 : genre.append("Action"); break;
                    case 12 : genre.append("Adventure"); break;
                    case 16 : genre.append("Animation"); break;
                    case 35 : genre.append("Comedy"); break;
                    case 80 : genre.append("Crime"); break;
                    case 99 : genre.append("Documentary"); break;
                    case 18 : genre.append("Drama"); break;
                    case 10751 : genre.append("Family"); break;
                    case 14 : genre.append("Fantasy"); break;
                    case 36 : genre.append("History"); break;
                    case 27 : genre.append("Horror"); break;
                    case 10402 : genre.append("Music"); break;
                    case 9648 : genre.append("Mystery"); break;
                    case 10749 : genre.append("Romance"); break;
                    case 878 : genre.append("Science Fiction"); break;
                    case 10770 : genre.append("TV Movie"); break;
                    case 53 : genre.append("Thriller"); break;
                    case 10752 : genre.append("War"); break;
                    case 37 : genre.append("Western"); break;
                    default: genre = new StringBuilder("-------");
                }
                genre.append(", ");
                movieGenre = genre.toString();
                movieGenre = movieGenre.substring(0, genre.length() - 2);
            }

          //  holder.genretext.setText(movieGenre);

            Log.d("Genre 55:", movieGenre);


            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Movie_Page_Activity.class);
                    int id = (int) resultsBean.getId();
                    intent.putExtra("movie_ID", id);
                    context.startActivity(intent);
                }
            });


        } else {
            Toast.makeText(context, "No Data", Toast.LENGTH_LONG).show();
        }
    }

    private static final DiffUtil.ItemCallback<StackApiRespnse.ResultsBean> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<StackApiRespnse.ResultsBean>() {
                @Override
                public boolean areItemsTheSame(@NonNull StackApiRespnse.ResultsBean oldItem, @NonNull StackApiRespnse.ResultsBean newItem) {
                    return oldItem.getTitle() == newItem.getTitle();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull StackApiRespnse.ResultsBean oldItem, @NonNull StackApiRespnse.ResultsBean newItem) {
                    return oldItem.equals(newItem);
                }
            };

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageView;
        TextView title;
        //genretext;
        // RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card);
            imageView = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
//            genretext = itemView.findViewById(R.id.card_genre);
//            ratingBar = itemView.findViewById(R.id.movie_card_rating);
        }
    }
}
