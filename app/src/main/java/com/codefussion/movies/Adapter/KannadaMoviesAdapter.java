package com.codefussion.movies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.codefussion.movies.R;
import com.codefussion.movies.dataModel.KannadaMoviesDataModel;
import com.codefussion.movies.databinding.KannadaMoviesLayoutBinding;
import com.codefussion.movies.networkcalls.OnClickListener;

import java.util.List;

public class KannadaMoviesAdapter extends RecyclerView.Adapter<KannadaMoviesAdapter.KannadaViewHolder>{

    private Context context;
    private List<KannadaMoviesDataModel.ResultsBean4> resultsBean1s;
    private OnClickListener onClickListener;

    public KannadaMoviesAdapter(Context context, List<KannadaMoviesDataModel.ResultsBean4> resultsBean1s, OnClickListener onClickListener){
        this.context =context;
        this.resultsBean1s = resultsBean1s;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public KannadaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        KannadaMoviesLayoutBinding kannadaMoviesLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.kannada_movies_layout,viewGroup,false);
        KannadaViewHolder kannadaViewHolder = new KannadaViewHolder(kannadaMoviesLayoutBinding);
        return kannadaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KannadaViewHolder viewHolder, int i) {

        KannadaMoviesDataModel.ResultsBean4 results = resultsBean1s.get(i);
        viewHolder.kannadaMoviesLayoutBinding.setUsers(results);
        viewHolder.bind(results);
        viewHolder.kannadaMoviesLayoutBinding.setListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return resultsBean1s.size();
    }

    public class KannadaViewHolder extends RecyclerView.ViewHolder {

        KannadaMoviesLayoutBinding kannadaMoviesLayoutBinding;

        public KannadaViewHolder(@NonNull KannadaMoviesLayoutBinding kannadaMoviesLayoutBinding) {
            super(kannadaMoviesLayoutBinding.getRoot());
            this.kannadaMoviesLayoutBinding = kannadaMoviesLayoutBinding;
        }
        public void bind(Object obj) {
            kannadaMoviesLayoutBinding.setVariable(com.codefussion.movies.BR.users, obj);
            kannadaMoviesLayoutBinding.executePendingBindings();
        }
    }
}

