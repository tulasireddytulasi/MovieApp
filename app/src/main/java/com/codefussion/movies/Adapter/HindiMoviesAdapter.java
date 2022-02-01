package com.codefussion.movies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.codefussion.movies.R;
import com.codefussion.movies.dataModel.HindiMoviesDataModel;
import com.codefussion.movies.databinding.HindiMoviesLayoutBinding;
import com.codefussion.movies.networkcalls.OnClickListener;

import java.util.List;

public class HindiMoviesAdapter extends RecyclerView.Adapter<HindiMoviesAdapter.HindiViewHolder>{

    private Context context;
    private List<HindiMoviesDataModel.ResultsBean2> resultsBean1s;
    private OnClickListener onClickListener;

    public HindiMoviesAdapter(Context context, List<HindiMoviesDataModel.ResultsBean2> resultsBean1s, OnClickListener onClickListener){
        this.context =context;
        this.resultsBean1s = resultsBean1s;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public HindiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        HindiMoviesLayoutBinding teluguMoviesLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.hindi_movies_layout,viewGroup,false);
        HindiViewHolder teluguViewHolder = new HindiViewHolder(teluguMoviesLayoutBinding);
        return teluguViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HindiViewHolder viewHolder, int i) {

        HindiMoviesDataModel.ResultsBean2 results = resultsBean1s.get(i);
        viewHolder.hindiMoviesLayoutBinding.setUsers(results);
        viewHolder.bind(results);
        viewHolder.hindiMoviesLayoutBinding.setListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return resultsBean1s.size();
    }

    public class HindiViewHolder extends RecyclerView.ViewHolder {

        HindiMoviesLayoutBinding hindiMoviesLayoutBinding;

        public HindiViewHolder(@NonNull HindiMoviesLayoutBinding hindiMoviesLayoutBinding) {
            super(hindiMoviesLayoutBinding.getRoot());
            this.hindiMoviesLayoutBinding = hindiMoviesLayoutBinding;
        }
        public void bind(Object obj) {
            hindiMoviesLayoutBinding.setVariable(com.codefussion.movies.BR.users, obj);
            hindiMoviesLayoutBinding.executePendingBindings();
        }
    }
}

