package com.esiea.cookandshare.presentation;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.esiea.cookandshare.R;
import com.esiea.cookandshare.data.Post;
import com.esiea.cookandshare.data.RestAPI;
import com.esiea.cookandshare.di.App;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
{
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        
        ((App) getApplication()).getNetComponent().injectMainActivity(this);
        Observable<List<Post>> call = retrofit.create(RestAPI.class).getPosts();

        Observer<List<Post>> observer = new Observer<List<Post>>()
        {
            @Override
            public void onSubscribe(Disposable disposable) {}

            @Override
            public void onNext(List<Post> posts)
            {
                for (Post post : posts)
                {
                    Log.d("TEST", post.getName());
                }
            }

            @Override
            public void onError(Throwable throwable)
            {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d("TEST", "");
            }
        };

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
