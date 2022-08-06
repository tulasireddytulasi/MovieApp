package com.codefussion.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codefussion.movies.Adapter.RecyclerviewAdapter;
import com.codefussion.movies.networkcalls.ItemViewModel;
import com.codefussion.movies.networkcalls.OnClickListener2;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import de.hdodenhof.circleimageview.CircleImageView;

public class All_Movies_List extends AppCompatActivity implements OnClickListener2 {

    private BottomSheetDialog bottomSheetDialog;
    private TextView movie_title;
    private TextView movie_release_date;
    private TextView overview;
    private ImageView movie_poster;
    private RelativeLayout infoCard;
    private RelativeLayout movieInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__movies__list);
        bottomSheetDialog = new BottomSheetDialog(this, R.style.BottomSheetStyle);
        setBottomSheetContent();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recyclerView.setHasFixedSize(true);

        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        final RecyclerviewAdapter adapter = new RecyclerviewAdapter(All_Movies_List.this, All_Movies_List.this);

        itemViewModel.itemPagedList.observe(this, adapter::submitList);

        recyclerView.setAdapter(adapter);
        bottomSheetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private void setBottomSheetContent() {
        View view = getLayoutInflater().inflate(R.layout.movie_bottom_sheet, null, false);
        bottomSheetDialog.setContentView(view);
        CircleImageView closeDialog = view.findViewById(R.id.close_dialog);
        movie_title = view.findViewById(R.id.movie_title);
        movie_release_date = view.findViewById(R.id.movie_year);
        overview = view.findViewById(R.id.movie_overview);
        movie_poster = view.findViewById(R.id.movie_poster);
        infoCard = view.findViewById(R.id.info_card);
        movieInfo = view.findViewById(R.id.movie_info);
        closeDialog.setOnClickListener(view1 -> {
            bottomSheetDialog.dismiss();
        });
    }

    @Override
    public void onClick(int movieId, String movie_poster_value, String movie_title_value, String overview_value, String date_value) {
        openDialog(movieId, movie_poster_value, movie_title_value, overview_value, date_value);
    }

    void openDialog(int movie_id, String movie_poster_value, String movie_title_value, String overview_value, String date_value){
        Intent intent = new Intent(getApplicationContext(), Movie_Page_Activity.class);
        movie_title.setText(movie_title_value);
        overview.setText(overview_value);
        movie_release_date.setText(date_value);
        Glide.with(getApplicationContext())
                .load("http://image.tmdb.org/t/p/w342" + movie_poster_value)
                .placeholder(R.drawable.movie_thumbnail)
                .centerCrop()
                .into(movie_poster);
        if (movie_id != 0){
            if(bottomSheetDialog.isShowing()){
                bottomSheetDialog.dismiss();
            }
            bottomSheetDialog.show();
            movieInfo.setOnClickListener(view -> {
                bottomSheetDialog.dismiss();
                intent.putExtra("movie_ID", movie_id);
                startActivity(intent);
            });

            infoCard.setOnClickListener(view -> {
                bottomSheetDialog.dismiss();
                intent.putExtra("movie_ID", movie_id);
                startActivity(intent);
            });


        }else {
            Toast.makeText(getApplicationContext(), "No Data of this Movie", Toast.LENGTH_SHORT).show();
        }
    }

}