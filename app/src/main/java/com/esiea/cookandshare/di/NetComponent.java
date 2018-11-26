package com.esiea.cookandshare.di;

import com.esiea.cookandshare.presentation.MainActivity;

import dagger.Component;

@Component (modules = {ApplicationModule.class, NetModule.class})
public interface NetComponent
{
    void injectMainActivity(MainActivity mainActivity);
}
