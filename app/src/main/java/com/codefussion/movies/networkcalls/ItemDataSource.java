package com.codefussion.movies.networkcalls;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import com.codefussion.movies.dataModel.StackApiRespnse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.codefussion.movies.MainActivity.language;
import static com.codefussion.movies.MainActivity.movie_type;

public class ItemDataSource extends PageKeyedDataSource<Integer, StackApiRespnse.ResultsBean> {

    private static final int PAGE_NO = 1;
    private static final String API_KEY = "434fcadef5103207fecca9176385a533";
    //private String language = "en";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, StackApiRespnse.ResultsBean> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getAll_Movies_List(movie_type, API_KEY, language, PAGE_NO)
                .enqueue(new Callback<StackApiRespnse>() {
                    @Override
                    public void onResponse(Call<StackApiRespnse> call, Response<StackApiRespnse> response) {
                        if (response.body() != null){
                            callback.onResult(response.body().getResults(),null,PAGE_NO + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiRespnse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, StackApiRespnse.ResultsBean> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getAll_Movies_List(movie_type, API_KEY, language, params.key)
                .enqueue(new Callback<StackApiRespnse>() {
                    @Override
                    public void onResponse(Call<StackApiRespnse> call, Response<StackApiRespnse> response) {
                        Integer key = (params.key > 1) ? params.key -1 : null;
                        if (response.body() != null){
                            callback.onResult(response.body().getResults(),key);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiRespnse> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, StackApiRespnse.ResultsBean> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getAll_Movies_List(movie_type, API_KEY, language, params.key)
                .enqueue(new Callback<StackApiRespnse>() {
                    @Override
                    public void onResponse(Call<StackApiRespnse> call, Response<StackApiRespnse> response) {
                        Integer key = (params.key < 992) ? params.key +1 : null;
                        if (response.body() != null){
                            callback.onResult(response.body().getResults(),key);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiRespnse> call, Throwable t) {

                        Log.i("Item", String.valueOf(t));
                        Log.i("Item", String.valueOf(t));
                        Log.i("Item", String.valueOf(t));
                    }
                });
    }
}
