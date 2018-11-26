package com.esiea.cookandshare.di;

import android.app.Application;

public class App extends Application
{
    NetComponent netComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();

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
