package com.esiea.cookandshare.presentation.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.esiea.cookandshare.BR;
import com.esiea.cookandshare.data.DataAdapter;
import com.esiea.cookandshare.data.Ingredient;
import com.esiea.cookandshare.data.RestAPI;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class DataViewModel extends BaseObservable
{
    @Inject
    Retrofit retrofit;

    private static final String TAG = "DataViewModel";
    private DataAdapter adapter;
    private List<Ingredient> data;

    public DataViewModel()
    {
        data = new ArrayList<Ingredient>();
        adapter = new DataAdapter();
    }

    public void setUp()
    {
        loadIngredients();
    }

    public void tearDown()
    {

    }

    @Bindable
    public List<Ingredient> getData()
    {
        return this.data;
    }

    @Bindable
    public DataAdapter getAdapter()
    {
        return this.adapter;
    }

    private void loadIngredients()
    {
        Observable<List<Ingredient>> call = retrofit.create(RestAPI.class).getIngredients();

        Observer<List<Ingredient>> observer = new Observer<List<Ingredient>>()
        {
            @Override
            public void onSubscribe(Disposable disposable) {}

            @Override
            public void onNext(List<Ingredient> ingredients)
            {
                for (Ingredient ingredient : ingredients)
                {
                    data.add(ingredient);
                }
                notifyPropertyChanged(BR.data);
            }

            @Override
            public void onError(Throwable throwable)
            {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d("LOADED", "INGREDIENTS");
            }
        };

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
