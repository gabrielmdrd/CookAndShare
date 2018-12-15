package com.esiea.cookandshare.di;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.esiea.cookandshare.databinding.AppDataBindingComponent;

public class App extends Application
{
    NetComponent netComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());

        netComponent = DaggerNetComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule("http://51.38.32.199/"))
                .build();
    }

    public NetComponent getNetComponent()
    {
        return netComponent;
    }
}
