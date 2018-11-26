package com.esiea.cookandshare.di;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.logging.Level;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule
{
    private String url;

    public NetModule(String url)
    {
        this.url = url;
    }

    @Provides
    OkHttpClient provideHttpClient(Cache cache)
    {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .cache(cache);
        return client.build();
    }

    @Provides
    Cache provideCache(Application application)
    {
        int cacheSize = 1024*1024*10;
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    Gson provideGson()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient client)
    {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
    }
}
