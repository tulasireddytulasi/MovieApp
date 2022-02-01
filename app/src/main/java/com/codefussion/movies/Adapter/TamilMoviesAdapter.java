package com.codefussion.movies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.codefussion.movies.R;
import com.codefussion.movies.dataModel.TamilMoviesDataModel;
import com.codefussion.movies.databinding.TamilMoviesLayoutBinding;
import com.codefussion.movies.networkcalls.OnClickListener;

import java.util.List;

public class TamilMoviesAdapter extends RecyclerView.Adapter<TamilMoviesAdapter.TamilViewHolder>{

    private Context context;
    private List<TamilMoviesDataModel.ResultsBean3> resultsBean1s;
    private OnClickListener onClickListener;

    public TamilMoviesAdapter(Context context, List<TamilMoviesDataModel.ResultsBean3> resultsBean1s, OnClickListener onClickListener){
        this.context =context;
        this.resultsBean1s = resultsBean1s;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public TamilViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TamilMoviesLayoutBinding tamilMoviesLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.tamil_movies_layout,viewGroup,false);
        TamilViewHolder tamilViewHolder = new TamilViewHolder(tamilMoviesLayoutBinding);
        return tamilViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TamilViewHolder viewHolder, int i) {
        TamilMoviesDataModel.ResultsBean3 results = resultsBean1s.get(i);
        viewHolder.tamilMoviesLayoutBinding.setUsers(results);
        viewHolder.bind(results);
        viewHolder.tamilMoviesLayoutBinding.setListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return resultsBean1s.size();
    }

    public class TamilViewHolder extends RecyclerView.ViewHolder {

        TamilMoviesLayoutBinding tamilMoviesLayoutBinding;

        public TamilViewHolder(@NonNull TamilMoviesLayoutBinding tamilMoviesLayoutBinding) {
            super(tamilMoviesLayoutBinding.getRoot());
            this.tamilMoviesLayoutBinding = tamilMoviesLayoutBinding;
        }
        public void bind(Object obj) {
            tamilMoviesLayoutBinding.setVariable(com.codefussion.movies.BR.users, obj);
            tamilMoviesLayoutBinding.executePendingBindings();
        }
    }
}

