package com.example.viewpagerbanner.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagerbanner.BR;
import com.example.viewpagerbanner.R;
import com.example.viewpagerbanner.dataModel.TeluguMoviesDataModel;
import com.example.viewpagerbanner.databinding.TeluguMoviesLayoutBinding;
import com.example.viewpagerbanner.networkcalls.OnClickListener;

import java.util.List;

public class TeluguMoviesAdapter extends RecyclerView.Adapter<TeluguMoviesAdapter.TeluguViewHolder>{

    private Context context;
    private List<TeluguMoviesDataModel.ResultsBean1> resultsBean1s;
    private OnClickListener onClickListener;

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
        TeluguViewHolder teluguViewHolder = new TeluguViewHolder(teluguMoviesLayoutBinding);
        return teluguViewHolder;
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

    public class TeluguViewHolder extends RecyclerView.ViewHolder {

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