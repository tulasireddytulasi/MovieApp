package com.codefussion.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.codefussion.movies.Adapter.RecyclerviewAdapter;
import com.codefussion.movies.dataModel.StackApiRespnse;
import com.codefussion.movies.networkcalls.ItemViewModel;

public class All_Movies_List extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__movies__list);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        final RecyclerviewAdapter adapter = new RecyclerviewAdapter(All_Movies_List.this);

        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<StackApiRespnse.ResultsBean>>() {
            @Override
            public void onChanged(PagedList<StackApiRespnse.ResultsBean> resultsBeans) {
                adapter.submitList(resultsBeans);
            }
        });

        recyclerView.setAdapter(adapter);

    }
}