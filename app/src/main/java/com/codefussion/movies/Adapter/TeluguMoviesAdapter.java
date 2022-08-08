package com.codefussion.movies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.codefussion.movies.BR;
import com.codefussion.movies.R;
import com.codefussion.movies.dataModel.TeluguMoviesDataModel;
import com.codefussion.movies.databinding.TeluguMoviesLayoutBinding;
import com.codefussion.movies.networkcalls.OnClickListener;

import java.util.List;

public class TeluguMoviesAdapter extends RecyclerView.Adapter<TeluguMoviesAdapter.TeluguViewHolder>{

    private Context context;
    private final List<TeluguMoviesDataModel.ResultsBean1> resultsBean1s;
    private final OnClickListener onClickListener;

    public TeluguMoviesAdapter(Context context, List<TeluguMoviesDataModel.ResultsBean1> resultsBean1s, OnClickListener onClickListener){
        this.context =context;
        this.resultsBean1s = resultsBean1s;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public TeluguViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TeluguMoviesLayoutBinding teluguMoviesLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.telugu_movies_layout,viewGroup,false);
        return new TeluguViewHolder(teluguMoviesLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TeluguViewHolder viewHolder, int i) {

        TeluguMoviesDataModel.ResultsBean1 results = resultsBean1s.get(i);
        viewHolder.teluguMoviesLayoutBinding.setUsers(results);
        viewHolder.bind(results);
        viewHolder.teluguMoviesLayoutBinding.setListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return resultsBean1s.size();
    }

    public static class TeluguViewHolder extends RecyclerView.ViewHolder {

        TeluguMoviesLayoutBinding teluguMoviesLayoutBinding;

        public TeluguViewHolder(@NonNull TeluguMoviesLayoutBinding teluguMoviesLayoutBinding) {
            super(teluguMoviesLayoutBinding.getRoot());
            this.teluguMoviesLayoutBinding = teluguMoviesLayoutBinding;
        }
        public void bind(Object obj) {
            teluguMoviesLayoutBinding.setVariable(BR.users, obj);
            teluguMoviesLayoutBinding.executePendingBindings();
        }
    }
}