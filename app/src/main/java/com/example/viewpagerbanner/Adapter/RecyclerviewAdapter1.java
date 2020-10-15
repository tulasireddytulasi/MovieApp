package com.example.viewpagerbanner.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagerbanner.BR;
import com.example.viewpagerbanner.R;
import com.example.viewpagerbanner.dataModel.NowPlaying;
import com.example.viewpagerbanner.dataModel.PopularMoviesDataModel;
import com.example.viewpagerbanner.databinding.ItemLayoutBinding;
import com.example.viewpagerbanner.networkcalls.OnClickListener;

import java.util.List;

public class RecyclerviewAdapter1 extends RecyclerView.Adapter<RecyclerviewAdapter1.MyViewHolder> {

    private Context context;
    private List<NowPlaying.ResultsBean1> data;
    private NowPlaying.ResultsBean1 datas;
    private OnClickListener onClickListener;

    public RecyclerviewAdapter1(Context context,List<NowPlaying.ResultsBean1> data, OnClickListener onClickListener) {
        this.data = data;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemLayoutBinding itemLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.item_layout, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemLayoutBinding);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        datas = data.get(i);
        myViewHolder.itemLayoutBinding.setUser(datas);
        myViewHolder.bind(datas);
        myViewHolder.itemLayoutBinding.setListener(onClickListener);
    }

    @Override
    public int getItemCount() { return data.size(); }

//    @Override
//    public void onClick(NowPlaying.ResultsBean1 nowPlaying) {
////       NowPlaying.ResultsBean1 po = datas;
//        Toast.makeText(context, "You clicked " + nowPlaying.getTitle(),
//                Toast.LENGTH_LONG).show();
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ItemLayoutBinding itemLayoutBinding;
        public MyViewHolder(@NonNull ItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding = itemLayoutBinding;
        }

        public void bind(Object obj) {
            itemLayoutBinding.setVariable(BR.user, obj);
            itemLayoutBinding.executePendingBindings();
        }
    }
}

