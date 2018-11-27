package com.esiea.cookandshare.presentation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.esiea.cookandshare.data.RestAPI;
import com.esiea.cookandshare.data.Ingredient;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class AppViewModel extends ViewModel
{
    @Inject
    Retrofit retrofit;

    public MutableLiveData<List<Ingredient>> ingredientsList;
    public MutableLiveData<Boolean> goToRegisterActivity = new MutableLiveData<>();
    public MutableLiveData<Boolean> goToLoginActivity = new MutableLiveData<>();

    public LiveData<List<Ingredient>> getIngredientsList()
    {
        if (ingredientsList == null)
        {
            ingredientsList = new MutableLiveData<List<Ingredient>>();
            loadIngredients();
        }

        return ingredientsList;
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
                    ingredientsList.postValue(ingredients);
                }
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

    public LiveData<Boolean> onClickedSignUpBtn()
    {
        goToRegisterActivity.setValue(true);

        return goToRegisterActivity;
    }

    public LiveData<Boolean> onClickedSignInBtn()
    {
        goToLoginActivity.setValue(true);

        return goToLoginActivity;
    }

    public void registerUser(String username, String password)
    {

    }
}
